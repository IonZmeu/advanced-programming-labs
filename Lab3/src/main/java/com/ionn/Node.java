package com.ionn;

import java.util.HashMap;
import java.util.Map;

public interface Node {
    String getName();
    int getConnections();
    void addRelationship(Node node, String value);
}
