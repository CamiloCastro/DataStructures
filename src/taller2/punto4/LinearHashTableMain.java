/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.punto4;

/**
 *
 * @author juan.castro
 */
public class LinearHashTableMain {
    
    public static void main(String[] args)
    {
        
        LinearHashTable<String, Integer> lht = new LinearHashTable<>();
        
        lht.insert("ONE", 1);
        lht.insert("TWO", 2);
        lht.insert("THREE", 3);
        lht.insert("FOUR", 4);
        lht.insert("FIVE", 5);
        lht.insert("SIX", 6);
        lht.insert("SEVEN", 7);
        lht.insert("EIGHT", 8);
        lht.insert("NINE", 9);
        lht.insert("TEN", 10);
        
        
        System.out.println("Contains eleven? " + lht.contains("ELEVEN"));
        System.out.println("Contains four? " + lht.contains("FOUR"));
        System.out.println("Contains one? " + lht.contains("ONE"));
        
        lht.remove("ONE");
        
        System.out.println("After delete one, contains one? " + lht.contains("ONE"));
        
//        System.out.println("Get two " + lht.getElement("NINE"));
        
    }
    
}
