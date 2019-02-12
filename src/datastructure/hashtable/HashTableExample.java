/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.hashtable;

import datastructure.heap.Person;

/**
 *
 * @author jccas
 */
public class HashTableExample {
    
    public static void main(String[] args)
    {
        
        Person p1 = new Person(5, "Persona1");
        Person p2 = new Person(7, "Persona2");
        Person p3 = new Person(2, "Persona3");
        Person p4 = new Person(9, "Persona4");
        Person p5 = new Person(14, "Persona5");
        Person p6 = new Person(1, "Persona6");
        Person p7 = new Person(6, "Persona7");
        Person p8 = new Person(4, "Persona8");
        Person p9 = new Person(8, "Persona9");
        
        ChainingHashTable<Person> chainingHashTable = new ChainingHashTable<>();
        chainingHashTable.insert(p1);
        chainingHashTable.insert(p3);
        chainingHashTable.insert(p2);
        
        System.out.println("Contains p1? " + chainingHashTable.contains(p1));
        System.out.println("Contains p9? " + chainingHashTable.contains(p9));
        System.out.println("Contains p8? " + chainingHashTable.contains(p8));
        System.out.println("Contains p3? " + chainingHashTable.contains(p3));
        
        System.out.println("\n*************QUADRATIC**************\n");
        
        QuadraticProbingHashTable<Person> quadraticProbingHashTable = new QuadraticProbingHashTable<>();
        quadraticProbingHashTable.insert(p1);
        quadraticProbingHashTable.insert(p3);
        quadraticProbingHashTable.insert(p2);
        
        System.out.println("Contains p1? " + quadraticProbingHashTable.contains(p1));
        System.out.println("Contains p9? " + quadraticProbingHashTable.contains(p9));
        System.out.println("Contains p8? " + quadraticProbingHashTable.contains(p8));
        System.out.println("Contains p3? " + quadraticProbingHashTable.contains(p3));
        
    }
    
}
