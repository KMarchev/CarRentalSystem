package command.classes;

import car.CarRepository;
import command.interfaces.Command;
import exception.CommandException;
import rental.RentalRepository;

import java.util.Scanner;

/**
 * {@link command.interfaces.Command} to remove an existing car in the CarRepository.
 */
public class RemoveCar implements Command {
    /**
     * Executes the remove command for Car.
     *
     * @param args not used.
     * @throws CommandException if user input is invalid or rental that uses the car exists.
     */
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CarRepository repository = CarRepository.getInstance();

        System.out.print("ID of car you want to remove: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        if(repository.searchById(id)==-1){
            throw new CommandException("No car found with ID: "+id);
        }

        if(RentalRepository.getInstance().searchByIdForCar(id)){
            throw new CommandException("Please make sure to remove all rentals before removing the car!");
        }

        repository.removeCarById(id);
        System.out.println("Car removed successfully.");
    }
}
