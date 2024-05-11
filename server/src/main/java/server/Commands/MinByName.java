package server.Commands;

import common.Network.Request.MinByNameRequest;
import common.Network.Response.MinByNameResponse;
import common.Network.Response.Response;
import server.Managers.CollectionManager;
import common.Network.Request.Request;

public class MinByName extends Command{
    private final CollectionManager collectionManager;
    public MinByName(CollectionManager collectionManager) {
        super("min_by_name", "вывести любой объект из коллекции, значение поля name которого является минимальным");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request) {
        try {
            var req = (MinByNameRequest) request;
            if (collectionManager.getCollection().isEmpty()) {
                return new MinByNameResponse(null, "коллекция пуста");
            } else {
                return new MinByNameResponse(collectionManager.getMinByName(), null);
            }
        } catch (Exception e) {
            return new MinByNameResponse(null, e.toString());
        }
    }
}
