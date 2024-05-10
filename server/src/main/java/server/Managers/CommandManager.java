package server.Managers;

import server.Commands.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commandMap = new HashMap<>();

    public void createCommand(Command command){
        commandMap.put(command.getName(), command);
    }

    public Map<String, Command> getCommandMap(){
        return commandMap;
    }

    public Command getCommand(String name){
        return commandMap.get(name);
    }
}
