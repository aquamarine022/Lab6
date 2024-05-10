package client.Commands;


import java.util.NoSuchElementException;

public class RemoveByIdCommand extends Command{
    public RemoveByIdCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(String[] args) {

    }

    @Override
    public boolean validateArgs(String[] args) {
        return false;
    }
}
