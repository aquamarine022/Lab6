package common.Network.Request;

import common.Utility.Commands;

public class MinByNameRequest extends Request {
    public MinByNameRequest() {
        super(Commands.MIN_BY_NAME.getName());
    }
}
