package command.classes;

import car.CarRepository;
import car.classes.Car;
import command.interfaces.Command;
import exception.CommandException;

import java.util.Scanner;

/**
 * {@link command.interfaces.Command} to search for a car in the CarRepository based on model.
 */
public class SearchCarByModel implements Command {
    /**
     * Executes the 'search by model' command for Car.
     *
     * @param args not used.
     * @throws CommandException if user input is invalid.
     */
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Model: ");
        CarRepository.getInstance()
                .getCarsByModel(scanner.nextLine().trim())
                .forEach(car -> System.out.println(car.toString()));
    }
}
