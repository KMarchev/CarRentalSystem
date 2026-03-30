package command.classes;

import command.interfaces.Command;
import customer.CustomerRepository;
import exception.CommandException;
import rental.RentalRepository;

import java.util.Scanner;

/**
 * {@link command.interfaces.Command} to remove an existing customer in the CustomerRepository.
 */
public class RemoveCustomer implements Command {
    /**
     * Executes the remove command for Customer.
     *
     * @param args not used.
     * @throws CommandException if user input is invalid or rental that uses the customer exists.
     */
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CustomerRepository repository = CustomerRepository.getInstance();

        System.out.print("ID of customer you want to remove: ");
        int id=scanner.nextInt();
        scanner.nextLine();
        if(repository.searchById(id)==-1){
            throw new CommandException("No customer found with ID: "+id);
        }

        if(RentalRepository.getInstance().searchByIdForCustomer(id)){
            throw new CommandException("Please make sure to remove all rentals before removing the customer!");
        }

        repository.removeCustomerById(id);
        System.out.println("Customer removed successfully.");
    }
}
