/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.punto1;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author juan.castro
 */
public class ArrayBinarySearchTreeMain {

    private static Random random = new Random();

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            ArrayBinarySearchTree<Integer> myBST = new ArrayBinarySearchTree<>();
            
            int length = random.nextInt(16) + 4;
            Integer[] l = generateRandomArray(length);
            Arrays.sort(l);
            
            for(int j=0;j<length;j++)
            {
                myBST.insert(l[j]);
            }
            
            if(!Objects.equals(myBST.findMin(), l[0]))
            {
                System.out.println("Error in findMin");
                return;
            }
            
            if(!Objects.equals(myBST.findMax(), l[l.length - 1]))
            {
                System.out.println("Error in findMax");
                return;
            }              


            myBST.remove(l[0]);
            if(!Objects.equals(myBST.findMin(), l[1]))
            {
                System.out.println("Error in findMin after a remove");
                return;
            }

            myBST.remove(l[l.length-1]);            
            if(!Objects.equals(myBST.findMax(), l[l.length - 2]))
            {
                System.out.println("Error in findMax after a remove");
                return;
            }  

            boolean contains = true;
            contains = contains && !myBST.contains(l[0]);
            contains = contains && !myBST.contains(l[l.length - 1]);
            contains = contains && myBST.contains(l[l.length - 2]);
            contains = contains && myBST.contains(l[1]);
            
            if(!contains)
            {
                System.out.println("Error in contains");
                return;
            }
        }
        
        System.out.println("All works fine");

    }

    public static Integer[] generateRandomArray(int n) {
        Integer[] list = new Integer[n];
        int i = 0;
        while(i < n)
        {
            int num = random.nextInt(100);
            if(Arrays.toString(list).contains(", " + num + ",") || Arrays.toString(list).contains("[" + num + ",") || Arrays.toString(list).contains(", " + num + "]"))
            {
                
            }else
            {
                list[i] = num; 
                i++;
            }
            
        }
        return list;
    }

}
