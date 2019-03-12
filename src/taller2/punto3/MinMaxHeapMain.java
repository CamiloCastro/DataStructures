/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.punto3;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author juan.castro
 */
public class MinMaxHeapMain {
    
    private static Random random = new Random();
    
    public static void main(String[] args)
    {   
        MinMaxHeap<Integer> mmh = new MinMaxHeap<>();
        for(int i = 1;i<=10;i++)
        {
            int length = random.nextInt(40);
            Integer[] l = generateRandomArray(length);
            mmh.buildHeap(l);             
            Arrays.sort(l);
            int deleteMins = 0;
            int deleteMax = length - 1;
            for(int j = 1; j<=10;j++)
            {
                if(mmh.isEmpty())
                    break;
                if(random.nextBoolean())
                {
                    Integer min = mmh.deleteMin();
                    if(!Objects.equals(min, l[deleteMins]))
                    {
                        System.out.println("deleteMin does not work");
                        return;
                    }
                    deleteMins++;
                }
                else
                {
                    Integer max = mmh.deleteMax();
                    if(!Objects.equals(max, l[deleteMax]))
                    {
                        System.out.println("deleteMax does not work");
                        return;
                    }
                    deleteMax--;
                }                
            }
        }
        System.out.println("All works fine");
    }
    
    public static Integer[] generateRandomArray(int n){
        Integer[] list = new Integer[n];
        for (int i = 0; i < n; i++)
        {
            list[i] = random.nextInt(100);
        }
        return list;
    }  
    
    
    
    
}
