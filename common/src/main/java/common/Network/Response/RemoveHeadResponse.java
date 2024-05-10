package common.Network.Response;

import common.Utility.Commands;

public class RemoveHeadResponse extends Response{
    public RemoveHeadResponse(String error) {
        super(Commands.REMOVE_HEAD.getName(), error);
    }
}
