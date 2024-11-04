package it.unibo.generics.graph.impl;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

    private List<N> findPathBFS(final N source, final N target){
        final Map<N,N> visitedNodesAndParent = new HashMap<>();
        final Queue<N> nodesToVisit = new LinkedList<>();

        visitedNodesAndParent.put(source, null);
        nodesToVisit.add(source);

        while(!nodesToVisit.isEmpty() && !visitedNodesAndParent.containsKey(target)){
            N current = nodesToVisit.remove();

            for(N node : linkedNodes(current)){
                if(!visitedNodesAndParent.containsKey(node)){
                    visitedNodesAndParent.put(node, current);
                    nodesToVisit.add(node);
                }
            }
        }

        if(!visitedNodesAndParent.containsKey(target)){
            return Collections.emptyList();
        }

        N parent = visitedNodesAndParent.get(target);
        final List<N> path = new LinkedList<>();
        path.addFirst(target);
        while (parent != null) {
            path.addFirst(parent);
            parent = visitedNodesAndParent.get(parent);
        }

        return path;
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
        if(!nodeExists(source) || !nodeExists(target)){
            return null;
        }

        return findPathBFS(source, target);
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
        return graph.keySet();
    }
    
    
}
