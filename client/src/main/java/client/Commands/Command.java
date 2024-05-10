package client.Commands;

import java.io.Serializable;
import java.util.Objects;

public abstract class Command implements ICommand, Serializable {
    private final String name;
    private final String description;

    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * An abstract method whose implementation is required for each created command. The method allows to define the implementation of a command after user input or when reading from a file.
     * @param args a string of data entered from the console or from a script, specifying the command and the necessary arguments
     */
    public abstract void execute(String[] args);

    @Override
    public String toString() {
        return "Command: " + getName() + " (" + getDescription() + ").";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Command command = (Command) object;
        return Objects.equals(getName(), command.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

}
