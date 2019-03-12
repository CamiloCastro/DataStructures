/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

import java.util.Arrays;

/**
 *
 * @author jccas
 */
public class DisjointSets {
    
    private int[] s;
    
    public DisjointSets(int numElements)
    {
        s = new int[numElements];
        for(int i = 0; i < s.length; i++)
            s[i] = -1;
    }
    
    public void union(int root1, int root2)
    {
        if(root1 < 0 || root1 >= s.length)
            throw new IllegalArgumentException("Root1 has a wrong value");
        
        if(root2 < 0 || root2 >= s.length)
            throw new IllegalArgumentException("Root2 has a wrong value");
        
        if(root1 == root2)
            return;
        
        int name1 = find(root1);        
        int name2 = find(root2);
        if(name1 == name2)
            return;
        
        s[name2] = name1;
        
    }
    
    public void unionBySize(int root1, int root2)
    {
        if(root1 < 0 || root1 >= s.length)
            throw new IllegalArgumentException("Root1 has a wrong value");
        
        if(root2 < 0 || root2 >= s.length)
            throw new IllegalArgumentException("Root2 has a wrong value");
        
        if(root1 == root2)
            return;
        
        int name1 = find(root1);        
        int name2 = find(root2);
        if(name1 == name2)
            return;
        
        if(s[name2] < s[name1]) //root 2 is bigger        
        {
            s[name2] += s[name1];
            s[name1] = name2;                    
        }
        else
        {
            s[name1] += s[name2];
            s[name2] = name1;
        }   
    }
    
    public void unionByHeight(int root1, int root2)
    {
        if(root1 < 0 || root1 >= s.length)
            throw new IllegalArgumentException("Root1 has a wrong value");
        
        if(root2 < 0 || root2 >= s.length)
            throw new IllegalArgumentException("Root2 has a wrong value");
        
        if(root1 == root2)
            return;
        
        int name1 = find(root1);        
        int name2 = find(root2);
        if(name1 == name2)
            return;
        
        if(s[name2] < s[name1]) //root 2 is deeper        
        {           
            s[name1] = name2;                    
        }
        else
        {
            if(s[name1] == s[name2])
                s[name1]--;
            s[name2] = name1;
        }   
    }
    
    public int find(int x)
    {
        if(x < 0 || x >= s.length)
            throw new IllegalArgumentException("x has a wrong value");
        
        if(s[x] < 0)
            return x;        
        else
            return find(s[x]);        
    }
    
    public int findWithPathCompression(int x)
    {
        if(x < 0 || x >= s.length)
            throw new IllegalArgumentException("x has a wrong value");
        
        if(s[x] < 0)
            return x;        
        else
            return s[x] = find(s[x]);        
    }
    
    public void print()
    {
        System.out.println(Arrays.toString(s));
    }
    
}
