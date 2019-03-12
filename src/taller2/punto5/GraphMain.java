/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.punto5;

/**
 *
 * @author juan.castro
 */
public class GraphMain {
    
    public static void main(String[] args)
    {
        Graph<Integer> graph = new Graph<>();
        
        Vertex<Integer> v1 = new Vertex<>("V1");
        Vertex<Integer> v2 = new Vertex<>("V2");
        Vertex<Integer> v3 = new Vertex<>("V3");
        Vertex<Integer> v4 = new Vertex<>("V4");
        Vertex<Integer> v5 = new Vertex<>("V5");
        Vertex<Integer> v6 = new Vertex<>("V6");
        Vertex<Integer> v7 = new Vertex<>("V7");
        
        graph.addVertex("V1");
        graph.addVertex("V2");
        graph.addVertex("V3");
        graph.addVertex("V4");
        graph.addVertex("V5");
        graph.addVertex("V6");
        graph.addVertex("V7");
        
        graph.addEdge(v1, v2, 2);
        graph.addEdge(v1, v4, 1);
        graph.addEdge(v2, v5, 10);
        graph.addEdge(v2, v4, 3);
        graph.addEdge(v3, v1, 4);
        graph.addEdge(v3, v6, 5);
        graph.addEdge(v4, v3, 2);
        graph.addEdge(v4, v5, 2);
        graph.addEdge(v4, v6, 8);
        graph.addEdge(v4, v7, 4);
        graph.addEdge(v5, v7, 6);
        graph.addEdge(v7, v6, 1);
        
        graph.dijkstra(v1);        
        System.out.println("Shortest path from v1 to v2");
        graph.printPath(v2);
        System.out.println("Shortest path from v1 to v3");
        graph.printPath(v3);
        System.out.println("Shortest path from v1 to v4");
        graph.printPath(v4);
        System.out.println("Shortest path from v1 to v5");
        graph.printPath(v5);
        System.out.println("Shortest path from v1 to v6");
        graph.printPath(v6);
        System.out.println("Shortest path from v1 to v7");
        graph.printPath(v7);

        
        Graph<Integer> graph2 = new Graph<>();
        
        Vertex<Integer> a = new Vertex<>("A");
        Vertex<Integer> b = new Vertex<>("B");
        Vertex<Integer> c = new Vertex<>("C");
        Vertex<Integer> d = new Vertex<>("D");
        Vertex<Integer> e = new Vertex<>("E");
        Vertex<Integer> f = new Vertex<>("F");
        Vertex<Integer> g = new Vertex<>("G");
        
        graph2.addVertex("A");
        graph2.addVertex("B");
        graph2.addVertex("C");
        graph2.addVertex("D");
        graph2.addVertex("E");
        graph2.addVertex("F");
        graph2.addVertex("G");
        
        graph2.addEdge(a, b, 5);
        graph2.addEdge(a, c, 3);
        graph2.addEdge(b, c, 2);
        graph2.addEdge(b, e, 3);
        graph2.addEdge(b, g, 1);
        graph2.addEdge(c, d, 7);
        graph2.addEdge(c, e, 7);
        graph2.addEdge(d, a, 2);
        graph2.addEdge(d, f, 6);
        graph2.addEdge(e, d, 2);
        graph2.addEdge(e, f, 1);
        graph2.addEdge(g, e, 1);
        
        System.out.println("GRAPH 2");
        
        graph2.dijkstra(a);        
        System.out.println("Shortest path from A to B");
        graph2.printPath(b);
        System.out.println("Shortest path from A to C");
        graph2.printPath(c);
        System.out.println("Shortest path from A to D");
        graph2.printPath(d);
        System.out.println("Shortest path from A to E");
        graph2.printPath(e);
        System.out.println("Shortest path from A to F");
        graph2.printPath(f);
        System.out.println("Shortest path from A to G");
        graph2.printPath(g);
        
        
        
        
    }
    
}
