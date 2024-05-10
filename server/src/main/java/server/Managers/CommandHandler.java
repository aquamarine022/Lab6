package server.Managers;

import common.Network.Request.Request;
import common.Network.Response.NoSuchCommandResponse;
import common.Network.Response.Response;
import server.Commands.Command;

public class CommandHandler {
    private final CommandManager commandManager;
    public CommandHandler(CommandManager commandManager){
        this.commandManager = commandManager;
    }

    public Response handler(Request request){
        Command command = commandManager.getCommandMap().get(request.getName());
        if (command==null){
            return new NoSuchCommandResponse(request.getName());
        }else return command.execute(request);
    }
}
