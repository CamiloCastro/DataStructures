/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author juan.castro
 */
public class Punto1 {
    
    public int getMaxElement(int[] array)
    {
        return getMaxElement(array, array.length - 1);
    }
    
    public long getPowersOfTwo(int n)
    {
        if (n==0)
            return 1;
        
        return 2 * getPowersOfTwo(n-1);
    }
    
    private int getMaxElement(int[] array, int right)
    {
        if(right == 0)
            return array[0];
        
        int maxElement= getMaxElement(array, right - 1);
        if(maxElement > array[right])
            return maxElement;
        else
            return array[right];
        
    }
    
}
