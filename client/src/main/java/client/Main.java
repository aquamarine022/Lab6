package client;

import client.Network.ClientManager;
import client.Network.Configuration;
import client.Utils.Runner;
import client.Utils.ScriptManager;
import common.Utility.Console;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger("Logger");

    public static void main(String[] args){

        String host = args[0];
        String strPort = args[1];

        if (host == null || strPort == null){
            logger.log(Level.WARNING, "Хост и порт не были переданы через аргумент командной строки");
            return;
        }

        int port = Integer.parseInt(strPort);
        Configuration.setHost(host);
        Configuration.setPort(port);

        ScriptManager scriptManager = new ScriptManager();
        ClientManager clientManager = new ClientManager();

        new Runner(Console.getInstance(), clientManager, scriptManager).interactiveMode();
    }
}
