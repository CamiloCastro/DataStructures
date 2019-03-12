/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.punto1;

import java.util.Arrays;

/**
 *
 * @author jccas
 */
public class ArrayBinarySearchTree<T extends Comparable> {
    
    private T[] data;
    private int size;
    
    
    public ArrayBinarySearchTree()
    {
        this(10);
    }
    
    public ArrayBinarySearchTree(int initialCapacity)
    {
        this.size = 0;
        data = (T[]) new Comparable[initialCapacity]; 
    }    
    
    private void ensureCapacity(int newCapacity) {
        T[] newArray = Arrays.copyOf(data, newCapacity);        
        data = newArray;
    }
    
    private int findPos(T element)
    {
        int pos = 0;
        while(pos < data.length && data[pos] != null)
        {
            if(data[pos].compareTo(element) > 0)
                pos = 2*pos + 1;
            else if(data[pos].compareTo(element) < 0)
                pos = 2*pos + 2;
            else
                return pos;
        }
        return pos;
    }
    
    public boolean contains(T element)
    {
        int pos = findPos(element);
        return pos < data.length && data[pos] != null;
    }
    
    public T findMin()
    {
        int pos = 0;
        while(pos < data.length && data[pos] != null)
        {
            pos = 2*pos + 1;
        }
        return data[(pos - 1) / 2];
    }
    
    public T findMax()
    {
        int pos = 0;
        while(pos < data.length && data[pos] != null)
        {
            pos = 2*pos + 2;
        }
        return data[(pos - 2) / 2];
    }
    
    public void insert(T element)
    {
        int pos = findPos(element);
        if(pos < data.length && data[pos] != null)
            return;
        
        if(pos >= data.length)
            ensureCapacity(2*pos);
        
        data[pos] = element;
        size++;
        
    }
    public void remove(T element)
    { 
        int pos = findPos(element);
        if(pos >= data.length || data[pos] == null)
            return;
        
        T[] newArray = Arrays.copyOf(data, data.length);        
        
        data = (T[]) new Comparable[newArray.length]; 
        size--;
        createNewTree(0, newArray, pos);
    }
    
    private void createNewTree(int pos, T[] newArray, int deletePos)
    {
        if(pos >= newArray.length || newArray[pos] == null)
            return;
        
        if(pos != deletePos)
            insert(newArray[pos]);
        
        createNewTree(2*pos + 1, newArray, deletePos);
        createNewTree(2*pos + 2, newArray, deletePos);
        
    }
    
}
