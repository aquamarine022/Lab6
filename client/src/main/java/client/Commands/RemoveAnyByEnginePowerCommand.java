package client.Commands;

import client.Exceptions.APIException;
import client.Network.ClientManager;
import common.Network.Request.RemoveAnyByEnginePowerRequest;
import common.Network.Request.RemoveByIdRequest;
import common.Network.Response.RemoveAnyByEnginePowerResponse;
import common.Network.Response.RemoveByIdResponse;
import common.Utility.Console;

import java.io.IOException;

public class RemoveAnyByEnginePowerCommand extends Command{
    private final Console console;
    private final ClientManager clientManager;
    public RemoveAnyByEnginePowerCommand(Console console, ClientManager clientManager) {
        super("remove_by_engine_power", "удалить элемент из коллекции по его engine power");
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
                console.printError("Введите engine power элемента, который необходимо удалить.");
            } else {
                int engine_power = Integer.parseInt(args[0]);
                var response = (RemoveAnyByEnginePowerResponse) clientManager.sendAndReceiveCommand(new RemoveAnyByEnginePowerRequest(engine_power));
                if (response.getError() != null && !response.getError().isEmpty()) {
                    throw new APIException(response.getError());
                }
                console.printLn("Транспорт успешно удалён.");
            }
        } catch (IOException | ClassNotFoundException e) {
            console.printError("при работе с сервером.");
        } catch (APIException e) {
            console.printError(e.getMessage());
        }
    }
}
