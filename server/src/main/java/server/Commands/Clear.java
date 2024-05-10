package server.Commands;

import common.Network.Request.Request;
import common.Network.Response.ClearResponse;
import common.Network.Response.Response;
import server.Managers.CollectionManager;

public class Clear extends Command{
   private final CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        try {
            collectionManager.clear();
            return new ClearResponse(null);
        }catch (Exception e){
            return new ClearResponse(e.toString());
        }
    }
}
