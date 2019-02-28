/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.punto5;

/**
 *
 * @author jccas
 */
public class WeightedEdge<T extends Comparable> implements Comparable {
    
    Vertex<T> vertex;
    int weight;

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    
}
