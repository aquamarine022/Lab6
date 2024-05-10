package client.Readers;


import client.Parsers.Parsers;
import common.Data.*;
import common.Exceptions.InvalidDataException;
import common.Utility.Console;
import common.Validators.Validators;
import common.Constants;

import java.time.Instant;
import java.util.Date;

public class VehicleReader extends ValueReader{
    public Vehicle build() throws InvalidDataException{
        Vehicle vehicle = new Vehicle(Long.MAX_VALUE,
                readName(),
                Date.from(Instant.now()),
                readCoordinates(),
                readEnginePower(),
                readNumberOfWheels(),
                readCapacity(),
                readVehicleType());
        return vehicle;
    }
    public Vehicle readVehicle() throws InvalidDataException {
        String name = readName();
        Coordinates coordinates = readCoordinates();
        Integer enginePower = readEnginePower();
        Long numberOfWheels = readNumberOfWheels();
        Long capacity = readCapacity();
        VehicleType vehicleType = readVehicleType();
        return new Vehicle(0, name, new Date(), coordinates, enginePower, numberOfWheels, capacity, vehicleType);

    }

    public String readName() throws InvalidDataException {
        return readValue("name", Validators.nameValidator, Parsers.stringParser);
    }

    public Coordinates readCoordinates() throws InvalidDataException {
        return new Coordinates(readX(), readY());
    }

    public int readX() throws InvalidDataException {
        return readValue("x coordinate", Validators.xValidator, Parsers.integerParser);
    }


    public float readY() throws InvalidDataException {
        return readValue("y coordinate", Validators.yValidator, Parsers.floatParser);
    }

    public Integer readEnginePower() throws InvalidDataException {
        return readValue("engine power", Validators.enginePowerValidator, Parsers.integerParser);
    }

    public Long readNumberOfWheels() throws InvalidDataException {
        return readValue("number of wheels", Validators.numberOfWheelsValidator, Parsers.longParser);
    }

    public Long readCapacity() throws InvalidDataException {
        return readValue("capacity", Validators.capacityValidator,
                Parsers.longParser == null ? null : Parsers.longParser);
    }

    public VehicleType readVehicleType() throws InvalidDataException {
        if(!Constants.SCRIPT_MODE) {
            Console.getInstance().printLn("List of possible status values:");
            for (VehicleType i : VehicleType.values()) {
                Console.getInstance().printLn(i);
            }
        }
        return readValue("vehicle type", Validators.vehicleTypeValidator, Parsers.statusParser);
    }




}
