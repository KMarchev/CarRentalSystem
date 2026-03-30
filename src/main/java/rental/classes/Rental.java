package rental.classes;

import car.CarRepository;
import customer.CustomerRepository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a car rental.
 *
 * Stores information about which car is rented,
 * which customer rented it, and the expected return date.
 */
public class Rental {
    private int carId;
    private int customerId;
    private LocalDateTime expectedReturn;

    public Rental(int carId, int customerId, LocalDateTime expectedReturn) {
        this.carId = carId;
        this.customerId = customerId;
        this.expectedReturn=expectedReturn;
    }

    public int getCarId() {
        return carId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDateTime getExpectedReturn(){
        return expectedReturn;
    }

    /**
     * Formats the expected return date as a readable string.
     *
     * @return formatted date (dd-MM-yyyy)
     */
    public String getFormattedTime(){
        return expectedReturn.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String toString() {
        return String.format("Car: %s\nCustomer: %s\nExpected Return Date: %s\n"
                ,CarRepository.getInstance().getCar(carId)
                ,CustomerRepository.getInstance().getCustomerById(customerId)
                ,getFormattedTime());
    }
}
