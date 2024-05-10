package common.Network.Response;

import common.Utility.Commands;

public class AddIfMinResponse extends Response {
    public AddIfMinResponse(String error) {
        super(Commands.ADD_IF_MIN.getName(), error);
    }

}
