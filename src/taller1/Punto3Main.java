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
public class Punto3Main {
    
    public static void main(String args[])
    {        
        String postfixExpression = "5 10 + 2 * 6 12 * +";
        int resolve = resolvePostfixExpression(postfixExpression);
        System.out.println("Resolver Postfix: " + resolve);
        
        String filePath = "C:/anywhere/somefolder/file.txt";
        int numberLine = balancedFile(filePath);
        System.out.println("Line with errors: " + numberLine);
        
    }
    
    private static int resolvePostfixExpression(String s)
    {
        //Your code here
        return 0;
    }
    
    private static int balancedFile(String path)
    {
        //Your code here
        return -1;        
    }
    
}
