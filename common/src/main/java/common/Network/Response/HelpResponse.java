package common.Network.Response;

import common.Utility.Commands;

public class HelpResponse extends Response{
    private final String helpMessage;
    public HelpResponse(String helpMessage, String error){
        super(Commands.HELP.getName(), error);
        this.helpMessage = helpMessage;
    }

    public String getHelpMessage(){
        return helpMessage;
    }
}
