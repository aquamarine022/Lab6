package server.Commands;

import common.Network.Request.Request;
import common.Network.Response.Response;
import common.Network.Response.ShowResponse;
import server.Managers.CollectionManager;

public class Show extends Command {
    private final CollectionManager collectionManager;
    public Show(CollectionManager collectionManager) {
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request) {
        try {
            return new ShowResponse(collectionManager.getCollection(), null);
        } catch (Exception e) {
            return new ShowResponse(null, e.toString());
        }
    }
}
