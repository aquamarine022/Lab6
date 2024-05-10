package server.Commands;

import common.Network.Request.AddRequest;
import common.Network.Request.Request;
import common.Network.Response.AddResponse;
import common.Network.Response.Response;
import server.Managers.CollectionManager;

public class Add extends Command{
    private final CollectionManager collectionManager;
    public Add(CollectionManager collectionManager){
        super("add", "add new element to collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        try {
            var req = (AddRequest) request;
            collectionManager.add(req.getVehicle());
            return new AddResponse(null);
        }catch (Exception e){
            return new AddResponse(e.toString());
        }
    }
}
