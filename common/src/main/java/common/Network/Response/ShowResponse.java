package common.Network.Response;

import common.Data.Vehicle;
import common.Utility.Commands;

import java.util.ArrayDeque;
import java.util.List;

public class ShowResponse extends Response {
    private final ArrayDeque<Vehicle> vehicle;

    public ShowResponse(ArrayDeque<Vehicle> vehicle, String error) {
        super(Commands.SHOW.getName(), error);
        this.vehicle = vehicle;
    }

    public ArrayDeque<Vehicle> getVehicle() {
        return vehicle;
    }
}
