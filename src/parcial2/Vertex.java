/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

import java.util.Objects;

/**
 *
 * @author jccas
 */
public class Vertex<T extends Comparable> implements Comparable<Vertex> {
    
    String name;
    MyDoubleLinkedList<WeightedEdge<T>> adjacents;
    boolean known;
    int dist;
    Vertex path;
    int code;
    
    public Vertex(String name)
    {
        this.name = name;
        adjacents = new MyDoubleLinkedList<>();
        known = false;
        dist = Integer.MAX_VALUE;
        path = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDoubleLinkedList<WeightedEdge<T>> getAdjacents() {
        return adjacents;
    } 

    public boolean isKnown() {
        return known;
    }

    public void setKnown(boolean known) {
        this.known = known;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public Vertex getPath() {
        return path;
    }

    public void setPath(Vertex path) {
        this.path = path;
    }

    @Override
    public int compareTo(Vertex o) {
        return Integer.compare(this.dist, o.getDist());
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex<?> other = (Vertex<?>) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
    
    
    
    
    
}
