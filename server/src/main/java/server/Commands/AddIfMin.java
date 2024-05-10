package server.Commands;

import common.Network.Request.AddIfMinRequest;
import common.Network.Request.AddRequest;
import common.Network.Request.Request;
import common.Network.Response.AddIfMinResponse;
import common.Network.Response.AddResponse;
import common.Network.Response.Response;
import server.Managers.CollectionManager;

public class AddIfMin extends Command{
    private final CollectionManager collectionManager;
    public AddIfMin(CollectionManager collectionManager){
        super("add_if_min", "добавить элемент, если он наименьший");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        try {
            var req = (AddIfMinRequest) request;
            collectionManager.addIfMin(req.getVehicle());
            return new AddIfMinResponse(null);
        }catch (Exception e){
            return new AddIfMinResponse(e.toString());
        }
    }
}
