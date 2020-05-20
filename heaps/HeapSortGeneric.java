package com.cse.ds.heaps;

import com.cse.ds.heaps.Heap;
import com.cse.ds.heaps.Tuple;

/**
 * Author: Vicki Chen
 * CSE12 Login: cs12sp19af
 * Date: 5/22/19
 * File: HeapSortGeneric.java
 * Source of Help: Piazza, PA7 write up
 * @param <E> Type of heap
 *
 * This file contains the class HeapSortGeneric.
 * It sorts out a heap based on the wanted sorting type.
 */

/**
 * This class contains a method that will sort the heap on ascending
 * or descending order
 * @param E array type
 * */
public class HeapSortGeneric<E> {

    private E[] data;
    private int[] priority;

    private static final int HALF_ARR = 2;

    /**
     * Initializes a HeapSortGeneric object
     * @param data Given data to sort
     * @param priority Priority of element
     * */
    public HeapSortGeneric(E[] data, int[] priority) {
        //TODO: Fill in implementation

        this.data = data;
        this.priority = priority;
    }	
    /**
     * This method sorts the value and returns a new array
     * @param ascending sorting type
     * @return sortedArr sorted array
     */
    public E[] sort(boolean ascending) {
        //TODO: Fill in implementation

        Tuple[] arr = new Tuple[data.length];

        //iterate through to create an array of tuple type and its properties
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = new Tuple(priority[i], data[i]);
        }

        //create a heap with the contents from array and organize using heap
        //rules
        Heap heap = new Heap(arr);

        E[] sortedArr = (E[]) new Object[data.length];

        //iterate through to get the heap-ordered elements back to an array
        for (int i = 0; i < data.length; i++)
        {
            Tuple popped = heap.heappop();
            sortedArr[i] = (E) popped.value;
        }

        //reverse order - smallest to biggest
        if (ascending == true)
        {
            //iterate through and swap corresponding indices
            for (int i = 0; i < sortedArr.length/HALF_ARR; i++)
            {
                E temp1 = sortedArr[i];

                E temp2 = sortedArr[sortedArr.length-1-i];

                sortedArr[i] = temp2;

                sortedArr[sortedArr.length-1-i] = temp1;

            }   
        }

        return sortedArr;
    }
}
