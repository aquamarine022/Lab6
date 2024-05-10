package client.Parsers;

import common.Exceptions.InvalidDataException;
import common.Data.*;

/**
 * Class with parsers which are required to read Worker objects
 */
public class Parsers {
    /**
     * String parser
     */
    public static Parser<String> stringParser = s -> s;
    /**
     * Long parser
     */
    public static Parser<Long> longParser = s -> {
        try{
            return Long.parseLong(s);
        } catch (NumberFormatException e){
            throw new InvalidDataException("Value must be a long!");
        }
    };
    /**
     * Integer parser
     */
    public static Parser<Integer> integerParser = s -> {
        try{
            return Integer.parseInt(s);
        } catch (NumberFormatException e){
            throw new InvalidDataException("Value must be an integer!");
        }
    };
    /**
     * Double parser
     */
    public static Parser<Float> floatParser = s -> {
        try{
            return Float.parseFloat(s);
        } catch (NumberFormatException e){
            throw new InvalidDataException("Value must be a float!");
        }
    };
    /**
     * VehicleType parser
     */
    public static Parser<VehicleType> statusParser = s -> {
        try{
            return VehicleType.valueOf(s);
        } catch (IllegalArgumentException e){
            throw new InvalidDataException("VehicleType not found! Please choose value from list!");
        }
    };
}
