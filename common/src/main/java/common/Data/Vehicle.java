package common.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Class to operate with vehicle
 */
public class Vehicle implements Comparable<Vehicle>, Serializable {
    /**
     * Vehicle's id, must be greater than 0, must be unique, must be generated automatically
     */
     private long id;
    /**
     * Vehicle's name, can't be null, can't be empty
     */
    private String name;
    /**
     * Vehicle's coordinates, can't be null
     */
     private Coordinates coordinates;
    /**
     * Vehicle's creationDate, can't be null, must be generated automatically
     */
    private Date creationDate;
    /**
     * Vehicle's engine power, must be greater than 0
     */
     private int enginePower;
    /**
     * Vehicle's number of wheels, must be greater than 0, can't be null
     */
    private Long numberOfWheels;
    /**
     * Vehicle's capacity, can be null, must be greater than 0
     */
     private Long capacity;
    /**
     * Vehicle's type, can be null
     */
    private VehicleType type;

    /**
     * Constructor
     * @param id - id
     * @param name - name
     * @param creationDate - creationDate
     * @param coordinates - coordinates
     * @param enginePower - enginePower
     * @param numberOfWheels - numberOfWheels
     * @param capacity - capacity
     * @param vehicleType - vehicleType
     */
        public Vehicle(long id, String name, Date creationDate, Coordinates coordinates, Integer enginePower,Long numberOfWheels, Long capacity, VehicleType vehicleType) {
            this.id = id;
            this.name = name;
            this.creationDate = creationDate;
            this.coordinates = coordinates;
            this.enginePower = enginePower;
            this.numberOfWheels = numberOfWheels;
            this.capacity = capacity;
            this.type = vehicleType;
        }

    /**
     * Method to get id
     * @return id
     */
    public Long getId() {
        return id;
    }
    /**
     * Method to set id
     * @param id new id
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * Method to get name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Method to get coordinates
     * @return coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }
    /**
     * Method to get creation date
     * @return creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }
    /**
     * Method to get vehicle type
     * @return vehicle type
     */
    public VehicleType getVehicleType(){
            return type;
    }
    /**
     * Method to get engine power
     * @return engine power
     */
    public Integer getEnginePower(){
            return enginePower;
    }
    /**
     * Method to get number of wheels
     * @return number of wheels
     */
    public Long getNumberOfWheels(){
            return numberOfWheels;
    }
    /**
     * Method to get capacity
     * @return capacity
     */
    public Long getCapacity(){
            return capacity;
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.name.compareTo(o.getName());
    }

    public void setCreationDate(Date date){
        this.creationDate = creationDate;
    }
    /**
     * Method to get formatted string representation of vehicle
     * @return String value
     */
    @Override
    public String toString() {
        return "vehicle{\"id\": " + id + ", \n" +
            "\"name\": \"" + name + "\", \n" +
            "\"creationDate\": \"" + creationDate + "\",\n" +
            "\"coordinates\": \"" + coordinates + "\",\n" +
            "\"enginePower\": \"" + enginePower + "\",\n" +
            "\"numberOfWheels\": \"" + (numberOfWheels == null ? "null" : "\""+numberOfWheels+"\"") + "\", \n" +
            "\"capacity\": \"" + (capacity == null ? "null" : "\""+capacity+"\"") + "\", \n" +
            "\"vehicleType\": " + (type == null ? "null" : "\""+type+"\"") + "}";
        }
    }
