package common.Network.Response;

public class NoSuchCommandResponse extends Response{
    public NoSuchCommandResponse(String name){
        super(name, "Неизвестная комманда");
    }
}
