/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.punto3;

import java.util.Arrays;

/**
 *
 * @author jccas
 */
public class MinMaxHeap<T extends Comparable> {
    
    private int size;
    protected T[] array;
    
    public MinMaxHeap()
    {
        this(11);
    }
    
    public MinMaxHeap(int initialSize)
    {
        array = (T[]) new Comparable[initialSize];
        size = 0;
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    private void ensureCapacity(int newCapacity) {
        T[] newArray = Arrays.copyOf(array, newCapacity);        
        array = newArray;
    }
    
    public void insert(T item) {
        
        if(size == array.length - 1)
            ensureCapacity(array.length * 2);
        
        if(isEmpty())
        {
            array[1] = item;
            size++;            
            return;
        }
        
        int newPosition = ++size;           
        int level = (int) (Math.log(size)/Math.log(2));      
        boolean minPercolateUp;
        
        if(level % 2 == 0)
        {
            minPercolateUp = true;
            if(array[newPosition/2].compareTo(item) < 0)
            {
                array[newPosition] = array[newPosition / 2];
                newPosition /= 2;
                minPercolateUp = false;
            }
        }
        else
        {
            minPercolateUp = false;
            if(array[newPosition/2].compareTo(item) > 0)
            {
                array[newPosition] = array[newPosition / 2];
                newPosition /= 2;
                minPercolateUp= true;
            } 
        }       
        
        if(minPercolateUp)
        {
            for(array[0] = item;item.compareTo(array[newPosition/4]) < 0; newPosition /= 4)            
                array[newPosition] = array[newPosition/4];            
        }
        else
        {
            for(array[0] = item;item.compareTo(array[newPosition/4]) > 0; newPosition /= 4)            
                array[newPosition] = array[newPosition/4];
            
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
    
    public T deleteMax() 
    {
        if(size == 1)
        {
            size--;
            return array[1];
        }
        
        if(size == 2)
        {
            size--;
            return array[2];
        }
        
        int maxPos = array[2].compareTo(array[3]) > 0 ? 2 : 3;
        T max = array[maxPos];
        array[maxPos] = array[size--];        
        percolateDown(maxPos);
        return max;
    }
    
    public void buildHeap(T[] items)
    {
        size = items.length; 
        array = (T[]) new Comparable[size + 1];
        for(int i = 0;i < items.length;i++)
        {
            array[i+1] = items[i];
        }               
        for(int i=size/2;i >= 1; i--)
            percolateDown(i);
        
    } 
    
    private void percolateDown(int position)
    {
        int level = (int) (Math.log(position)/Math.log(2)); 
        
        if(level % 2 == 0)
        {
            percolateDownMin(position);
        }
        else
        {
            percolateDownMax(position);
        }
    }
    
    private void percolateDownMin(int position)
    {
        T temp = array[position];
        if(2*position <= size)
        {
            int minPos = 2*position;
            
            if(2*(2*position) <= size && array[2*(2*position)].compareTo(array[minPos]) < 0)
                minPos = 2*(2*position);
            if(2*(2*position) + 1 <= size && array[2*(2*position) + 1].compareTo(array[minPos]) < 0)
                minPos = 2*(2*position) + 1;
            if(2*position + 1 <= size && array[2*position + 1].compareTo(array[minPos]) < 0)
                minPos = 2*position + 1;
            if(2*(2*position + 1) <= size && array[2*(2*position + 1)].compareTo(array[minPos]) < 0)
                minPos = 2*(2*position + 1);
            if(2*(2*position + 1) + 1 <= size && array[2*(2*position + 1) + 1].compareTo(array[minPos]) < 0)
                minPos = 2*(2*position + 1) + 1;
            
            if(minPos / 4 == position)
            {
                if(array[minPos].compareTo(array[position]) < 0)
                {
                    array[position] = array[minPos];
                    array[minPos] = temp;                    
                    if(array[minPos].compareTo(array[minPos/2]) > 0)
                    {
                        T parent = array[minPos/2];
                        array[minPos/2] = array[minPos];
                        array[minPos] = parent;
                    }
                    percolateDownMin(minPos);
                }
                    
            }
            else if(array[minPos].compareTo(array[position]) < 0)                
            {
                array[position] = array[minPos];
                array[minPos] = temp;    
            }
        }
    }
    
    private void percolateDownMax(int position)
    {
        T temp = array[position];
        if(2*position <= size)
        {
            int maxPos = 2*position;
            
            if(2*(2*position) <= size && array[2*(2*position)].compareTo(array[maxPos]) > 0)
                maxPos = 2*(2*position);
            if(2*(2*position) + 1 <= size && array[2*(2*position) + 1].compareTo(array[maxPos]) > 0)
                maxPos = 2*(2*position) + 1;
            if(2*position + 1 <= size && array[2*position + 1].compareTo(array[maxPos]) > 0)
                maxPos = 2*position + 1;
            if(2*(2*position + 1) <= size && array[2*(2*position + 1)].compareTo(array[maxPos]) > 0)
                maxPos = 2*(2*position + 1);
            if(2*(2*position + 1) + 1 <= size && array[2*(2*position + 1) + 1].compareTo(array[maxPos]) > 0)
                maxPos = 2*(2*position + 1) + 1;
            
            if(maxPos / 4 == position)
            {
                if(array[maxPos].compareTo(array[position]) > 0)
                {
                    array[position] = array[maxPos];
                    array[maxPos] = temp;                    
                    if(array[maxPos].compareTo(array[maxPos/2]) < 0)
                    {
                        T parent = array[maxPos/2];
                        array[maxPos/2] = array[maxPos];
                        array[maxPos] = parent;
                    }
                    percolateDownMax(maxPos);
                }                    
            }
            else if(array[maxPos].compareTo(array[position]) > 0)                
            {
                array[position] = array[maxPos];
                array[maxPos] = temp;    
            }
        }
    }
    
    public boolean verifyMinMaxHeap()
    {
        for(int i=size;i >= 4;i--)
        {
            int level = (int) (Math.log(i)/Math.log(2)); 
            if(level % 2 == 0)
            {
                if(array[i].compareTo(array[i/2]) > 0)
                {
                    
                    return false;
                }
                if(array[i].compareTo(array[i/4]) < 0)
                {
                    
                    return false;
                }
            }
            else
            {
                if(array[i].compareTo(array[i/2]) < 0)
                {
                    
                    return false;
                }
                if(array[i].compareTo(array[i/4]) > 0)
                {
                    
                    return false;
                }
            }
        }
        return true;
    }
    
}
