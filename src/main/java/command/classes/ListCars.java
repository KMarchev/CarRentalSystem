package command.classes;

import car.CarRepository;
import car.classes.Car;
import command.interfaces.Command;

import java.util.Scanner;

/**
 * Command to show all cars that are available.
 */

public class ListCars implements Command {
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("List of all available cars:\n");

        CarRepository.getInstance().getAvailableCarsList().forEach(car -> System.out.println(car.toString()));
    }
}
