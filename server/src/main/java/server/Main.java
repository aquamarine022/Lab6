package server;

import common.Loader;
import common.Utility.Console;

import server.Commands.*;
import server.Managers.*;
import server.Net.Config;
import server.Net.ServerManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static final Logger logger = Logger.getLogger("ServerLogger");
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String host = args[1];
        String strPort = args[2];
        if((fileName == null)) {
            Main.logger.log(Level.WARNING,"Имя файла не было передано через аргумент командной строки" );
        }

        if (host == null || strPort == null){
            logger.log(Level.WARNING, "Хост и порт не были переданы через аргумент командной строки");
            return;
        }

        int port = Integer.parseInt(strPort);
        Config.setHost(host);
        Config.setPort(port);

        File scriptFile = null;
        try {
            scriptFile = new Loader().loadFile(fileName, "json", "rw", "data file");
        } catch (FileNotFoundException e) {
            Console.getInstance().printError(e.getMessage());
            System.exit(0);
        }


        CollectionManager collectionManager = new CollectionManager();
        FileDataManager fileDataManager = new FileDataManager(scriptFile);

        collectionManager.addAll(fileDataManager.readJSON());


        CommandManager commandManager = new CommandManager();
        commandManager.createCommand(new Add(collectionManager));
        commandManager.createCommand(new AddIfMax(collectionManager));
        commandManager.createCommand(new AddIfMin(collectionManager));
        commandManager.createCommand(new Clear(collectionManager));
        commandManager.createCommand(new MinByName(collectionManager));
        commandManager.createCommand(new RemoveHead(collectionManager));
        commandManager.createCommand(new RemoveById(collectionManager));
        commandManager.createCommand(new RemoveByEnginePower(collectionManager));
        commandManager.createCommand(new Help(commandManager));
        commandManager.createCommand(new Info(collectionManager));
        commandManager.createCommand(new FilterStartsWithName(collectionManager));
        commandManager.createCommand(new Show(collectionManager));
        commandManager.createCommand(new Update(collectionManager));


        ServerManager serverManager = new ServerManager(commandManager,fileDataManager,collectionManager, Console.getInstance());

        try{
            serverManager.start();
            logger.log(Level.INFO, "Сервер запущен");
        } catch (IOException e){
            logger.log(Level.WARNING, "Не удалось запустить сервер");
        }

        serverManager.run();
    }
}
