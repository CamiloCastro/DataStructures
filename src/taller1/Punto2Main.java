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
        System.out.println(Arrays.toString(mergeArray));
        //Start Time
        mergeSort(mergeArray);
        //End Time
        System.out.println(Arrays.toString(mergeArray));
        
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
        sort(array, 0, array.length-1);
    }
    
    private static void sort(int[] array, int l, int r)
    {
        if(l<r)
        {
            int m = (l+r)/2;            
            sort(array, l, m);
            sort(array, m+1, r);            
            merge(array, l, m, r);
        }
    }
    
    private static void merge(int[] array, int l, int m, int r)
    {
        int nl = m - l + 1;
        int nr = r - m;
        
        int leftArray[] = new int[nl];
        int rightArray[] = new int[nr];
        
        for (int i = 0; i < nl; i++) {            
            leftArray[i] = array[l + i];
        }
        
        for (int i = 0; i < nr; i++) {
            rightArray[i] = array[m + 1 + i];
        }
        
        int i = 0, j = 0, k = l;
        
        while(i < nl && j < nr)
        {
            if(leftArray[i] <= rightArray[j])
            {
                array[k] = leftArray[i];
                i++;
            }
            else
            {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        while (i < nl)
        {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < nr)
        {
            array[k] = rightArray[j];
            j++;
            k++;
        }
        
        
        
        
                
    }
    
}
