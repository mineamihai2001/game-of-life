package com.gameoflife.server;

import com.gameoflife.server.connections.ConnectionsManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port;
    private static Server singleton = null;
    private ConnectionsManager connectionsManager;

    private Server(int port) {
        this.port = port;
    }

    public static Server getInstance(int port) {
        if(singleton == null) singleton = new Server(port);
        return singleton;
    }

    public void start() {
        try{
            ServerSocket server = new ServerSocket(this.port);
            System.out.println("waiting for clients...");
            while(true) {
                Socket socket = server.accept();
                ServerThread thread = new ServerThread(socket);
                thread.start();
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void listCurrentConnections() {

    }
}
