package client.Commands;


import client.Network.ClientManager;
import common.Network.Request.MinByNameRequest;
import common.Network.Response.MinByNameResponse;
import common.Utility.Console;

import java.io.IOException;

public class MinByNameCommand extends Command{
    private final Console console;
    private final ClientManager clientManager;
    public MinByNameCommand(Console console, ClientManager clientManager) {
        super("min_by_name", "вывести любой объект из коллекции, значение поля name которого является минимальным");
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
                var response = (MinByNameResponse) clientManager.sendAndReceiveCommand(new MinByNameRequest());
                console.printLn(response.getMinVehicle());
            }
        } catch (IOException | ClassNotFoundException e) {
            console.printError("при работе с сервером.");
        }
    }
}
