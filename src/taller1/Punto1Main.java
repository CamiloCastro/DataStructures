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
        double[][] sum = null;
        double[][] mult = null;
        operationWithMatrix(a, b, sum, mult);
        System.out.println("Suma: " + Arrays.toString(sum));
        System.out.println("Multiplicación: " + Arrays.toString(mult));
        System.out.println("");
        System.out.println("********EJERCICIO 1c********");
        String reverse = reverseString("Estructuras de Datos");
        System.out.println("Reverse String: " + reverse);
        System.out.println("");
        System.out.println("********EJERCICIO 1d********");
        int nBinary = 87;
        int numberOnes = countOnesInBinary(nBinary);
        System.out.println("Number of Ones: " + numberOnes);
    }
    
    private static void printLessThanNPrime(int n)
    {
        //Your code here
    }
    
    private static void operationWithMatrix(double[][] a, double[][] b, double[][] sum, double[][] mult)
    {
        //Your code here       
    }
    
    private static String reverseString(String s)
    {
        //Your code here
        return "";
    }
    
    private static int countOnesInBinary(int n)
    {
        return 0;
    }
    
}
