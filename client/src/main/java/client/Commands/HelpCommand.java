package client.Commands;



public class HelpCommand extends Command{
    public HelpCommand(String name, String description) {
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
