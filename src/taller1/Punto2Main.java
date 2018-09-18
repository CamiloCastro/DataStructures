/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

/**
 *
 * @author jccas
 */
public class Punto2Main {
    
    public static void main(String args[])
    {
        int n = 10;
        int[] searchArray = generateRandomArray(n, -n, n);
        int N = generateRandomInt(-n, n);
        //Start Time
        int index = linealSearch(searchArray, N);
        //End Time
        
        int[] bubbleArray = generateRandomArray(n, -n, n);
        //Start Time
        bubbleSort(bubbleArray);
        //End Time
        
        int[] mergeArray = generateRandomArray(n, -n, n);
        //Start Time
        mergeSort(mergeArray);
        //End Time
        
    }
    
    private static int[] generateRandomArray(int n, int min, int max)
    {
        //Your code here
        return new int[0];
    }
    
    private static int generateRandomInt(int min, int max)
    {
        //Your code here
        return 0;
    }
    
    private static int linealSearch(int[] array, int N)
    {
        //Your code here
        return 0;
    }
    
    private static void bubbleSort(int[] array)
    {
        //Your code here
    }
    
    private static void mergeSort(int [] array)
    {
        //Your code here
    }
    
}
