package client.Commands;

import client.Exceptions.APIException;
import client.Network.ClientManager;
import common.Network.Request.ShowRequest;
import common.Network.Response.ShowResponse;
import common.Utility.Console;

import java.io.IOException;

public class ShowCommand extends Command{
    private final Console console;
    private final ClientManager clientManager;
    public ShowCommand(Console console, ClientManager clientManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.console = console;
        this.clientManager = clientManager;
    }

    @Override
    public boolean validateArgs(String[] args) {
        return args.length == 0;
    }

    @Override
    public void execute(String[] args) {
        try {
            if (!validateArgs(args)) {
                console.printError("У команды " + getName() + " не должно быть аргументов.");
            } else {
                var response = (ShowResponse) clientManager.sendAndReceiveCommand(new ShowRequest());
                if (response.getError() != null && !response.getError().isEmpty()) {
                    throw new APIException(response.getError());
                }

                if (response.getVehicle().isEmpty()) {
                    console.printLn("Коллекция пуста!");
                }

                for (var person : response.getVehicle()) {
                    console.printLn(person);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            console.printError("при работе с сервером.");
        } catch (APIException e) {
            console.printError(e.getMessage());
        }
    }
}
