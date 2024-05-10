package server;

import common.Loader;
import common.Utility.Console;

import server.Commands.Add;
import server.Commands.Show;
import server.Managers.CollectionManager;
import server.Managers.CommandManager;
import server.Managers.FileDataManager;
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
            System.out.println("Имя файла не было передано через аргумент командной строки");
            Main.logger.log(Level.WARNING,"Имя файла не было передано через аргумент командной строки" );
        }

        System.out.println(host);
        System.out.println(strPort);

        if (host == null || strPort == null){
            logger.log(Level.WARNING, "Неверные переменные окружения для хоста и порта");
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

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                fileDataManager.writeToFile(collectionManager.getCollection());
            } catch (IOException e) {
                logger.log(Level.WARNING, "что-то пошло не так");
            }
        }));

        CommandManager commandManager = new CommandManager();
        commandManager.createCommand(new Add(collectionManager));
        commandManager.createCommand(new Show(collectionManager));

        ServerManager serverManager = new ServerManager(commandManager,fileDataManager,collectionManager, Console.getInstance());

        try{
            serverManager.start();
            logger.log(Level.INFO, "Сервер запущен");
        } catch (IOException e){
            logger.log(Level.WARNING, "Не удалось запустить сервер");
        }

//        serverManager.setAfterHook(() -> {
//            try {
//                fileDataManager.writeToFile(collectionManager.getCollection());
//            } catch (IOException e) {
//                logger.log(Level.WARNING, "что-то пошло не так");
//            }
//            serverManager.run();
//        });
        serverManager.run();
    }
}
