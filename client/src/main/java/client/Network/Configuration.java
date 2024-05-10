package client.Network;

public class Configuration {

    private static String host;
    private static int port;
    public static void setHost(String host) {
        Configuration.host = host;
    }

    public static void setPort(int port) {
        Configuration.port = port;
    }

    public static String getHost() {
        return host;
    }

    public static int getPort() {
        return port;
    }

}
