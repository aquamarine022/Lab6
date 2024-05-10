package common.Network.Request;

import common.Data.Vehicle;
import common.Utility.Commands;

public class AddIfMaxRequest extends Request{
    private final Vehicle vehicle;

    public AddIfMaxRequest(Vehicle vehicle) {
        super(Commands.ADD_IF_MAX.getName());
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }
}
