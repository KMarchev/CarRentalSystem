package command.classes;

import command.interfaces.Command;
import exception.CommandException;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages and provides command executables based on command strings.
 */

public class Executer {

    private static final Map<String, Command> executerMap=new HashMap<>();

    static {
        executerMap.put("ADD CAR", new AddCar());
        executerMap.put("LIST CARS", new ListCars());
        executerMap.put("EDIT CAR", new EditCar());
        executerMap.put("REMOVE CAR", new RemoveCar());
        executerMap.put("ADD CUSTOMER", new AddCustomer());
        executerMap.put("REMOVE CUSTOMER", new RemoveCustomer());
        executerMap.put("LIST CUSTOMERS", new ListCustomers());
        executerMap.put("RENT CAR", new AddRental());
        executerMap.put("RETURN RENTAL", new RemoveRental());
        executerMap.put("LIST RENTALS", new ListRentals());
        executerMap.put("HELP", new Help());
        executerMap.put("SEARCH BY MODEL", new SearchCarByModel());
    }


    /**
     * Returns the Command corresponding to the argument.
     *
     * @param args command arguments.
     * @return Command instance mapped to the command.
     * @throws CommandException if no arguments are provided or command is invalid.
     */

    public static Command executable(String args){

        if (args==null||args.isBlank()) {
            throw new CommandException("No arguments!");
        }

        Command command = executerMap.getOrDefault(args.toUpperCase(), null);

        if(command==null){
            throw new CommandException("Invalid command!");
        }

        return command;

    }

}
