package common.Network.Response;

import common.Utility.Commands;

public class ClearResponse extends Response{
    public ClearResponse(String error) {
        super(Commands.CLEAR.getName(), error);
    }
}
