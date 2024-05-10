package server.Managers;

import common.Data.Vehicle;
import common.Loader;
import common.Utility.Console;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;

public class LoadManager {
    private static FileDataManager fileDataManager;
    public ArrayDeque<Vehicle> loadJSON(){
        ArrayDeque<Vehicle> data = null;
        try {
            data = fileDataManager.readJSON();
        } catch (Exception e) {
            Console.getInstance().printError(e.getMessage());
            Console.getInstance().printError("Data file reading error!");
            System.exit(0);
        }
        if (data==null) data = new ArrayDeque<>();
        if(!CollectionManager.isValid(data)){
            Console.getInstance().printError("Data file is not valid!");
            System.exit(0);
        }
        Console.getInstance().printLn("Data loaded successfully!\nPrint help to see all commands");
        return data;
    }
}
