package client.Commands;


import client.Exceptions.APIException;
import client.Network.ClientManager;
import common.Network.Request.FilterStartsWithNameCommandRequest;
import common.Network.Response.FilterStartsWithNameCommandResponse;
import common.Utility.Console;

import java.io.IOException;

public class FilterStartsWithNameCommand extends Command{
    private final Console console;
    private final ClientManager clientManager;
    public FilterStartsWithNameCommand(Console console, ClientManager clientManager) {
        super("filter_starts_with_name", "вывести элементы, начинающиеся с заданного значения");
        this.console = console;
        this.clientManager = clientManager;
    }

    @Override
    public boolean validateArgs(String[] args) {
        return args.length == 1;
    }

    @Override
    public void execute(String[] args) {
        try {
            if (!validateArgs(args)) {
                console.printError("У команды " + getName() + " должен быть аргумент.");
            } else {
                String filterByName = args[0];
                var response = (FilterStartsWithNameCommandResponse)
                        clientManager.sendAndReceiveCommand(
                                new FilterStartsWithNameCommandRequest(filterByName));
                if (response.getError() != null && !response.getError().isEmpty()) {
                    throw new APIException(response.getError());
                }
                console.printLn(response.getVehicles() + "\n");
            }
        } catch (IOException | ClassNotFoundException e) {
            console.printError("при работе с сервером.");
        } catch (APIException e) {
            console.printError(e.getMessage());
        }
    }
}
