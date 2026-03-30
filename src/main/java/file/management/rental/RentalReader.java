package file.management.rental;

import car.CarRepository;
import customer.CustomerRepository;
import customer.classes.Customer;
import exception.CommandException;
import exception.FileException;
import helper.ValueValidator;
import rental.RentalRepository;
import rental.classes.Rental;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class responsible for reading rental data from a CSV file and populating the CarRepository.
 */
public class RentalReader {
    public static void readFromFile(){
        String filePath="src/main/resource/rental.csv";
        CarRepository carRepository = CarRepository.getInstance();
        CustomerRepository customerRepository = CustomerRepository.getInstance();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] params = line.split(",");

                if (params.length != 3
                        || !ValueValidator.isValidRental(params[0])
                        || carRepository.searchById(Integer.parseInt(params[0])) == -1
                        || customerRepository.searchById(Integer.parseInt(params[1])) == -1
                        || !ValueValidator.isValidDate(params[2])) {

                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDateTime expectedReturn = LocalDate.parse(params[2], formatter).atStartOfDay();

                RentalRepository.getInstance()
                        .addRental(new Rental(
                                Integer.parseInt(params[0]),
                                Integer.parseInt(params[1]),
                                expectedReturn
                        ));
                carRepository.getCar(Integer.parseInt(params[0])).setAvailable(false);
            }
        } catch (Exception e) {
            throw new FileException(e.getMessage());
        }
    }
}
