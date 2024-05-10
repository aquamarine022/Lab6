package server.Managers;



import common.Data.*;
import static common.Constants.formatter;
import common.Validators.Validators;
import common.Exceptions.InvalidDataException;
import server.Main;

import java.time.Instant;
import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;


public class CollectionManager {
    private ArrayDeque<Vehicle> collection = new ArrayDeque<>();

    private final Date creationDate;


    public CollectionManager(){
        this.creationDate = new Date();
    }

    public static boolean isValid(ArrayDeque<Vehicle> collection){
        Set<Long> idSet = collection.stream().map(Vehicle::getId).collect(Collectors.toSet());
        if (idSet.size() != collection.size()) return false;
        for (Vehicle vehicle : collection){
            try {
                Validators.vehicleValidator.validate(vehicle);
            }
            catch (InvalidDataException e){
                return false;
            }
        }
        return true;
    }

    public long generateId(){
        if(this.collection.isEmpty()) return 1;
        return this.collection.stream().map(Vehicle::getId).max(Long::compareTo).get()+1;
    }

    public ArrayDeque<Vehicle> getCollection(){
        return this.collection;
    }

    public boolean containsId(long id){
        if (this.collection.isEmpty()) return false;
        return this.collection.stream().anyMatch(vehicle -> vehicle.getId() == id);
    }

    public boolean containsEnginePower(int engine_power){
        if (this.collection.isEmpty()) return false;
        return this.collection.stream().anyMatch(vehicle -> vehicle.getEnginePower() == engine_power);
    }

    public String getInfo(){
        return "Type: " + this.collection.getClass().getName() +
                "\nCreation date: " + formatter.format(this.creationDate) +
                "\nSize: " + this.collection.size();
    }

    public void add(Vehicle newVehicle){
        newVehicle.setId(this.generateId());
        newVehicle.setCreationDate(Date.from(Instant.now()));
        this.collection.add(newVehicle);
    }

    public void addAll(Collection<Vehicle> collection){
        this.collection.addAll(collection);
    }
    public void update(long id, Vehicle newVehicle){
        removeById(id);
        newVehicle.setId(id);
        collection.add(newVehicle);
    }

    public void removeById(long id){
        this.collection.removeIf(vehicle -> vehicle.getId()==id);
    }

    public void clear(){
        this.collection.clear();
    }

    public void removeHead(){
        System.out.println(this.collection.getFirst());
        this.collection.poll();
    }

    public void addIfMax(Vehicle vehicle) {
        Optional<Vehicle> o = this.collection
                .stream()
                .max(Comparator.comparing(Vehicle::getName));
        if (o.isEmpty() || o.get().compareTo(vehicle) < 0) {
            vehicle.setId(this.generateId());
            this.collection.add(vehicle);
            Main.logger.log(Level.INFO, "максимальный транспорт добавлен");
        }else {
            Main.logger.log(Level.INFO, "это не максимальный транспорт");
        }
    }

    public void addIfMin(Vehicle vehicle) {
        Optional<Vehicle> o = this.collection
                .stream()
                .min(Comparator.comparing(Vehicle::getName));
        if (o.isEmpty() || o.get().compareTo(vehicle) > 0) {
            vehicle.setId(this.generateId());
            this.collection.add(vehicle);
            Main.logger.log(Level.INFO, "минимальный транспорт добавлен");
        }else {
            Main.logger.log(Level.INFO, "это не минимальный транспорт");
        }
    }

    public void removeByEnginePower(Integer enginePower){
        this.collection.removeIf(vehicle -> vehicle.getEnginePower() == enginePower);
    }

    public Vehicle getMinByName(){
        return this.collection.stream().min(Comparator.comparing(Vehicle::getName)).orElseThrow(NoSuchElementException::new);
    }

    public List<Vehicle> getStartsWithName(String name){
        return this.collection.stream().filter(vehicle ->vehicle.getName().startsWith(name)).toList();
    }
}
