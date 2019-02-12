/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import datastructure.list.MyDoubleLinkedList;

/**
 *
 * @author jccas
 */
public class ChainingHashTable<T extends Comparable> {
    
    private MyDoubleLinkedList<T> [] lists;
    private int size;

    public ChainingHashTable() {
        this(101);
    }

    public ChainingHashTable(int n) {
        this.size = 0;
        n = nextPrime(n);
        this.lists = new MyDoubleLinkedList[n];
    }
    
    private boolean isPrime(int x)
    {
        for(int i=2;i<Math.sqrt(x);i++)
        {
            if(x%i == 0)
                return false;
        }
        return true;
    }
    
    private int nextPrime(int x)
    {
        while(!isPrime(x))        
            x++;
        
        return x;
    }
    
    private int myHash(T x)
    {
        int hashValue = x.hashCode();        
        hashValue %= lists.length;
        if(hashValue < 0)
            hashValue += lists.length;
        
        return hashValue;
    }
    
    public void makeEmpty()
    {
        size = 0;
        for (int i=0; i<lists.length; i++)
            lists[i].clear();
    }
    
    public void insert(T x)
    {
        MyDoubleLinkedList<T> aList = lists[myHash(x)];
        if(!aList.contains(x))
        {
            aList.add(x);
            size++;
            
//            if(size > lists.length)
//                rehash();
        }
    }
    
    public void remove(T x)
    {
        MyDoubleLinkedList<T> aList = lists[myHash(x)];
        if(aList.contains(x))
        {
            aList.remove(x);
            size--;
        }
    }
    
    public boolean contains(T x)
    {
        MyDoubleLinkedList<T> aList = lists[myHash(x)];
        return aList.contains(x);
        
    }
    
    
    
}
