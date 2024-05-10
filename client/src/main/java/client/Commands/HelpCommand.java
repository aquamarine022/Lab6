package client.Commands;


import client.Network.ClientManager;
import common.Network.Request.HelpRequest;
import common.Network.Response.HelpResponse;
import common.Utility.Console;

import java.io.IOException;

public class HelpCommand extends Command{
    private final Console console;
    private final ClientManager clientManager;
    public HelpCommand(Console console, ClientManager clientManager) {
        super("help", "вывести справку по доступным командам");
        this.console = console;
        this.clientManager = clientManager;
    }

    @Override
    public void execute(String[] args) {
        try {
            if(!validateArgs(args)){
                console.printError("У этой команды не должно быть аргументов");
            }else {
                var response = (HelpResponse) clientManager.sendAndReceiveCommand(new HelpRequest());
                console.printLn(response.getHelpMessage());
            }
        }catch (IOException|ClassNotFoundException e){
            console.printError("Server error");
        }
    }

    @Override
    public boolean validateArgs(String[] args) {
        return args.length == 0;
    }
}
