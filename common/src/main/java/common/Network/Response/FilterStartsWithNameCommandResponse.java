package common.Network.Response;

import common.Data.Vehicle;
import common.Utility.Commands;

import java.util.ArrayDeque;
import java.util.List;

public class FilterStartsWithNameCommandResponse extends Response {
    private final List<Vehicle> vehicles;
    public FilterStartsWithNameCommandResponse(List<Vehicle> vehicles, String error){
        super(Commands.FILTER_STARTS_WITH_NAME.getName(), error);
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles(){
        return vehicles;
    }
}
