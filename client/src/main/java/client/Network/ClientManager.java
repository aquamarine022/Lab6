package client.Network;

import client.Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import common.Network.Request.Request;
import common.Network.Response.Response;

public class ClientManager {
    Client client;
    private final Logger logger = Main.logger;

    public ClientManager(){
        client = new Client(Configuration.getHost(), Configuration.getPort());
    }

    public Response sendAndReceiveCommand(Request request) throws IOException, ClassNotFoundException{
        client.begin();

        client.writeObject(request);
        Response response = (Response) client.getObject();
        client.close();

        logger.log(Level.OFF, "Logger off");

        logger.info("Получен ответ от сервера" + response);
        return response;
    }
}
