package com.cse.ds.sorting;

import java.util.Arrays;

/**
 * Author: Vicki Chen
 * CSE12 Login: cs12sp19af
 * Date: 5/22/19
 * File: StringHeap.java
 * Source of Help: PA7 write up, Piazza
 * 
 * This file contains the class StringHeap.
 * It has the properties of the tree-based data structure Heap and
 * contains Strings
 */

/**
 * This class provides the functionality of a maximum heap that contains
 * Strings. It has methods that will reorganize the structure by comparing
 * nodes based on alphabetical order
 * */
public class StringHeap {

    private String[] data;
    private int last_idx;

    private static final int GROWTH_FACTOR = 2;
    private static final String EMPTY_STR = "";

    /**
     * Initializes an empty string heap data structure
     * @return StringHeap object
     * */
    public StringHeap() {
        // TODO Auto-generated constructor stub
        data = new String[1];
        last_idx = 0;       
    }

    /**
     * Create a heap out of an array of Strings.
     * @param arr Array of Strings
     */
    public StringHeap(String arr[]) {
        // TODO: Implementation here
        data = new String[arr.length+1];

        //iterate through contents of arr to the instance variable data
        for (int i = 1; i < arr.length+1; i++)
        {
            data[i] = arr[i-1];
        }

        last_idx = data.length-1;

        //iterate to reorganize nodes in heap by the rules
        for (int i = (data.length-1)/GROWTH_FACTOR; i >= 1; i--)
        {
            heapify(i);
        }
    }

    /**
     * This corrects a single violation at position i, if left and right 
     * subtrees are max heaps.
     * @param i index of heap
     */
    public void heapify(int i) {
        // TODO: Implementation here

        if (i < 1 || i > this.getSize())
        {
            throw new IllegalArgumentException("Cannot Heapify index " 
                    + "greater than heap size.");
        }

        int left = GROWTH_FACTOR*i;
        int right = GROWTH_FACTOR*i+1;
        int largest = 0;

        //check if left child is larger than root
        if (left <= last_idx && data[left].compareTo(data[i]) > 0)
        {
            largest = left;
        }
        else
        {
            //if not, set largest as root
            largest = i;
        }

        //check if right child is larger than root
        if (right <= last_idx && right < data.length && 
                data[right].compareTo(data[largest]) > 0)
        {
            largest = right;
        }

        //if largest is not the root, swap strings
        if (largest != i)
        {
            String temp1 = data[i];
            String temp2 = data[largest];

            data[largest] = temp1;
            data[i] = temp2;

            //call method to rearrange
            heapify(largest);
        }
    }

    /**
     * This function returns the max element from the heap without removing 
     * the element from heap.
     * @return root
     */
    public String getMax() {
        // TODO: Implementation here
        if (this.getSize() == 0)
        {
            return null;
        }

        //root = max
        return data[1];  

    }

    /**
     * This function removes and returns the max element from the heap
     * @return max Removed root
     */
    public String heappop() {
        // TODO: Implementation here
        if (this.getSize() == 0)
        {
            return null;
        }

        //get root
        String max = this.getMax();

        String deletedElement = new String(EMPTY_STR);

        //move to left og heap
        data[1] = data[last_idx];
        data[last_idx] = deletedElement;

        //rearrange + shrink array
        heapify(1);

        //decrease size
        last_idx--;

        return max;

    }

    /**
     * This function returns the size of the heap.
     * @return last_idc Number of nodes
     */
    public int getSize()
    {
        // TODO: Implementation here
        return last_idx;
    }

    /**
     * String representation of heap
     * @return String of heap
     * */
    @Override
        public String toString() {
            // TODO Auto-generated method stub
            return Arrays.toString(data);
        }
}
