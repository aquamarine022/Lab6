package client.Commands;


public class ClearCommand extends Command{

    @Override
    public void execute(String[] args) {

    }

    @Override
    public boolean validateArgs(String[] args) {
        return false;
    }

    public ClearCommand(String name, String description) {
        super(name, description);
    }
}
