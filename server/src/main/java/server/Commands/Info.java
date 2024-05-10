package server.Commands;

import common.Network.Request.Request;
import common.Network.Response.InfoResponse;
import common.Network.Response.Response;
import server.Managers.CollectionManager;

public class Info extends Command{
    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        super("info", "вывести информацию о коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        try {
            String message = collectionManager.getInfo();
            return new InfoResponse(message, null);
        }catch (Exception e){
            return new InfoResponse(null, e.toString());
        }
    }
}
