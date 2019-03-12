/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.punto4;

/**
 *
 * @author jccas
 */
public class LinearHashTable<K,T> {
    
    private static class HashEntry<K,T>
    {
        public T element;
        public K key;
        public boolean isActive;
        
        public HashEntry(T e, K k)
        {
            this(e, true, k);
        }
        
        public HashEntry(T e, boolean i, K k)
        {
            element = e;
            isActive = i;
            key = k;
        }        
    }
    
    private HashEntry<K,T> [] array;
    private int currentSize;
    
    public LinearHashTable()
    {
        this(11);
    }
    
    public LinearHashTable(int size)
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
    
    private void allocateArray(int arraySize)
    {
        array = new HashEntry[nextPrime(arraySize)];
    }
    
    private boolean isActive(int currentPos)
    {
        return array[currentPos] != null && array[currentPos].isActive;
    }
    
    private int findPos(K key)
    {        
        int currentPos = myHash(key);
        
        while(array[currentPos] != null && !array[currentPos].key.equals(key))
        {
            currentPos++;            
            if(currentPos >= array.length)
                currentPos -= array.length;
        }
        return currentPos;        
    }
    
    private void rehash()
    {
        HashEntry<K,T> [] oldArray = array;
        allocateArray(nextPrime(2*oldArray.length));
        currentSize = 0;
        
        for(int i=0;i<oldArray.length;i++)
            if(oldArray[i] != null && oldArray[i].isActive)
                insert(oldArray[i].key, oldArray[i].element);
        
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
    
    private int myHash(K key)
    {
        int hashValue = key.hashCode();        
        hashValue %= array.length;
        if(hashValue < 0)
            hashValue += array.length;
        
        return hashValue;
    }
    
    public boolean contains(K key)
    {
        int currentPos = findPos(key);
        return isActive(currentPos);
    }
    
    public void insert(K key, T value)
    {
        int currentPos = findPos(key);
        if(isActive(currentPos))
            return;
        
        array[currentPos] = new HashEntry<>(value, true, key);
        currentSize++;
        if(currentSize > array.length/2)
            rehash();
    }
    
    public void remove(K key)
    {
        int currentPos = findPos(key);
        if(isActive(currentPos))
            array[currentPos].isActive = false;
        currentSize--;
    }
    
    public T getElement(K key)
    {
        int currentPos = findPos(key);
        if(isActive(currentPos))
            return array[currentPos].element;
        
        return null;
    }
    
}
