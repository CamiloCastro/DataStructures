/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import datastructure.list.MyArrayList;
import datastructure.queue.MyLinkedPriorityQueue;
import datastructure.queue.MyLinkedQueue;
import datastructure.queue.PriorityElement;
import java.util.Random;

/**
 *
 * @author jccas
 */
public class Punto4Main {
    
    public static void main(String args[])
    {
        Person[] persons = new Person[10];
        for (int i = 0; i < 10; i++) {
            persons[i] = new Person("P" + i);            
        }
        
        MyLinkedQueue<Person> queue = new MyLinkedQueue<>();
        System.out.println("**********FIRST ORDER");
        int[] permutationArray = {0,1,2,3,4,5,6,7,8,9};
        int[] randomPermutation = generateRandomPermutation(permutationArray);
        for (int i = 0; i < randomPermutation.length; i++) {
            Person p = persons[randomPermutation[i]];
            System.out.println(i + " " + p);
            queue.enqueue(p);
        }
        
        MyLinkedPriorityQueue<Person> priorityQueue = new MyLinkedPriorityQueue<>();
        System.out.println();
        System.out.println("**********PEOPLE WITH TRIAGES");
        while(!queue.isEmpty())
        {
            Person p = queue.dequeue();            
            p.setTriage(generateRandomInt(1, 10));
            System.out.println(p.toString());
            priorityQueue.enqueue(new PriorityElement<>(p, p.getTriage()));                    
        }
        
        System.out.println();
        System.out.println("**********PEOPLE AFTER TRIAGES");
        while(!priorityQueue.isEmpty())
        {
            Person p = priorityQueue.dequeue();            
            System.out.println(p.toString());
        }
        
    }
    
    private static int generateRandomInt(int min, int max)
    {
        Random rnd = new Random();
        return rnd.nextInt(max - min + 1) + min;
    }
    
    private static int[] generateRandomPermutation(int[] originalArray)
    {
        int nArray = originalArray.length;
        MyArrayList<Integer> permutationList = new MyArrayList<>(nArray);
        for (int i = 0; i < nArray; i++) {
            permutationList.add(originalArray[i]);
        }
        int[] permutationArray = new int[nArray];
        int contPermutation = nArray - 1;
        for (int i = 0; i < nArray; i++) {            
            int randomIndex = generateRandomInt(0, contPermutation);
            permutationArray[i] = permutationList.get(randomIndex);
            permutationList.remove(randomIndex);
            contPermutation--;
        }
        return permutationArray;
    }
    
}
