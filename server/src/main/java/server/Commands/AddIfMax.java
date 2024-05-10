package server.Commands;

import common.Network.Request.AddIfMaxRequest;
import common.Network.Request.AddIfMinRequest;
import common.Network.Request.Request;
import common.Network.Response.AddIfMinResponse;
import common.Network.Response.Response;
import server.Managers.CollectionManager;

public class AddIfMax extends Command{
    private final CollectionManager collectionManager;

    public AddIfMax(CollectionManager collectionManager) {
        super("add_if_max", "добавить новый элемент, если он наибольший");
        this.collectionManager = collectionManager;
    }
    @Override
    public Response execute(Request request){
        try {
            var req = (AddIfMaxRequest) request;
            collectionManager.addIfMin(req.getVehicle());
            return new AddIfMinResponse(null);
        }catch (Exception e){
            return new AddIfMinResponse(e.toString());
        }
    }
}
