package common.Validators;

import common.Data.*;
import common.Exceptions.InvalidDataException;

import java.util.Date;

/**
 * Class which contains validators for all fields of Vehicle
 */
public class Validators {
    public static Validator<Vehicle> vehicleValidator = new Validator<Vehicle>() {
        @Override
        public void validate(Vehicle value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Vehicle can't be empty!");
            idValidator.validate(value.getId());
            nameValidator.validate(value.getName());
            coordinatesValidator.validate(value.getCoordinates());
            creationDateValidator.validate(value.getCreationDate());
            enginePowerValidator.validate(value.getEnginePower());
            numberOfWheelsValidator.validate(value.getNumberOfWheels());
            capacityValidator.validate(value.getCapacity());
            vehicleTypeValidator.validate(value.getVehicleType());
        }
    };
    public static Validator<Long> idValidator = new Validator<Long>() {
        @Override
        public void validate(Long value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Id can't be empty!");
            if(value <= 0) throw new InvalidDataException("Id must be greater than zero!");
        }
    };

    public static Validator<String> nameValidator = new Validator<String>() {
        @Override
        public void validate(String value) throws InvalidDataException {
            if(value == null || value.isEmpty()) throw new InvalidDataException("Name can't be empty!");
            if(value.contains(" ")) throw new InvalidDataException("Name can't contain spaces!");
        }
    };

    public static Validator<Coordinates> coordinatesValidator = new Validator<Coordinates>() {
        @Override
        public void validate(Coordinates value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Coordinates can't be empty!");
            xValidator.validate(value.getX());
            yValidator.validate(value.getY());
        }
    };
    public static Validator<Integer> xValidator = new Validator<Integer>() {
        @Override
        public void validate(Integer value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("X can't be empty!");
            if(value > 717) throw new InvalidDataException("x coordinate max value is 717");
        }
    };
    public static Validator<Float> yValidator = new Validator<Float>() {
        @Override
        public void validate(Float value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Y can't be empty!");
        }
    };

    public static Validator<Date> creationDateValidator = new Validator<Date>() {
        @Override
        public void validate(Date value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Creation date can't be empty!");
        }
    };

    public static Validator<Integer> enginePowerValidator = new Validator<Integer>() {
        @Override
        public void validate(Integer value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Engine power can't be empty!");
            if(value <= 0) throw new InvalidDataException("Engine power must be greater than zero!");
        }
    };

    public static Validator<Long> numberOfWheelsValidator = new Validator<Long>() {
        @Override
        public void validate(Long value) throws InvalidDataException {
            if(value == null) throw new InvalidDataException("Number of wheels can't be empty!");
            if(value <= 0) throw new InvalidDataException("Number of wheels must be greater than zero!");
        }
    };
    public static Validator<Long> capacityValidator = new Validator<Long>() {
        @Override
        public void validate(Long value) throws InvalidDataException {
            if(value == null) return;
            if(value <= 0) throw new InvalidDataException("Capacity must be greater than zero!");
        }
    };
    public static Validator<VehicleType> vehicleTypeValidator = new Validator<VehicleType>() {
        @Override
        public void validate(VehicleType value){
            if(value == null) return;
        }
    };
}
