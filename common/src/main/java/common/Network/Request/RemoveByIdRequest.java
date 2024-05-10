package common.Network.Request;

import common.Utility.Commands;

public class RemoveByIdRequest extends Request {
    private final long id;
    public RemoveByIdRequest(long id) {
        super(Commands.REMOVE_BY_ID.getName());
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
