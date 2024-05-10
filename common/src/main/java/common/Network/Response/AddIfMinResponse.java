package common.Network.Response;

import common.Utility.Commands;

public class AddIfMinResponse extends Response {
    private final boolean isAdded;
    public AddIfMinResponse(boolean isAdded, String error) {
        super(Commands.ADD_IF_MIN.getName(), error);
        this.isAdded = isAdded;
    }

    public boolean isAdded() {
        return isAdded;
    }
}
