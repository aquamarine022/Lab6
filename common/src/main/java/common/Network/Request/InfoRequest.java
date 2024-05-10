package common.Network.Request;

import common.Utility.Commands;

public class InfoRequest extends Request {
    public InfoRequest() {
        super(Commands.INFO.getName());
    }
}
