package com.gameoflife.client;

import java.io.*;
import java.net.Socket;

public class MainClient {
    private static final int PORT = 9999;
    private static final String ADDRESS = "127.0.0.1";

    public static void main(String[] args) {
        Client client = new Client(ADDRESS, PORT);
        client.connect();
    }
}
