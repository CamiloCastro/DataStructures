/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.punto5;

import datastructure.list.MyDoubleLinkedList;

/**
 *
 * @author jccas
 */
public class Vertex<T extends Comparable> {
    
    String name;
    MyDoubleLinkedList<WeightedEdge<T>> adjacents;
    boolean known;
    int dist;
    Vertex path;    
    
}
