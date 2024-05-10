package server.Net;

import common.Network.Request.Request;
import common.Network.Response.Response;
import common.Utility.Console;
import server.Main;
import server.Managers.CollectionManager;
import server.Managers.CommandHandler;
import server.Managers.CommandManager;
import server.Managers.FileDataManager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.logging.Level;

public class ServerManager {
    private final Server server;
    private final CommandManager commandManager;
    private final CommandHandler commandHandler;
    private final FileDataManager fileDataManager;
    private final CollectionManager collectionManager;
    private final Console console;

    //private Runnable afterHook;

    public ServerManager(CommandManager commandManager, FileDataManager fileDataManager, CollectionManager collectionManager, Console console) {
        this.fileDataManager = fileDataManager;
        this.collectionManager = collectionManager;
        this.console = console;
        server = new Server(Config.getHost(), Config.getPort());
        this.commandManager = commandManager;
        commandHandler = new CommandHandler(this.commandManager);
    }

    public void start() throws IOException{
        server.run();
    }

    public void writeRes(SocketChannel socketChannel, Response response){
        try {
            server.writeObject(socketChannel, response);
        }catch (IOException e){
            Main.logger.log(Level.WARNING, "Не удалось передать данные");
        }
    }

    public void handlerSocketChanel(SocketChannel socketChannel) throws IOException{
        Request request;
        try {
            request = (Request) server.getObject(socketChannel);
            Response response = commandHandler.handler(request);
            writeRes(socketChannel,response);
        }catch (IOException|ClassNotFoundException e){
            Main.logger.log(Level.WARNING, e.toString());
        }catch (ClassCastException e){
            Main.logger.log(Level.WARNING, e.toString());
        }finally {
            socketChannel.close();
        }
    }

    public void run(){
        SocketChannel socketChannel;
        Reader reader = new InputStreamReader(System.in);
        Scanner scanner = new Scanner(reader);
        console.setScanner(scanner);
        while(true){
            try {
                if (reader.ready()){
                    String input = console.readLine();
                    if(input.equals("save")){
                        fileDataManager.writeToFile(collectionManager.getCollection());
                        Main.logger.log(Level.INFO, "Коллекция успешно сохранена");
                    }else if (input.equals("exit")){
                        fileDataManager.writeToFile(collectionManager.getCollection());
                        Main.logger.log(Level.INFO, "Коллекция успешно сохранена");
                        System.exit(0);
                    }else {
                        Main.logger.log(Level.WARNING, "Неизвестная команда");
                    }
                }
            } catch (IOException e) {
                Main.logger.log(Level.WARNING, "Неизвестная ошибка");
            }
            try {
                socketChannel = server.getSocket();
                if (socketChannel == null) continue;
                handlerSocketChanel(socketChannel);
            }catch (IOException e){
                Main.logger.log(Level.WARNING, e.toString());
            }
        }
    }

}
