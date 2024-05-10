package client.Readers;


import client.Parsers.Parser;
import common.Constants;
import common.Exceptions.InvalidDataException;
import common.Utility.Console;
import common.Validators.Validator;

public abstract class ValueReader {

    public <T> T readValue(String valueName, Validator<T> validator, Parser<T> parser) throws InvalidDataException {
        T value;
        while (true) {
            if(!Constants.SCRIPT_MODE) Console.getInstance().print("Enter " + valueName + ": ");
            String s = Console.getInstance().readLine().trim();
            try {
                value = s.isEmpty() ? null : parser.parse(s);
                validator.validate(value);
                break;
            } catch (InvalidDataException e){
                if(Constants.SCRIPT_MODE) throw e;
                else{
                    Console.getInstance().printLn(e.getMessage());
                }
            }
        }
        return value;
    }
}
