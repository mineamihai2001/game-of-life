package com.gameoflife.server.connections;

import java.net.Socket;

public class Connection {
    private String name;
    private String ip;
    private long connectedTime;

    public Connection(String name, Socket socket) {
        this.name = name;
        this.ip = socket.getRemoteSocketAddress().toString();
        this.connectedTime = System.currentTimeMillis()/ 1000; // seconds
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getConnectedTime() {
        return connectedTime;
    }

    public void setConnectedTime(long connectedTime) {
        this.connectedTime = connectedTime;
    }
}
