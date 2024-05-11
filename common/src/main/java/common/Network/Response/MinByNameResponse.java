package common.Network.Response;

import common.Data.Vehicle;
import common.Utility.Commands;

public class MinByNameResponse extends Response{
    private final Vehicle minVehicle;

    public MinByNameResponse(Vehicle minVehicle, String error) {
        super(Commands.MIN_BY_NAME.getName(), error);
        this.minVehicle = minVehicle;
    }

    public Vehicle getMinVehicle() {
        return minVehicle;
    }
}
