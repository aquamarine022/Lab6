package client.Commands;


public class InfoCommand extends Command{
    public InfoCommand(String name, String description) {
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
