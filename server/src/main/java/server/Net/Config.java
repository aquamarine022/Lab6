package server.Net;

public class Config {
    private static String host;
    private static int port;
    public static void setHost(String host) {
        Config.host = host;
    }

    public static void setPort(int port) {
        Config.port = port;
    }

    public static String getHost() {
        return host;
    }

    public static int getPort() {
        return port;
    }
}
