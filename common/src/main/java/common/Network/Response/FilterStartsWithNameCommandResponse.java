package common.Network.Response;

import common.Data.Vehicle;
import common.Utility.Commands;

import java.util.ArrayDeque;

public class FilterStartsWithNameCommandResponse extends Response {
    private final ArrayDeque<Vehicle> vehicles;
    public FilterStartsWithNameCommandResponse(ArrayDeque<Vehicle> vehicles, String error){
        super(Commands.FILTER_STARTS_WITH_NAME.getName(), error);
        this.vehicles = vehicles;
    }

    public ArrayDeque<Vehicle> getVehicles(){
        return vehicles;
    }
}
