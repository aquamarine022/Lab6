package common.Network.Response;

import common.Network.Request.AddIfMaxRequest;
import common.Utility.Commands;

public class AddIfMaxResponse extends Response{
    private final boolean isAdded;
    public AddIfMaxResponse(boolean isAdded, String error){
        super(Commands.ADD_IF_MAX.getName(), error);
        this.isAdded = isAdded;
    }
    public boolean isAdded() {
        return isAdded;
    }
}
