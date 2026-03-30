package command.classes;

import command.interfaces.Command;
import customer.CustomerRepository;
import customer.classes.Customer;
import exception.CommandException;
import helper.ValueValidator;

import java.util.Arrays;
import java.util.Scanner;

/**
 * {@link command.interfaces.Command} to create a new customer and add it to the CustomerRepository.
 */

public class AddCustomer implements Command {

    /**
     * Executes the create command for Car.
     *
     * @param args not used.
     * @throws CommandException if user input is invalid.
     */
    @Override
    public void execute(String args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Add Customer: ");

        String[] params = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).toArray(String[]::new);

        if(params.length!=2 || !ValueValidator.isValidIdCustomer(params[0]) || !ValueValidator.isValidName(params[1])){
            throw new CommandException("Invalid arguments for customer creation!");
        }
        CustomerRepository.getInstance().addCustomer(new Customer(Integer.parseInt(params[0]),params[1]));
    }
}
