package command.classes;

import car.CarRepository;
import car.classes.Car;
import command.interfaces.Command;
import exception.CommandException;

import java.util.Scanner;

/**
 * {@link command.interfaces.Command} to show all cars that are available.
 */

public class ListCars implements Command {
    /**
     * Executes the 'show all currently available cars' command for Car.
     *
     * @param args not used.
     */
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("List of all available cars:\n");

        CarRepository.getInstance().getAvailableCarsList().forEach(car -> System.out.println(car.toString()));

        System.out.println();
    }
}
