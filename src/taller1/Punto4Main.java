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
public class Punto4Main {
    
    public static void main(String args[])
    {
        Person[] persons = new Person[10];
        //Create ten persons and add to the persons array, for instance Person p1 = new Person(); persons[0] = p1;
        //Generate a random order to enqueue the persons
        int[] permutationArray = {0,1,2,3,4,5,6,7,8,9};
        int[] randomPermutation = generateRandomPermutation(permutationArray);
        for (int i = 0; i < randomPermutation.length; i++) {
            Person p = persons[randomPermutation[i]];
            System.out.println(i + " " + p);
            //Add person p into queue            
        }
        
        //Dequeue and assign random triage value for each person in queue
        //After assign triage value enqueue the person in priority queue
        
        //Finally, when all persons are enqueued in the priority queue,
        //start with the dequeue and print the order of output
        
    }
    
    private static int generateRandomInt(int min, int max)
    {
        //Your code here
        return 0;
    }
    
    private static int[] generateRandomPermutation(int[] originalArray)
    {
        //Your code here
        return new int[0];
    }
    
}
