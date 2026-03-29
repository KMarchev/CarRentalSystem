package helper;

import car.CarRepository;

public class ValueValidator {

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
