package com.gameoflife.server;

public class MainServer {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        Server server = Server.getInstance(PORT);
        server.start();
    }
}
