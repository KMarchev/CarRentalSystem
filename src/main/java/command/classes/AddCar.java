package command.classes;

import car.CarRepository;
import car.classes.Car;
import car.classes.CarFactory;
import command.interfaces.Command;
import exception.CommandException;

import java.util.Arrays;
import java.util.Scanner;

/**
 * {@link command.interfaces.Command} to create a new car and add it to the CarRepository.
 */

public class AddCar implements Command {

    /**
     * Executes the create command for Car.
     *
     * @param args not used.
     * @throws CommandException if user input is invalid.
     */

    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Add car: ");
        String[] params = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .toArray(String[]::new);
        if(params.length!=5){
            throw new CommandException("Invalid arguments for creation of Car!");
        }

        Car car = CarFactory.createCar(params);

        if(car==null){
            throw new CommandException("Invalid arguments for car creation!");
        }
        CarRepository.getInstance().addCar(car);

    }
}
