package command.interfaces;

/**
 * Represents a command or action that can be executed with arguments.
 */
public interface Command {

    /**
     * Executes the command with the given arguments.
     *
     * @param args String of arguments for the command.
     * @throws Exception if an error occurs during execution.
     */
    void execute(String args) throws Exception;
}
