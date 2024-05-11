package server.Commands;

import common.Network.Request.RemoveHeadRequest;
import common.Network.Request.Request;
import common.Network.Response.RemoveHeadResponse;
import common.Network.Response.Response;
import server.Managers.CollectionManager;

public class RemoveHead extends Command{
    private final CollectionManager collectionManager;
    public RemoveHead(CollectionManager collectionManager){
        super("remove_head", "удалить верхний элемент коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        try {
            var req = (RemoveHeadRequest) request;
            if (collectionManager.getCollection().isEmpty()){
                return new RemoveHeadResponse("коллекция пуста");
            }else {
                collectionManager.removeHead();
                return new RemoveHeadResponse(null);
            }
        }catch (Exception e){
            return new RemoveHeadResponse(e.getMessage());
        }
    }

}
