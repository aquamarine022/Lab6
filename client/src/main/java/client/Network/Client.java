package client.Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Client {
    private final String host;
    private final int port;
    private Socket socket;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void begin() throws IOException{
        socket = new Socket(host, port);
    }

    public Object getObject() throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        return ois.readObject();
    }

    public void writeObject(Serializable obj) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(obj);
        oos.flush();
    }

    public void close() throws IOException{
        socket.close();
    }
}
