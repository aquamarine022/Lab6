package common.Network.Response;

import common.Network.Request.AddIfMaxRequest;
import common.Utility.Commands;

public class AddIfMaxResponse extends Response{

    public AddIfMaxResponse(String error){
        super(Commands.ADD_IF_MAX.getName(), error);

    }
}
