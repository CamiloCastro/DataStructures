/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.punto2;

import java.util.Arrays;

/**
 *
 * @author jccas
 */
public class DHeap<T extends Comparable> {
    
    private int size;
    protected T[] array;
    private int d;
    
    public DHeap(int d) {
        this.d = d;
        this.size = 0;
        array = (T[]) new Comparable[10];
    }
    
    public DHeap(int initialSize, int d) {
        this.d = d;
        this.size = 0;
        array = (T[]) new Comparable[initialSize];
    }
    
    private void ensureCapacity(int newCapacity) {
        T[] newArray = Arrays.copyOf(array, newCapacity);        
        array = newArray;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public void insert(T item) {
        if(size == array.length - 1)
            ensureCapacity(array.length * 2);
        
        int newPosition = ++size;        
        for(array[0] = item;item.compareTo(array[(newPosition + d - 2)/d]) < 0; newPosition = (newPosition + d - 2)/d )
        {
            array[newPosition] = array[(newPosition + d - 2)/d];
        }
        array[newPosition] = item;
    }
    
    public T deleteMin() 
    {
        T min = array[1];
        array[1] = array[size--];        
        percolateDown(1);
        return min;
    }
    
    private void percolateDown(int position) 
    {
        int child;
        T tmp = array[position];
        for( ;(d*position) - (d-2) <= size; position = child)
        {
            child = (d*position) - (d-2);
            T min = array[child];
            int cont = 0;
            for(int i = child + 1;i <= size && cont < d - 1;i++)
            {
                if(array[i].compareTo(min) < 0)
                {
                    min = array[i];
                    child = i;
                }
                cont++;
            }
            
            if(array[child].compareTo(tmp) < 0)
                array[position] = array[child];
            else
                break;
        }
        array[position] = tmp;
    }
    
    public void buildHeap(T[] items)
    {
        size = items.length; 
        array = (T[]) new Comparable[size + 1];
        for(int i = 0;i < items.length;i++)
        {
            array[i+1] = items[i];
        }                      
        
        for(int i = (size + d - 2)/d ; i >= 1 ; i-- )
        {
            percolateDown(i);
        }
    }
    
}
