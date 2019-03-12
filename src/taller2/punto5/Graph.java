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
public class Graph<T extends Comparable> {
    
    ChainingHashTable<Vertex<T>> vertexes;
    
    public Graph()
    {
        vertexes = new ChainingHashTable<>();
    }
    
    public void addVertex(String name)
    {
        Vertex<T> vertex = new Vertex<>(name);
        vertexes.insert(vertex);
    }
    
    public void addEdge(Vertex v1, Vertex v2, int weight)
    {
        v1 = vertexes.get(v1);
        v2 = vertexes.get(v2);
        WeightedEdge<T> edge = new WeightedEdge<>(v2, weight);
        v1.getAdjacents().add(edge);
    }
    
    public void dijkstra(Vertex<T> s)
    {
        BinaryHeap<Vertex<T>> heap = new BinaryHeap<>();
        s = vertexes.get(s);
        s.setDist(0);
        
        heap.insert(s);
        
        while(!heap.isEmpty())
        {
            Vertex<T> v = heap.deleteMin();
            if(v.isKnown())
                continue;
            v.setKnown(true);
            for(int i=0;i<v.getAdjacents().size();i++)
            {
                WeightedEdge<T> edge = v.getAdjacents().get(i);
                if(v.getDist() + edge.getWeight() < edge.getVertex().getDist())
                {
                    edge.getVertex().setDist(v.getDist() + edge.getWeight());
                    edge.getVertex().setPath(v);
                    heap.insert(edge.getVertex());
                }
            }
        }
    }
    
    private void printPathHelper(Vertex<T> v)
    {
        if(v.getPath() != null)
        {
            printPath(v.getPath());
            System.out.println(" to ");
        }
        System.out.println(v);
    }
    
    public void printPath(Vertex<T> v)
    {
        v = vertexes.get(v);
        printPathHelper(v);
        
    }
            
            
    
}
