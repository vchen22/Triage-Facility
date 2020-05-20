package com.cse.ds.sorting;

/**
 * Author: Vicki Chen
 * CSE12 Login: cs12sp19af
 * Date: 5/22/19
 * File: HeapSortString.java
 * Source of Help: PA7 writeup, Piazza
 *
 * This file contains the class HeapSortGeneric.
 * It sorts out a heap based on the wanted sorting type
 */

/**
 * This class contains a method that will sort the heap on ascending 
 * or descending order
 * */
public class HeapSortString implements Sorting<String> {

    private static final int HALF_ARR = 2;

    /**
     * Initalized a HeapSortGeneric object
     * @param array Given array
     * @param ascending sorting type
     * @return void
     * */
    @Override
        public void sort(String[] array, boolean ascending) {
            // TODO Auto-generated method stub

            StringHeap heap = new StringHeap(array);

            //iterate through to get the heap-ordered elements back to an array
            for (int i = 0; i < array.length; i++)
            {
                array[i] = new String(heap.heappop());
            }

            //reverse order - smallest to biggest based on alphabetical order
            if (ascending == true)
            {
                //iterate through and swap corresponding indices
                for (int i = 0; i < array.length/HALF_ARR; i++)
                {

                    String temp1 = array[i];

                    String temp2 = array[array.length-1-i];

                    array[i] = temp2;

                    array[array.length-1-i] = temp1;

                }   
            }

        }

}
