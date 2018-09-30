/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import datastructure.stack.MyLinkedStack;
import java.io.BufferedReader;
import java.io.FileReader;

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
        
        String filePath = "file.txt";
        int numberLine = balancedFile(filePath);
        System.out.println("Line with errors: " + numberLine);
        
    }
    
    private static int resolvePostfixExpression(String s)
    {
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        String[] partsOfPostfixExpression = s.split(" ");
        for (int i = 0; i < partsOfPostfixExpression.length; i++) {
            String part = partsOfPostfixExpression[i];
            switch(part)
            {
                case "+":case "-":case "*":case "/":                    
                    Integer op2 = stack.pop();
                    Integer op1 = stack.pop();
                    Integer res;
                    switch (part) {
                        case "+":
                            res = op1 + op2;
                            break;
                        case "-":
                            res = op1 - op2;
                            break;
                        case "*":     
                            res = op1 * op2;
                            break;
                        default:
                            res = op1 / op2;
                            break;
                    }
                    
                    stack.push(res);                
                    break;
                default:
                    stack.push(Integer.parseInt(part));
                    break;                    
            }
            
        }
        return stack.pop();
    }
    
    private static int balancedFile(String path)
    {
        try {
            String line;            
            MyLinkedStack<Character> stack = new MyLinkedStack<>();
            FileReader fileReader = new FileReader(path);            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int contLine = 1;
            while((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    Character charAt = line.charAt(i);
                    switch(charAt)
                    {
                        case '[':case '(':case '{':                            
                            stack.push(charAt);
                            break;
                        case ']':case ')':case '}':
                            if(stack.isEmpty())
                                return contLine;
                            Character a = stack.pop();
                            if (a.equals('(') && !charAt.equals(')'))
                                return contLine;
                            if (a.equals('[') && !charAt.equals(']'))
                                return contLine;
                            if (a.equals('{') && !charAt.equals('}'))
                                return contLine;
                            break;
                    }
                }                
                contLine ++;
            }
            if(!stack.isEmpty())
                return contLine;
            
            bufferedReader.close();         
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return -1;        
    }
    
}
