/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

/**
 *
 * @author jccas
 */
public class WeightedEdge<T extends Comparable> implements Comparable {
    
    Vertex<T> vertex;
    int weight;

    public WeightedEdge(Vertex<T> vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    public void setVertex(Vertex<T> vertex) {
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    
    
    
    @Override
    public int compareTo(Object o) {
        return 0;
    }
    
}
