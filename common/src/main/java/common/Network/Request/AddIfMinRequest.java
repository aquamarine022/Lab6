package common.Network.Request;

import common.Data.Vehicle;
import common.Utility.Commands;

public class AddIfMinRequest extends Request{
    private final Vehicle vehicle;

    public AddIfMinRequest(Vehicle vehicle) {
        super(Commands.ADD_IF_MIN.getName());
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }
}
