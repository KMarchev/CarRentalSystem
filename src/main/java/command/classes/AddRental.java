package command.classes;

import car.CarRepository;
import command.interfaces.Command;
import customer.CustomerRepository;
import exception.CommandException;
import helper.ValueValidator;
import rental.RentalRepository;
import rental.classes.Rental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class AddRental implements Command {
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CarRepository carRepository=CarRepository.getInstance();
        CustomerRepository customerRepository=CustomerRepository.getInstance();

        System.out.print("Add Rental(ID of Car, ID of Customer, Expected return date): For example - 1,1,20-04-2005\n");

        String[] params = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).toArray(String[]::new);

        if (params.length != 3
                || carRepository.searchById(Integer.parseInt(params[0])) == -1
                || customerRepository.searchById(Integer.parseInt(params[1])) == -1
                || !ValueValidator.isValidDate(params[2])) {
            throw new CommandException("Invalid arguments for rental creation!");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime expectedReturn = LocalDate.parse(params[2], formatter).atStartOfDay();

        RentalRepository.getInstance()
                .addRental(new Rental(
                        Integer.parseInt(params[0]),
                        Integer.parseInt(params[1]),
                        expectedReturn
                ));
        carRepository.getCar(Integer.parseInt(params[1])).setAvailable(false);
        System.out.println("Rental added successfully!");
    }
}
