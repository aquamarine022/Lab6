package server.Commands;

import common.Network.Request.FilterStartsWithNameCommandRequest;
import common.Network.Request.Request;
import common.Network.Response.FilterStartsWithNameCommandResponse;
import common.Network.Response.Response;
import server.Managers.CollectionManager;

public class FilterStartsWithName extends Command{
    private final CollectionManager collectionManager;
    public FilterStartsWithName(CollectionManager collectionManager) {
        super("filter_starts_with_name", "вывести элементы, начинающиеся с заданного значения");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request) {
        try {
            var req = (FilterStartsWithNameCommandRequest) request;
            return new FilterStartsWithNameCommandResponse(
                    collectionManager.getStartsWithName(req.getFilterByName()), null);
        } catch (Exception e) {
            return new FilterStartsWithNameCommandResponse(null, e.toString());
        }
    }

}
