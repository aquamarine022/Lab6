package client.Commands;

import client.Exceptions.APIException;
import client.Network.ClientManager;
import client.Readers.VehicleReader;
import common.Exceptions.InvalidDataException;
import common.Network.Request.UpdateByIdRequest;
import common.Network.Response.UpdateByIdResponse;
import common.Utility.Console;

import java.io.IOException;

public class UpdateByIdCommand extends Command{
    private final Console console;
    private final ClientManager clientManager;

    public UpdateByIdCommand(Console console, ClientManager clientManager) {
        super("update_id", "обновить значение элемента коллекции, id которого равен заданному");
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
                console.printError("У команды должен быть аргумент");
            } else {
                long id = Long.parseLong(args[0]);
                var updatedVehicle = (new VehicleReader()).readVehicle();
                var response = (UpdateByIdResponse) clientManager.sendAndReceiveCommand(new UpdateByIdRequest(id, updatedVehicle));
                if (response.getError() != null && !response.getError().isEmpty()) {
                    throw new APIException(response.getError());
                }
                console.printLn("Транспорт успешно обновлен");
            }
        } catch (IOException | ClassNotFoundException e) {
            console.printError("server error");
        } catch (APIException e) {
            console.printError(e.getMessage());
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }
}
