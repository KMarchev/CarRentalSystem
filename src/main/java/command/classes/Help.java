package command.classes;

import command.interfaces.Command;

public class Help implements Command {
    @Override
    public void execute(String args) throws Exception {
        System.out.print("""
                List of commands:
                
                add car \t\\\\ add car to the list of cars
                
                add customer \t\\\\ add customer to the list of customers
                
                rent car\t\\\\ rents a car
                
                edit car \t\\\\ updates the information about a car
                
                help \t\\\\ gives you a list of all available commands
                
                list cars\t\\\\ gives you a list of all available cars
                
                list customers\t\\\\ gives you a list of all customers
                
                list rentals\t\\\\ gives you a list of all currently rented cars and short information about their renter
                
                remove car \t\\\\ removes a car from the list of cars
                
                remove customer \t\\\\ removes a customer from the list of customers
                
                return rental \t\\\\ returns a car and makes it available
                
                exit \t\\\\ closes the program
                
                """);
    }
}
