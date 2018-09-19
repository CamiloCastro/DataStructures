/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import java.util.Arrays;
import java.util.Random;

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
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = generateRandomInt(min, max);            
        }
        return arr;
    }
    
    private static int generateRandomInt(int min, int max)
    {
        Random rnd = new Random();
        return rnd.nextInt(max - min + 1) + min;
    }
    
    private static int linealSearch(int[] array, int N)
    {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == N)            
                return i;
        }
        return -1;
    }
    
    private static void bubbleSort(int[] array)
    {
        int n = array.length;        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {                
                if(array[j] < array[i])
                {
                    int aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;                
                }
            }
        }
    }
    
    private static void mergeSort(int [] array)
    {
        //Your code here
    }
    
}
