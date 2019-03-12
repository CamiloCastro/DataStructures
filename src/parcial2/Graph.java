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
public class Graph<T extends Comparable> {
    
    ChainingHashTable<Vertex<T>> vertexes;
    MyDoubleLinkedList<String> vertexNames;
    int vertexSize;
    int edgeSize;
    
    public Graph()
    {
        vertexes = new ChainingHashTable<>();
        vertexSize = 0;
        edgeSize = 0;
        vertexNames = new MyDoubleLinkedList<>();
    }
    
    public void addVertex(String name)
    {
        Vertex<T> vertex = new Vertex<>(name);
        vertex.setCode(vertexSize);
        vertexes.insert(vertex);
        vertexSize++;
        vertexNames.add(name);
    }
    
    public void addEdge(Vertex v1, Vertex v2, int weight)
    {
        v1 = vertexes.get(v1);
        v2 = vertexes.get(v2);
        WeightedEdge<T> edge = new WeightedEdge<>(v2, weight);
        v1.getAdjacents().add(edge);
        edgeSize++;
    }
    
    public MyDoubleLinkedList<Edge> minimumSpanningTree()
    {
        Edge[] edges = new Edge[edgeSize];
        int contEdge=0;
        for(int i = 0;i < vertexSize; i++)
        {
            Vertex<T> vertex = vertexes.get(new Vertex<>(vertexNames.get(i)));
            for(int j = 0;j < vertex.getAdjacents().size();j++)
            {
                edges[contEdge] = new Edge(vertex, vertex.getAdjacents().get(j).getVertex(), vertex.getAdjacents().get(j).getWeight());
                contEdge++;
            }            
        }
        
        return kruskal(edges);
    }
    
    private MyDoubleLinkedList<Edge> kruskal(Edge[] edges)
    {
        DisjointSets ds = new DisjointSets(vertexSize);
        BinaryHeap<Edge> pq = new BinaryHeap<>();
        pq.buildHeap(edges);
        MyDoubleLinkedList<Edge> mst = new MyDoubleLinkedList<>();
        
        while(mst.size() != vertexSize - 1)
        {
            Edge e = pq.deleteMin();
            int c1 = ds.find(e.getV1().getCode());
            int c2 = ds.find(e.getV2().getCode());
            if(c1 != c2)
            {
                mst.add(e);
                ds.union(c1,c2);
            }
        }
        
        return mst;
    }
            
            
    
}
