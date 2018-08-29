package datastructure;

public class NumArrayList {

    private int size;
    private Integer[] elementData;

    public NumArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Integer[initialCapacity];
        } else
        {
            this.elementData = new Integer[0];
        }
        this.size = 0;
    }

    public NumArrayList() {
        this.elementData = new Integer[0];
        this.size = 0;
    }

    private void ensureCapacity(int minCapacity)
    {
        if (elementData.length < minCapacity)
        {
            int newArraySize;
            if (elementData.length == 0)
                newArraySize = 1;
            else
                newArraySize = elementData.length * 2;
            
            Integer[] newArray = new Integer[newArraySize];
            for (int i = 0; i < elementData.length; i++) {
                newArray[i] = elementData[i];                
            }
            elementData = newArray;            
        }
    }

    public void add(Integer val)
    {
        ensureCapacity(size + 1);
        elementData[size++] = val;
    }
    
    public void add(int index, Integer val)
    {
        if(index >= 0 && index <= size)
        {
            ensureCapacity(size + 1);
            for (int i = index; i < elementData.length - 1; i++) {
                elementData[i + 1] = elementData[i];                
            }
            elementData[index] = val;
            size++;
        }
    }
    
    public Integer get(int index)
    {
        if (index > 0 && index < size)
            return elementData[index];
        else
            return null;
    }
    
    public void set(int index, Integer value)
    {
        if (index > 0 && index < size)
        {
            elementData[index] = value;
        }
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public void remove(int index)
    {
        if (index > 0 && index < size)
        {
            for (int i = index; i < elementData.length - 1; i++) {
                elementData[i] = elementData[i + 1];                
            }
            elementData[size - 1] = null;
            size--;
        }
    }
    
    public void print()
    {
        for (int i = 0; i < size; i++) {
            System.out.print(elementData[i] + " ");            
        }
        System.out.println("");              
    }
    
    public void clear()
    {
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }
    
    




}
