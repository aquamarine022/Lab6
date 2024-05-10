package common.Network.Response;

import common.Data.Vehicle;
import common.Utility.Commands;

import java.util.ArrayDeque;
import java.util.Vector;

public class MinByNameResponse extends Response{
    private final ArrayDeque<Vehicle> minVehicle;

    public MinByNameResponse(ArrayDeque<Vehicle> minVehicle, String error) {
        super(Commands.MIN_BY_NAME.getName(), error);
        this.minVehicle = minVehicle;
    }

    public ArrayDeque<Vehicle> getMinVehicle() {
        return minVehicle;
    }
}
