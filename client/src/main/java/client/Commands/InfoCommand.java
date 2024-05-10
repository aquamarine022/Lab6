package client.Commands;


import client.Network.ClientManager;
import common.Network.Request.InfoRequest;
import common.Network.Response.InfoResponse;
import common.Utility.Console;

import java.io.IOException;

public class InfoCommand extends Command{
    private final Console console;
    private final ClientManager clientManager;
    public InfoCommand(Console console, ClientManager clientManager) {
        super("info", "вывести информацию о коллекции");
        this.console = console;
        this.clientManager = clientManager;
    }

    @Override
    public void execute(String[] args) {
        try {
            if(!validateArgs(args)){
                console.printError("У команды не должно быть аргументов");
            }else {
                var response = (InfoResponse) clientManager.sendAndReceiveCommand(new InfoRequest());
                console.printLn(response.getInfoMessage());
            }
        } catch (IOException|ClassNotFoundException e) {
            console.printError("server error");
        }
    }

    @Override
    public boolean validateArgs(String[] args) {
        return args.length == 0;
    }
}
