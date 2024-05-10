package client.Commands;

public class UpdateByIdCommand extends Command{
    public UpdateByIdCommand(String name, String description) {
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
