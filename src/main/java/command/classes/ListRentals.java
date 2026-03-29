package command.classes;

import command.interfaces.Command;
import customer.CustomerRepository;
import rental.RentalRepository;

import java.util.Scanner;

public class ListRentals implements Command {
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        RentalRepository repository = RentalRepository.getInstance();


        System.out.print("List of all rentals:\n");

        repository.getRentalList().forEach(rental -> System.out.println(rental.toString()));

        System.out.println();
    }
}
