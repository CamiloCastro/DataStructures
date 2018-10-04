/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author juan.castro
 */
public class MainClass {
    
    public static void main(String args[])
    {
        
        double total = 0.0;
        
        //Grading first exercise
        
        Punto1 p1 = new Punto1();
        boolean firstA = true;
        for (int i = 0; i < 10; i++) {
            int n = generateRandomInt(5, 20);
            int[] arr = generateRandomArray(n, -n, n);
            int obtainedResult = p1.getMaxElement(arr);
            Arrays.sort(arr);
            firstA = firstA && (arr[arr.length - 1] == obtainedResult); 
            if(!firstA)
                break;
        }
        if(firstA)
            total += 0.5;        
        
        boolean firstB = true;
        for (int i = 0; i < 10; i++) {
            int n = generateRandomInt(0, 15);
            long obtainedResult = p1.getPowersOfTwo(n);
            firstB = firstB && (Math.pow(2,n) == obtainedResult);
            if(!firstB)            
                break;
        }
        
        if(firstB)
            total += 0.5;
        
        
        //Grading second exercise
        boolean second = true;
        Temperature t1= new Temperature("30C");
        Temperature t2= new Temperature("75F");
        Temperature t3= new Temperature("315K");
        second = second && (Math.abs(t1.getValue("C") - 30.0) < 0.0001);
        second = second && (Math.abs(t2.getValue("F") - 75.0) < 0.0001);
        second = second && (Math.abs(t3.getValue("K") - 315.0) < 0.0001);
        if(second)
            total+=0.3;      
        second = true;
        
        Temperature t4= new Temperature("85C");
        Temperature t5 = new Temperature("358.15K");
        second = second && (Math.abs(t1.getValue("F") - 86.0) < 0.0001);
        second = second && (Math.abs(t1.getValue("K") - 303.15) < 0.0001);
        second = second && (Math.abs(t2.getValue("K") - 297.0388) < 0.0001);
        second = second && (Math.abs(t2.getValue("C") - 23.8888) < 0.0001);
        second = second && (Math.abs(t3.getValue("F") - 107.33) < 0.0001);
        second = second && (Math.abs(t3.getValue("C") - 41.85) < 0.0001);
        if(second)
            total+=0.3;
        second = true;
        second = second && (t4.compareTo(t2) == 1);
        second = second && (t1.compareTo(t4) == -1);
        second = second && (t4.compareTo(t5) == 0);        
        Temperature res1 = t1.add(t4);
        Temperature res2 = t3.add(t4);
        second = second && (Math.abs(res1.getValue("K") - 661.3) < 0.0001);
        second = second && (Math.abs(res2.getValue("K") - 673.15) < 0.0001);
        if(second)
            total +=0.4;
        
        //Grading third exercise
        boolean third = true;
        for (int i = 0; i < 10; i++) {            
            int n = generateRandomInt(5, 7);
            int[] arr = generateRandomArray(n, 0, n);
            MyDoubleLinkedList<Integer> linkedList = new MyDoubleLinkedList<>();
            for (int j = 0; j < n - 2; j++) {                
                linkedList.add(arr[j]);
            }
            int n1 = generateRandomInt(0, n-2);
            linkedList.add(n1,arr[n-2]);
            int n2 = generateRandomInt(0, n-1);
            linkedList.add(n2,arr[n-1]);
            
            String result = "";
            for (int j = 0; j < n - 2; j++) {
                result += arr[j];
            }           
            
            result = result.substring(0, n1) + arr[n-2] + result.substring(n1);
            result = result.substring(0, n2) + arr[n-1] + result.substring(n2);
            
            third = third && (linkedList.toString().equals(result));
            if(!third)
                break;
            Arrays.sort(arr);
            linkedList.sort();
            for (int j = 0; j < n; j++) {
                third = third && (linkedList.get(j) == arr[j]);
                if(!third)
                    break;
            }
            if(!third)
                break;
        }
        if (third)
            total += 0.4;
        third = true;
        
        Punto3 p3 = new Punto3();
        MyDoubleLinkedList<Temperature> temperatures = new MyDoubleLinkedList<>();
        temperatures.add(t1);temperatures.add(t2);temperatures.add(t3);temperatures.add(t4);temperatures.add(t5);        
        MyDoubleLinkedList<Temperature> temperatures1 = new MyDoubleLinkedList<>();
        temperatures1.add(new Temperature("28C"));temperatures1.add(new Temperature("3C"));
        temperatures1.add(new Temperature("120C"));temperatures1.add(new Temperature("37.4F"));temperatures1.add(new Temperature("276.15K"));
        Temperature average = p3.average(temperatures);        
        third = third && (Math.abs(average.getValue("C") - 53.1477) < 0.0001);
        average = p3.average(temperatures1);
        third = third && (Math.abs(average.getValue("C") - 31.4) < 0.0001);
        if(third)
            total += 0.3;
        third = true;
        
                
        Temperature median = p3.median(temperatures);
        third = third && (Math.abs(median.getValue("C") - 41.85) < 0.0001);
        median = p3.median(temperatures1);
        third = third && (Math.abs(median.getValue("C") - 3.0) < 0.0001);
        if(third)
            total+=0.3;
        
        
        //Grading fourth exercise
        boolean fourth = true;
        
        for (int i = 0; i < 10; i++) {
            String result = "";
            MyLinkedBiqueue<Integer> biqueue = new MyLinkedBiqueue<>();
            int n = generateRandomInt(5, 20);
            for (int j = 0; j < n; j++) {
                int number = generateRandomInt(0,20);
                boolean inBack = generateRandomInt(0,2) == 0;
                biqueue.enqueue(number, inBack);
                if(inBack)
                    result += number;
                else
                    result = number + result;
            }
            fourth = fourth && (result.equals(biqueue.toString()));       
            if(!fourth)
                break;
        }
        
        if(fourth)
            total += 0.5;
        fourth = true;
        
        for (int i = 0; i < 10; i++) {            
            MyLinkedBiqueue<Integer> biqueue = new MyLinkedBiqueue<>();
            int n = generateRandomInt(5, 20);
            for (int j = 0; j < n; j++) {
                int number = generateRandomInt(0,20);
                boolean inBack = generateRandomInt(0,2) == 0;
                biqueue.enqueue(number, inBack);                
            }
            
            int n1 = generateRandomInt(0, n - 3);
            
            for (int j = 0; j < n1; j++) { 
                try
                {
                    boolean fromFront = generateRandomInt(0,2) == 0;
                    Integer value;
                    if (fromFront)
                        value = biqueue.getFront();
                    else
                        value = biqueue.getBack();
                    Integer dequeuedValue = biqueue.dequeue(fromFront);                
                    fourth = fourth && (dequeuedValue == value);
                }catch(Exception e)
                {                    
                    fourth = false;
                }
                if(!fourth)
                    break;
            }
            if(!fourth)
                break;
        }
        
        if(fourth)
            total += 0.5;
        
        
        //Grading fifth exercise
        
        boolean fifth = true;
        MyBinaryNode<String> c1 = new MyBinaryNode<>("7");
        MyBinaryNode<String> c2 = new MyBinaryNode<>("3");
        MyBinaryNode<String> c3 = new MyBinaryNode<>("5");
        MyBinaryNode<String> c4 = new MyBinaryNode<>("23");
        MyBinaryNode<String> c5 = new MyBinaryNode<>("8");
        MyBinaryNode<String> c6 = new MyBinaryNode<>("3");
        MyBinaryNode<String> c7 = new MyBinaryNode<>("2");
        
        MyBinaryNode<String> o1 = new MyBinaryNode<>("+", c1, c2);
        MyBinaryNode<String> o2 = new MyBinaryNode<>("*", o1, c3);        
        MyBinaryNode<String> o6 = new MyBinaryNode<>("*", c6, c7);
        MyBinaryNode<String> o5 = new MyBinaryNode<>("-", c5, o6);
        MyBinaryNode<String> o4 = new MyBinaryNode<>("+", c4, o5);
        MyBinaryNode<String> o3 = new MyBinaryNode<>("-", o2, o4);        
        
        MyExpressionTree met = new MyExpressionTree(o3);
        
        MyBinaryNode<String> k1 = new MyBinaryNode<>("2");
        MyBinaryNode<String> k2 = new MyBinaryNode<>("23");
        MyBinaryNode<String> k3 = new MyBinaryNode<>("7");
        MyBinaryNode<String> k4 = new MyBinaryNode<>("5");
        MyBinaryNode<String> k5 = new MyBinaryNode<>("3");
        MyBinaryNode<String> k6 = new MyBinaryNode<>("3");
        MyBinaryNode<String> k7 = new MyBinaryNode<>("8");
        
        MyBinaryNode<String> op1 = new MyBinaryNode<>("-", k2, k3);
        MyBinaryNode<String> op2 = new MyBinaryNode<>("*", k1, op1);        
        MyBinaryNode<String> op3 = new MyBinaryNode<>("+", op2, k4);
        MyBinaryNode<String> op4 = new MyBinaryNode<>("-", k6, k7);
        MyBinaryNode<String> op5 = new MyBinaryNode<>("*", k5, op4);
        MyBinaryNode<String> op6 = new MyBinaryNode<>("-", op3, op5);        
        
        MyExpressionTree met1 = new MyExpressionTree(op6);
        
        fifth = fifth && (met.inOrder().trim().equals("7 + 3 * 5 - 23 + 8 - 3 * 2"));
        fifth = fifth && (met1.inOrder().trim().equals("2 * 23 - 7 + 5 + 3 * 3 - 8"));
        
        if(fifth)
            total += 0.25;
        fifth = true;
        
        fifth = fifth && (met.preOrder().trim().equals("- * + 7 3 5 + 23 - 8 * 3 2"));
        fifth = fifth && (met1.preOrder().trim().equals("+ + * 2 - 23 7 5 * 3 - 3 8"));
        
        if(fifth)
            total += 0.25;
        fifth = true;
        
        fifth = fifth && (met.posOrder().trim().equals("7 3 + 5 * 23 8 3 2 * - + -"));
        fifth = fifth && (met1.posOrder().trim().equals("2 23 7 - * 5 + 3 3 8 - * +"));
        
        if(fifth)
            total += 0.25;
        fifth = true;
        
        fifth = fifth && (met.solve() == 25);
        fifth = fifth && (met1.solve() == 22);
        
        if(fifth)
            total += 0.25;
        
        int factor = (int) Math.pow(10, 3);
        total = total * factor;
        double tmp = (double)Math.round(total);
        total = tmp / factor;
        
        System.out.println("Grade: " + (total) + " / 5.0");
        
        
        
        
        
        
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
        return rnd.nextInt(max - min) + min;
    }
    
}
