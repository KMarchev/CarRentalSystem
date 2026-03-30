package helper;

import car.CarRepository;
import customer.CustomerRepository;
import rental.RentalRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValueValidator {

    public static boolean isValidRental(String value){
        try{
            int idCar=Integer.parseInt(value);
            return !RentalRepository.getInstance().searchByIdForCar(idCar);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidDate(String value){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate.parse(value.trim(), formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidIdCustomer(String value){
        try{
            int id=Integer.parseInt(value);
            return id > 0
                    && id < Integer.MAX_VALUE - 1
                    && CustomerRepository.getInstance().searchById(id) == -1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidId(String value){
        try{
            int id=Integer.parseInt(value);
            return id > 0
                    && id < Integer.MAX_VALUE - 1
                    && CarRepository.getInstance().searchById(id) == -1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidYear(String value){
        try{
            int id=Integer.parseInt(value);
            return id >= 1886
                    && id <= 2026;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidName(String value){
        return value!=null
                && !value.isBlank();
    }

    public static boolean isValidAvailability(String value){
        return value.equals("Available")
                || value.equals("Rented");
    }
}
