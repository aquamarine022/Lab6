package common.Network.Request;

import common.Data.Vehicle;
import common.Utility.Commands;

public class AddRequest extends Request{
    private final Vehicle vehicle;

    public AddRequest(Vehicle vehicle) {
        super(Commands.ADD.getName());
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }
}
