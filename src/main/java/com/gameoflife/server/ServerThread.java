package com.gameoflife.server;

import com.gameoflife.server.connections.Connection;
import com.gameoflife.server.connections.ConnectionsManager;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

public class ServerThread extends Thread implements ConnectionsManager {
    private final Socket socket;

    public ServerThread(Socket socket) {
        System.out.println("client connected");
        this.socket = socket;
        this.update(new Connection("clientX", socket)); // add the new client to the map
    }

    public void run() {
        try {
            DataInputStream input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while (!line.equals("exit")) {
                if(line.equals("list")) {
                    this.list();
                }
                line = input.readUTF();
                System.out.println(line);
            }

            System.out.println("client disconnected");

            socket.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Connection conn) {
        connectionMap.put(connectionMap.size(), conn);
    }

    @Override
    public void list() {
        System.out.println("**********ACTIVE CONNECTIONS***********");
        for(Map.Entry<Integer, Connection> conn: connectionMap.entrySet()) {
            System.out.println("client" + conn.getKey() + " --> " + conn.getValue().getName());
        }
    }
}
