package common.Network.Request;

import common.Utility.Commands;

public class RemoveHeadRequest extends Request {
    public RemoveHeadRequest() {
        super(Commands.REMOVE_HEAD.getName());
    }
}
