package server.Managers;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import common.Data.Vehicle;
import common.Loader;
import common.Utility.Console;
import server.JSON.CreationDateDeserializer;
import server.JSON.CreationDateSerializer;
import server.Main;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Scanner;

public class FileDataManager {
    /**
     * path to file with data
     */
    private final File file;
    /**
     * object for operations with Json
     */
    private final Gson gson;

    /**
     * conctructor
     * @param file file with data
     */
    public FileDataManager(File file){
        this.file = file;

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new CreationDateDeserializer());
        gsonBuilder.registerTypeAdapter(Date.class, new CreationDateSerializer());

        this.gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
    }

    /**
     * Metod to input collection to file
     * @param data collection to write
     * @throws IOException in case there are errors while writing
     */
    public void writeToFile(ArrayDeque<Vehicle> data) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        Type dataType = new TypeToken<ArrayDeque<Vehicle>>() {}.getType();
        String output = this.gson.toJson(data, dataType);
        fileWriter.write(output);
        fileWriter.flush();
        fileWriter.close();
    }


    /**
     * Method to read data from file
     * @return collection
     * @throws IOException in case there are errors while reading
     * @throws JsonParseException in case there are troubles with deserializing
     */
    public ArrayDeque<Vehicle> readJSON() throws IOException, JsonParseException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        Type dataType = new TypeToken<ArrayDeque<Vehicle>>(){}.getType();
        return this.gson.fromJson(new JsonReader(inputStreamReader), dataType);
    }

}
