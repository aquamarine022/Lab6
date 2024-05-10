package client.Commands;


import client.Exceptions.APIException;
import client.Network.ClientManager;
import common.Network.Request.RemoveHeadRequest;
import common.Network.Response.RemoveHeadResponse;
import common.Utility.Console;

import javax.imageio.IIOException;
import java.io.IOException;

public class RemoveHeadCommand extends Command{
    private final Console console;
    private final ClientManager clientManager;
    public RemoveHeadCommand(Console console, ClientManager clientManager) {
        super("remove_head", "удалить из коллекции верхний элемент");
        this.console = console;
        this.clientManager = clientManager;
    }

    @Override
    public void execute(String[] args) {
        try {
            if (!validateArgs(args)) {
                console.printError("У команды " + getName() + " не должно быть аргументов.");
            }
            else {
                var respose = (RemoveHeadResponse) clientManager.sendAndReceiveCommand(new RemoveHeadRequest());
                if (respose.getError()!=null && !respose.getError().isEmpty()){
                    throw new APIException(respose.getError());
                }
                console.printLn("Верхний элемент удален");
            }
        }catch (IOException|ClassNotFoundException e){
            console.printError("server work error");
        }catch (APIException e){
            console.printError(e.getMessage());
        }
    }

    @Override
    public boolean validateArgs(String[] args) {
        return args.length == 0;
    }
}
