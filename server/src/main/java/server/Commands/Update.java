package server.Commands;

import common.Network.Request.Request;
import common.Network.Request.UpdateByIdRequest;
import common.Network.Response.Response;
import common.Network.Response.UpdateByIdResponse;
import server.Managers.CollectionManager;

public class Update extends Command{
    private final CollectionManager collectionManager;

    public Update(CollectionManager collectionManager) {
        super("update_id", "обновить значение элемента коллекции, id которого равен заданному");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request) {
        try {
            var req = (UpdateByIdRequest) request;
            collectionManager.update(req.getId(),req.getVehicle());
            return new UpdateByIdResponse(null);
        } catch (Exception e) {
            return new UpdateByIdResponse(e.toString());
        }
    }
}
