package file.management.customer;

import customer.CustomerRepository;
import customer.classes.Customer;
import exception.FileException;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CustomerWriter {

    public static void writeToFile(){
        String filePath="src/main/resource/customer.csv";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath))) {
            br.write("Id,Name");
            br.newLine();
            for(Customer customer : CustomerRepository.getInstance().getCustomerList()){
                br.write(String.format("%d,%s",customer.getId(),customer.getName()));
                br.newLine();
            }
        } catch (Exception e) {
            throw new FileException("Please make sure your files are written correctly!");
        }
    }

}
