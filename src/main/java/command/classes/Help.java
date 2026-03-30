package command.classes;

import command.interfaces.Command;
import exception.CommandException;

/**
 * {@link command.interfaces.Command} that prints a list of all currently available commands.
 */

public class Help implements Command {
    /**
     * Executes the help command.
     *
     * @param args not used.
     */
    @Override
    public void execute(String args) throws Exception {
        System.out.print("""
                List of commands:
                
                add car \t\\\\ add car to the list of cars
                Example - Add Car:1,Toyota,Cornelius,2025
                
                add customer \t\\\\ add customer to the list of customers
                Example - Add Customer:1,John Doe
                
                rent car\t\\\\ rents a car
                Example: 1,1,01-01-2026
                
                edit car \t\\\\ updates the information about a car
                
                search by model \t\\\\ search for car by provided model
                Example - Model:Cornelius
                
                list cars\t\\\\ gives you a list of all available cars
                
                list customers\t\\\\ gives you a list of all customers
                
                list rentals\t\\\\ gives you a list of all currently rented cars and short information about their renter
                
                remove car \t\\\\ removes a car from the list of cars
                
                remove customer \t\\\\ removes a customer from the list of customers
                
                return rental \t\\\\ returns a car and makes it available
                
                help \t\\\\ gives you a list of all available commands
                
                exit \t\\\\ closes the program
                
                """);
    }
}
