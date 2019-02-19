/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.disjointset;

/**
 *
 * @author jccas
 */
public class DisjointSetsExample {
    
    public static void main(String[] args)
    {
        
        DisjointSets normalUnions = new DisjointSets(10);
        DisjointSets unionBySize = new DisjointSets(10);
        DisjointSets unionByHeight = new DisjointSets(10);
        
        normalUnions.union(3, 4);
        normalUnions.union(3, 9);
        normalUnions.union(0, 9);

        unionBySize.unionBySize(3, 4);
        unionBySize.unionBySize(3, 9);
        unionBySize.unionBySize(0, 9);
        
        unionByHeight.unionByHeight(3, 4);
        unionByHeight.unionByHeight(3, 9);
        unionByHeight.unionByHeight(0, 9);
        
        System.out.println("-------NORMAL UNIONS-------");
        
        System.out.println("3 and 9 are related? " + (normalUnions.find(3) == normalUnions.find(9)));
        System.out.println("1 and 4 are related? " + (normalUnions.find(1) == normalUnions.find(4)));
        System.out.println("0 and 4 are related? " + (normalUnions.find(0) == normalUnions.find(4)));
        
        normalUnions.print();
        
        System.out.println("-------UNIONS BY SIZE-------");
        
        System.out.println("3 and 9 are related? " + (unionBySize.find(3) == unionBySize.find(9)));
        System.out.println("1 and 4 are related? " + (unionBySize.find(1) == unionBySize.find(4)));
        System.out.println("0 and 4 are related? " + (unionBySize.find(0) == unionBySize.find(4)));
        
        unionBySize.print();
        
        System.out.println("-------UNIONS BY HEIGHT-------");
        
        System.out.println("3 and 9 are related? " + (unionByHeight.find(3) == unionByHeight.find(9)));
        System.out.println("1 and 4 are related? " + (unionByHeight.find(1) == unionByHeight.find(4)));
        System.out.println("0 and 4 are related? " + (unionByHeight.find(0) == unionByHeight.find(4)));
        
        unionByHeight.print();
        
        
        
    }
    
}
