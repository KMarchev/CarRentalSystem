package command.classes;

import car.CarRepository;
import command.interfaces.Command;
import exception.CommandException;

import java.util.Scanner;

public class RemoveCar implements Command {
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

        repository.removeCarById(id);
        System.out.println("Car removed successfully.");
    }
}
