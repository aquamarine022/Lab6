package server.Commands;

import common.Network.Request.RemoveAnyByEnginePowerRequest;
import common.Network.Request.RemoveByIdRequest;
import common.Network.Request.Request;
import common.Network.Response.RemoveAnyByEnginePowerResponse;
import common.Network.Response.RemoveByIdResponse;
import common.Network.Response.Response;
import server.Managers.CollectionManager;

public class RemoveByEnginePower extends Command{
    private final CollectionManager collectionManager;
    public RemoveByEnginePower(CollectionManager collectionManager) {
        super("remove_by_engine_power", "удалить элемент из коллекции по его engine power");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request) {
        try {
            var req = (RemoveAnyByEnginePowerRequest) request;

            if (!collectionManager.containsEnginePower(req.getEnginePower())) {
                return new RemoveAnyByEnginePowerResponse("Транспорта с таким engine power не найдено");
            } else {
                collectionManager.removeByEnginePower(req.getEnginePower());
                return new RemoveAnyByEnginePowerResponse(null);
            }
        } catch (Exception e) {
            return new RemoveAnyByEnginePowerResponse(e.toString());
        }
    }
}
