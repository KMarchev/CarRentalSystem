package file.management.customer;

import car.CarRepository;
import car.classes.CarFactory;
import customer.CustomerRepository;
import customer.classes.Customer;
import exception.FileException;
import helper.ValueValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Utility class responsible for reading customer data from a CSV file and populating the CustomerRepository.
 */
public class CustomerReader {
    public static void readFromFile(){
        String filePath="src/main/resource/customer.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] params = line.split(",");
                if(!ValueValidator.isValidIdCustomer(params[0])
                        || !ValueValidator.isValidName(params[1])){
                    throw new FileException("Please make sure your files are written correctly!");
                }

                CustomerRepository.getInstance().addCustomer(new Customer(Integer.parseInt(params[0]),params[1]));

            }
        } catch (Exception e) {
            throw new FileException("Please make sure your files are written correctly!");
        }
    }
}
