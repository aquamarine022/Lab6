package common.Network.Request;

import common.Data.Vehicle;
import common.Utility.Commands;

public class UpdateByIdRequest extends Request {

    private final long id;
    private final Vehicle vehicle;

    public UpdateByIdRequest(long id, Vehicle vehicle) {
        super(Commands.UPDATE_BY_ID.getName());
        this.id = id;
        this.vehicle = vehicle;
    }

    public long getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
