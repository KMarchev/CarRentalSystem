package command.classes;

import car.CarRepository;
import command.interfaces.Command;
import exception.CommandException;
import rental.RentalRepository;

import java.util.Scanner;

public class RemoveRental implements Command {
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        RentalRepository rentalRepository = RentalRepository.getInstance();
        CarRepository carRepository=CarRepository.getInstance();

        System.out.print("ID of car you want to remove rental of: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        if(carRepository.searchById(id)==-1){
            throw new CommandException("No car found with ID: "+id);
        }

        rentalRepository.removeRentalByCarId(id);
        carRepository.getCar(id).setAvailable(true);
        System.out.println("Rental removed successfully.");
    }
}
