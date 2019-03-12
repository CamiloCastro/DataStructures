/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.punto2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author juan.castro
 */
public class DHeapMain {

    private static Random random = new Random();

    public static void main(String[] args) {

        for (int k = 2; k <= 6; k++) {

            DHeap<Integer> heap = new DHeap<>(k);
            

            for (int i = 1; i <= 10; i++) {
                int length = random.nextInt(40);
                Integer[] l = generateRandomArray(length);                
                heap.buildHeap(l);
                Arrays.sort(l);
                int deleteMins = 0;
                for (int j = 1; j <= 10; j++) {
                    if (heap.isEmpty()) {
                        break;
                    }
                    Integer min = heap.deleteMin();
                    if (!Objects.equals(min, l[deleteMins])) {
                        System.out.println("deleteMin does not work");
                        return;
                    }
                    deleteMins++;
                }
            }

        }

        System.out.println("All works fine");

    }

    public static Integer[] generateRandomArray(int n) {
        Integer[] list = new Integer[n];
        for (int i = 0; i < n; i++) {
            list[i] = random.nextInt(100);
        }
        return list;
    }

}
