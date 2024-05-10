package server.Net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server{
    private final String host;
    private final int port;
    private ServerSocketChannel server;

    public Server(String host, int port){
        this.host = host;
        this.port = port;
    }

    public void run() throws IOException{
        server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(host, port));
    }

    public SocketChannel getSocket() throws IOException{
        return server.accept();
    }

    public Object getObject(SocketChannel socketChannel) throws IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(socketChannel.socket().getInputStream());
        Object res = ois.readObject();
        return res;
    }

    public void writeObject(SocketChannel socketChannel, Serializable object) throws  IOException{
        ObjectOutputStream oos = new ObjectOutputStream(socketChannel.socket().getOutputStream());
        oos.writeObject(object);
    }

    public void close() throws IOException{
        server.close();
    }
}
