package client.Commands;


import client.Exceptions.APIException;
import client.Network.ClientManager;
import client.Readers.VehicleReader;
import common.Exceptions.InvalidDataException;
import common.Network.Request.AddIfMaxRequest;
import common.Network.Request.AddRequest;
import common.Network.Response.AddIfMaxResponse;
import common.Network.Response.AddResponse;
import common.Utility.Console;

import java.io.IOException;

public class AddIfMaxCommand extends Command{
    private final Console console;
    private final ClientManager clientManager;
    public AddIfMaxCommand(Console console, ClientManager clientManager) {
        super("add_if_max", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
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
            if(!validateArgs(args)){
                console.printError("У комманды " + getName() + " не должно быть аргументов");
            }else {
                var newVehicle = (new VehicleReader()).readVehicle();
                var response = (AddIfMaxResponse) clientManager.sendAndReceiveCommand(new AddIfMaxRequest(newVehicle));
                if (response.getError() != null && !response.getError().isEmpty()) {
                    throw new APIException(response.getError());
                }
                console.printLn("Транспорт успешно добавлен.");
            }
        }
        catch (IOException | ClassNotFoundException e) {
            console.printError("ошибка при работе с сервером.");
        } catch (APIException e) {
            console.printError(e.getMessage());
        }catch (InvalidDataException e){
            console.printError("неверные данные");
        }

    }
}
