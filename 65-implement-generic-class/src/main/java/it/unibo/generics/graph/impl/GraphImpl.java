package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private final Map<N,Set<N>> graph;


    public GraphImpl(){
        graph = new HashMap<>();
    }

    @Override
    public void addEdge(N source, N target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addNode(N node) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<N> linkedNodes(N node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<N> nodeSet() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
