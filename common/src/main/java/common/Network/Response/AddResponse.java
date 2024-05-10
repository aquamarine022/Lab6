package common.Network.Response;

import common.Utility.Commands;

public class AddResponse extends Response{
    public AddResponse(String error){
        super(Commands.ADD.getName(), error);
    }
}
