package com.gameoflife.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private final int port;
    private final String address;

    public Client(String address, int port) {
        this.port = port;
        this.address = address;
    }

    public void connect() {
        try {
            Socket socket = new Socket(this.address, this.port);
            System.out.println("client connected");
            // TODO: send client details to the server

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String line = "";
            while(!line.equals("exit")) {
                line = input.readLine();
                out.writeUTF(line);
            }
            input.close();
            out.close();
            socket.close();

            System.out.println("Connection finished");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
