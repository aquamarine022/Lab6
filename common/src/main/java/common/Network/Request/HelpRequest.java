package common.Network.Request;

import common.Utility.Commands;

public class HelpRequest extends Request {
    public HelpRequest() {
        super(Commands.HELP.getName());
    }
}
