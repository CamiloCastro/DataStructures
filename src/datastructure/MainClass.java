/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author jccas
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        NumArrayList list = new NumArrayList();
        
        list.add(15);
        list.add(9);
        list.add(-3);
        list.add(5);
        System.out.println("Size: " + list.size());
        list.remove(2);
        System.out.println("Size: " + list.size());
        list.print();
        
    }
    
}
