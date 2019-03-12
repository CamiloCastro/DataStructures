/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

import java.util.Objects;

/**
 *
 * @author juan.castro
 */
public class Edge implements Comparable<Edge>{
    
    private Vertex v1;
    
    private Vertex v2;
    
    private int weight;
    
    

    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
        
    }

    public Vertex getV1() {
        return v1;
    }

    public void setV1(Vertex v1) {
        this.v1 = v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public void setV2(Vertex v2) {
        this.v2 = v2;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.getWeight());
    }

    @Override
    public String toString() {
        return "Edge{" + v1.getName() + ", " + v2.getName() + ", weight=" + weight + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.weight;
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
        final Edge other = (Edge) obj;
        if (this.weight != other.weight) {
            return false;
        }
        
        if(Objects.equals(this.v1.getName(), other.getV1().getName()) && Objects.equals(this.v2.getName(), other.getV2().getName()))
            return true;
        
        if(Objects.equals(this.v1.getName(), other.getV2().getName()) && Objects.equals(this.v2.getName(), other.getV1().getName()))
            return true;
        
        return false;
    }
    
    
    

    
    
    
    
    
    
}
