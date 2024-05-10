package client.Commands;

import client.Exceptions.APIException;
import client.Network.ClientManager;
import client.Readers.VehicleReader;
import common.Exceptions.InvalidDataException;
import common.Network.Request.AddIfMinRequest;
import common.Network.Response.AddIfMinResponse;
import common.Utility.Console;

import java.io.IOException;

public class AddIfMinCommand extends Command{

    private final Console console;
    private final ClientManager clientManager;

    public AddIfMinCommand(Console console, ClientManager clientManager) {
        super("add_if_min", "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
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
                var newVehicle = (new VehicleReader()).readVehicle();
                var response = (AddIfMinResponse) clientManager.sendAndReceiveCommand(new AddIfMinRequest(newVehicle));
                if (response.getError() != null && !response.getError().isEmpty()) {
                    throw new APIException(response.getError());
                } else if (!response.isAdded()) {
                    console.printLn(response.getError());
                }
                console.printLn("Транспорт успешно добавлен.");
            }
        } catch (IOException | ClassNotFoundException e) {
            console.printError("при работе с сервером.");
        } catch (APIException e) {
            console.printError(e.getMessage());
        } catch (InvalidDataException e) {
            console.printError("неверные данные");
        }
    }
}
