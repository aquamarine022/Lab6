package common.Network.Response;

import common.Utility.Commands;

public class RemoveByIdResponse extends Response{
    public RemoveByIdResponse(String error) {
        super(Commands.REMOVE_BY_ID.getName(), error);
    }
}
