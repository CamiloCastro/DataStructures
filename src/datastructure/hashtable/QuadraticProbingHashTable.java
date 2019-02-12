/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.hashtable;

/**
 *
 * @author jccas
 */
public class QuadraticProbingHashTable<T> {
    
    private static class HashEntry<T>
    {
        public T element;
        public boolean isActive;
        
        public HashEntry(T e)
        {
            this(e, true);
        }
        
        public HashEntry(T e, boolean i)
        {
            element = e;
            isActive = i;
        }        
    }
    
    private HashEntry<T> [] array;
    private int currentSize;
    
    
    public QuadraticProbingHashTable()
    {
        this(11);
    }
    
    public QuadraticProbingHashTable(int size)
    {
        allocateArray(size);
        makeEmpty();
    }
    
    public void makeEmpty()
    {
        currentSize = 0;
        for(int i = 0; i < array.length; i++)
            array[i] = null;
        
    }
    
    public boolean contains(T x)
    {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }
    
    public void insert(T x)
    {
        int currentPos = findPos(x);
        if(isActive(currentPos))
            return;
        
        array[currentPos] = new HashEntry<>(x, true);
        currentSize++;
        if(currentSize > array.length/2)
            rehash();
    }
    
    public void remove(T x)
    {
        int currentPos = findPos(x);
        if(isActive(currentPos))
            array[currentPos].isActive = false;
    }
    
    private void allocateArray(int arraySize)
    {
        array = new HashEntry[nextPrime(arraySize)];
    }
    
    private boolean isActive(int currentPos)
    {
        return array[currentPos] != null && array[currentPos].isActive;
    }
    
    private int findPos(T x)
    {
        int offset = 1;
        int currentPos = myHash(x);
        
        while(array[currentPos] != null && !array[currentPos].element.equals(x))
        {
            currentPos += offset;
            offset += 2;
            if(currentPos >= array.length)
                currentPos -= array.length;
        }
        return currentPos;        
    }
    
    private void rehash()
    {
        HashEntry<T> [] oldArray = array;
        allocateArray(nextPrime(2*oldArray.length));
        currentSize = 0;
        
        for(int i=0;i<oldArray.length;i++)
            if(oldArray[i] != null && oldArray[i].isActive)
                insert(oldArray[i].element);
        
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
        hashValue %= array.length;
        if(hashValue < 0)
            hashValue += array.length;
        
        return hashValue;
    }
}
