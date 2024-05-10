package client.Parsers;

import common.Exceptions.InvalidDataException;

@FunctionalInterface
public interface Parser<T> {
    /**
     * Method to parse value from String
     * @param s String to parse from
     * @return Parsed object
 //    * @throws InvalidDataException If input String is not valid
     */
    T parse(String s) throws InvalidDataException;
}
