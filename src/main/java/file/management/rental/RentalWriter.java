package file.management.rental;

import customer.CustomerRepository;
import customer.classes.Customer;
import exception.FileException;
import rental.RentalRepository;
import rental.classes.Rental;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class RentalWriter {

    public static void writeToFile(){
        String filePath="src/main/resource/rental.csv";
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath))) {
            br.write("IdCar,IdCustomer,ExpectedReturnDate");
            br.newLine();
            for(Rental rental : RentalRepository.getInstance().getRentalList()){
                br.write(String.format("%d,%s,%s",rental.getCarId(),rental.getCustomerId(),rental.getFormattedTime()));
                br.newLine();
            }
        } catch (Exception e) {
            throw new FileException("Please make sure your files are written correctly!");
        }
    }

}
