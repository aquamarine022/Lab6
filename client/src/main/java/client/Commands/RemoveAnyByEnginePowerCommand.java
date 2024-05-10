package client.Commands;

public class RemoveAnyByEnginePowerCommand extends Command{
    public RemoveAnyByEnginePowerCommand(String name, String description) {
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
