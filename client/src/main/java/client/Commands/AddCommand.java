package client.Commands;

import client.Exceptions.APIException;
import client.Network.ClientManager;
import client.Readers.VehicleReader;
import common.Exceptions.InvalidDataException;
import common.Network.Request.AddRequest;
import common.Network.Response.AddResponse;
import common.Utility.Console;

import java.io.IOException;

public class AddCommand extends Command {
    private final Console console;
    private final ClientManager clientManager;
    public AddCommand(Console console, ClientManager clientManager) {
        super("add", "добавить новый элемент в коллекцию");
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
                var response = (AddResponse) clientManager.sendAndReceiveCommand(new AddRequest(newVehicle));
                if (response.getError() != null && !response.getError().isEmpty()) {
                    throw new APIException(response.getError());
                }
                console.printLn("Транспорт успешно добавлен.");
            }
        } catch (IOException | ClassNotFoundException e) {

            console.printError("ошибка при работе с сервером.");
        } catch (APIException e) {
            console.printError(e.getMessage());
        }
        catch (InvalidDataException e){
            console.printError("неверные данные");
        }
    }

}
