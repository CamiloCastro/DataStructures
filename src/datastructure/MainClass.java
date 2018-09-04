/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

import datastructure.objects.MyClock;
import datastructure.list.IntegerArrayList;
import datastructure.list.MyArrayList;
import datastructure.list.MyLinkedList;
import java.util.Iterator;

/**
 *
 * @author jccas
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Integer ArrayList        
        IntegerArrayList integerList = new IntegerArrayList();        
        integerList.add(15);
        integerList.add(9);
        integerList.add(-3);
        integerList.add(5);
        System.out.println("Size: " + integerList.size());        
        integerList.print();
        integerList.sort();
        System.out.println("Sorted Array");
        integerList.print();
        
        Iterator<Integer> it = integerList.iterator();
        Integer sum = 0;
        while(it.hasNext())
        {
            sum += it.next();
        }
        System.out.println("Suma: " + sum);
        
        
        //Generic Array List
        MyArrayList<MyClock> clockList = new MyArrayList<>();        
        clockList.add(new MyClock(5,35,24));
        clockList.add(new MyClock(12,2,32));
        clockList.add(new MyClock(1,12,24));
        clockList.add(new MyClock(5,35,24));
        System.out.println("Original Clock Array List");
        clockList.print();
        clockList.sort();
        System.out.println("Sorted Clock Array List");
        clockList.print();
        
        //Generic Simple LinkedList
        MyLinkedList<MyClock> clockList2 = new MyLinkedList<>();        
        clockList2.add(new MyClock(5,35,24));
        clockList2.add(new MyClock(12,2,32));
        clockList2.add(new MyClock(1,12,24));
        clockList2.add(new MyClock(5,35,24));
        System.out.println("Original Clock Simple Linked List");
        clockList2.print();
        clockList2.sort();
        System.out.println("Sorted Clock Simple Linked List");
        clockList2.print();
        
        
    }
    
}
