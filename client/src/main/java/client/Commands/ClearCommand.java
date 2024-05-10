package client.Commands;


import client.Exceptions.APIException;
import client.Network.ClientManager;
import common.Network.Request.ClearRequest;
import common.Network.Response.ClearResponse;
import common.Utility.Console;

import java.io.IOException;

public class ClearCommand extends Command{
    private final Console console;
    private final ClientManager clientManager;

    public ClearCommand(Console console, ClientManager clientManager) {
        super("clear", "очистить коллекцию");
        this.clientManager = clientManager;
        this.console = console;
    }

    @Override
    public void execute(String[] args) {
        try {
            if(!validateArgs(args)){
                console.printError("У этой команды не должно быть аргументов");
            }else {
                var response = (ClearResponse) clientManager.sendAndReceiveCommand(new ClearRequest());
                if (response.getError() != null && !response.getError().isEmpty()){
                    throw new APIException(response.getError());
                }
            }
        } catch (IOException|ClassNotFoundException e) {
            console.printError("server error");
        } catch (APIException e) {
            console.printError(e.getMessage());
        }
    }

    @Override
    public boolean validateArgs(String[] args) {
        return args.length ==0;
    }

}
