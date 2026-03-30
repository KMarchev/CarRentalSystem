package command.classes;

import car.CarRepository;
import command.interfaces.Command;
import customer.CustomerRepository;
import exception.CommandException;

import java.util.Scanner;

/**
 * {@link command.interfaces.Command} to show all customers.
 */
public class ListCustomers implements Command {
    /**
     * Executes the 'show all customers' command for Customer.
     *
     * @param args not used.
     */
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        CustomerRepository repository = CustomerRepository.getInstance();


        System.out.print("List of all customers:\n");

        repository.getCustomerList().forEach(car -> System.out.println(car.toString()));

        System.out.println();
    }
}
