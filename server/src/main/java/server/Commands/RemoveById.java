package server.Commands;

import common.Network.Request.RemoveByIdRequest;
import common.Network.Request.Request;
import common.Network.Response.RemoveByIdResponse;
import common.Network.Response.Response;
import server.Managers.CollectionManager;

public class RemoveById extends Command{
    private final CollectionManager collectionManager;
    public RemoveById(CollectionManager collectionManager) {
        super("remove_by_id", "удалить элемент из коллекции по его id");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request) {
        try {
            var req = (RemoveByIdRequest) request;

            if (!collectionManager.containsId(req.getId())) {
                return new RemoveByIdResponse("Транспорта с таким ID не найдено");
            } else {
                collectionManager.removeById(req.getId());
                return new RemoveByIdResponse(null);
            }
        } catch (Exception e) {
            return new RemoveByIdResponse(e.toString());
        }
    }
}
