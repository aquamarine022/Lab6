package client.Commands;



public class FilterStartsWithNameCommand extends Command{
    public FilterStartsWithNameCommand(String name, String description) {
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
