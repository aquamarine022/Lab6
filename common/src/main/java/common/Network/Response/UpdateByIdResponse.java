package common.Network.Response;

import common.Utility.Commands;

public class UpdateByIdResponse extends Response{
    public UpdateByIdResponse(String error) {
        super(Commands.UPDATE_BY_ID.getName(), error);
    }
}
