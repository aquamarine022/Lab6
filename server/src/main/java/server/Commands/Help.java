package server.Commands;

import common.Network.Request.Request;
import common.Network.Response.HelpResponse;
import common.Network.Response.Response;
import server.Managers.CommandManager;

public class Help extends Command{
    private final CommandManager commandManager;
    public Help(CommandManager commandManager){
        super("help", "вывести справку по доступным командам");
        this.commandManager = commandManager;
    }

    @Override
    public Response execute(Request request){
        try {
            StringBuilder helpMessage = new StringBuilder();
            commandManager.getCommandMap().values().forEach(command -> {
                helpMessage.append(command.getName()).append(": ").append(command.getDescription()).append("\n");
            });
            return new HelpResponse(helpMessage.toString(), null);
        }catch (Exception e){
            return new HelpResponse(null, e.toString());
        }
    }
}
