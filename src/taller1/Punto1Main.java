/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import java.util.Arrays;

/**
 *
 * @author jccas
 */
public class Punto1Main {
    
    public static void main(String args[])
    {
        System.out.println("********EJERCICIO 1a********");
        int nPrimes = 100;
        printLessThanNPrime(nPrimes);
        System.out.println("");
        System.out.println("********EJERCICIO 1b********");
        double[][]a = {{2.5, -3.0, 5.0},{-2.3, 5.0, 3.1},{9.0, 5.0, -7.5}};
        double[][]b = {{6.5, 2.0, -4.5},{-6.0, 5.0, 0.6},{2.8, -4.0, 7.5}};
        double[][] sum = new double[3][3];
        double[][] mult = new double[3][3];
        operationWithMatrix(a, b, sum, mult);
        System.out.println("Suma: " + Arrays.deepToString(sum));
        System.out.println("Multiplicación: " + Arrays.deepToString(mult));
        System.out.println("");
        System.out.println("********EJERCICIO 1c********");
        String reverse = reverseString("Estructuras de Datos");
        System.out.println("Reverse String: " + reverse);
        System.out.println("");
        System.out.println("********EJERCICIO 1d********");
        int nBinary = 16;
        int numberOnes = countOnesInBinary(nBinary);
        System.out.println("Number of Ones: " + numberOnes);
    }
    
    private static void printLessThanNPrime(int n)
    {
        for (int i = 2; i < n; i++) {
            
            boolean isPrime = true;
            
            double limit = Math.floor(Math.sqrt(i));
            int cont = 2;
            while(cont <= limit)
            {
                if (i%cont == 0)
                {
                    isPrime = false;
                    break;
                }
                cont++;
            }            
            
            if(isPrime)
                System.out.println(i);           
            
        }
        
        
    }
    
    private static void operationWithMatrix(double[][] a, double[][] b, double[][] sum, double[][] mult)
    {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                sum[i][j] = a[i][j] + b[i][j];                
            }
        }
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                double acumm = 0.0;
                for (int k = 0; k < b.length; k++) {
                    acumm += (a[i][k] * b[k][j]);
                }
                mult[i][j] = acumm;
            }
        }
       
    }
    
    private static String reverseString(String s)
    {
        if(s.length() == 1)
            return s;
        
        return s.charAt(s.length() - 1) + reverseString(s.substring(0,s.length() - 1 ));
    }
    
    private static int countOnesInBinary(int n)
    {
        if (n == 0 || n == 1)
            return n;
        
        return countOnesInBinary(n/2) + n % 2;
        
        
    }
    
}
