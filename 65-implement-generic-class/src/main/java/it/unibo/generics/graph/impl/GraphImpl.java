package it.unibo.generics.graph.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private final Map<N,Set<N>> graph;


    public GraphImpl(){
        graph = new HashMap<>();
    }

    private boolean nodeExists(final N node){
        return graph.containsKey(node);
    }

    @Override
    public void addEdge(N source, N target) {
        if(!nodeExists(source) || !nodeExists(target)){
            return;
        }

        linkedNodes(source).add(target);
    }

    @Override
    public void addNode(N node) {
        if(node == null || nodeExists(node)){
            return;
        }

        graph.put(node, new HashSet<>());
    }

    @Override
    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<N> linkedNodes(N node) {
        if(!nodeExists(node)){
            return null;
        }

        return graph.get(node);
    }

    @Override
    public Set<N> nodeSet() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
