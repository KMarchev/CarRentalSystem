package command.classes;

import car.CarRepository;
import car.classes.Car;
import command.interfaces.Command;

import java.util.Scanner;

public class SearchCarByModel implements Command {
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Model: ");
        CarRepository.getInstance()
                .getCarsByModel(scanner.nextLine().trim())
                .forEach(car -> System.out.println(car.toString()));
    }
}
