package common.Network.Request;

import common.Utility.Commands;

public class ClearRequest extends Request {
    public ClearRequest() {
        super(Commands.CLEAR.getName());
    }
}
