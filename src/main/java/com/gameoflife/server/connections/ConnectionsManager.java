package com.gameoflife.server.connections;

import java.util.HashMap;
import java.util.Map;

public interface ConnectionsManager {
    /**
     * connectionMap stores all the active connections
     */
    public Map<Integer, Connection> connectionMap =new HashMap<>();

    /**
     * Updates the connection map
     * @param conn
     */
    public void update(Connection conn);

    /**
     * list all the active connections
     */
    public void list();

}
