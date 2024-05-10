package common.Network.Request;

import common.Utility.Commands;

public class ShowRequest extends Request {
    public ShowRequest() {
        super(Commands.SHOW.getName());
    }
}
