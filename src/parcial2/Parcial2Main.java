/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author juan.castro
 */
public class Parcial2Main {

    public static void main(String[] args) {

        Graph<Integer> g1 = new Graph<>();
        
        Vertex<Integer> v1 = new Vertex<>("V1");
        Vertex<Integer> v2 = new Vertex<>("V2");
        Vertex<Integer> v3 = new Vertex<>("V3");
        Vertex<Integer> v4 = new Vertex<>("V4");
        Vertex<Integer> v5 = new Vertex<>("V5");
        Vertex<Integer> v6 = new Vertex<>("V6");
        Vertex<Integer> v7 = new Vertex<>("V7");
        
        g1.addVertex("V1");
        g1.addVertex("V2");
        g1.addVertex("V3");
        g1.addVertex("V4");
        g1.addVertex("V5");
        g1.addVertex("V6");
        g1.addVertex("V7");
        
        g1.addEdge(v1, v2, 2);
        g1.addEdge(v1, v4, 1);
        g1.addEdge(v2, v5, 10);
        g1.addEdge(v2, v4, 3);
        g1.addEdge(v3, v1, 4);
        g1.addEdge(v3, v6, 5);
        g1.addEdge(v4, v3, 2);
        g1.addEdge(v4, v5, 7);
        g1.addEdge(v4, v6, 8);
        g1.addEdge(v4, v7, 4);
        g1.addEdge(v5, v7, 6);
        g1.addEdge(v7, v6, 1);
        
        MyDoubleLinkedList<Edge> realEdges = new MyDoubleLinkedList<>();
        
        realEdges.add(new Edge(v1, v4, 1));
        realEdges.add(new Edge(v7, v6, 1));
        realEdges.add(new Edge(v1, v2, 2));
        realEdges.add(new Edge(v3, v4, 2));
        realEdges.add(new Edge(v7, v4, 4));
        realEdges.add(new Edge(v7, v5, 6));
        
        MyDoubleLinkedList<Edge> edges = g1.minimumSpanningTree();
        
        for(int i = 0; i < edges.size(); i++)
        {
            System.out.println(edges.get(i).toString());
            int contVerify = 0;
            for(int j = 0; j < realEdges.size();j++)
            {
                if(realEdges.get(j).equals(edges.get(i)))
                    break;
                contVerify++;
            }
            if(contVerify == realEdges.size())
            {
                System.out.println("Something is wrong");
                return;
            }            
        }
        
        System.out.println("All is ok");
        
                

    }
    
    

}
