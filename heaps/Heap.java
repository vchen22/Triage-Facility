package com.cse.ds.heaps;

import java.util.Arrays;

/**
 * Author: Vicki Chen
 * CSE12 Login: cs12sp19af
 * Date: 5/21/19
 * File: Heap.java
 * Source of Help: PA7 writeup, Piazza, CSE12 tutor
 *
 * This file contains the class Heap. 
 * It has the properties of the tree-based data structure Heap.
 */

/**
 * This class provides the functionality of a maximum heap. It has methods
 * that will reorganize the structure by comparing nodes' priority
 * */
public class Heap {

    private Tuple[] data; //This stores data in accoradance with heap rules.
    //This keeps track of last index where an element was inserted.
    private int last_idx;

    private static final int GROWTH_FACTOR = 2;

    /**
     * Initializes an empty heap data structure
     * @return Heap object
     * */
    public Heap() {
        data = new Tuple[1];
        last_idx = 0;
    }

    /**
     * Create a heap out of an array of Tuples.
     * @param arr Array of elements 
     */
    public Heap(Tuple arr[]) {
        //TODO: Fill implementation

        data = new Tuple[arr.length+1];

        //iterate through contents of arr to tuple
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
        if (i < 1 || i > this.getSize())
        {
            throw new IllegalArgumentException("Cannot Heapify index " 
                    + "greater than heap size.");
        }

        int left = GROWTH_FACTOR*i;
        int right = GROWTH_FACTOR*i+1;
        int largest = 0;

        //Check if left child is larger than root
        if (left <= last_idx && data[left].priority > data[i].priority)
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
                data[right].priority > data[largest].priority)
        {
            largest = right;
        }

        //if largest is not the root, swap tuples
        if (largest != i)
        {
            Tuple temp1 = data[i];
            Tuple temp2 = data[largest];

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
    public Tuple getMax() {
        //TODO: Fill implementation
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
    public Tuple heappop() {
        //TODO: Fill implementation
        if (this.getSize() == 0)
        {
            return null;
        }

        //get root
        Tuple max = this.getMax();

        Tuple deletedElement = new Tuple(Integer.MIN_VALUE, null);

        //move to left of heap
        data[1] = data[last_idx];
        data[last_idx] = deletedElement;

        //rearrange + shrink array
        heapify(1);

        //decrease size
        last_idx--;

        return max;
    }

    /**
     * This function increases the priority of a node.
     * @param i index in heap
     * @param priority New priority
     */
    public void increasePriority(int i, int priority) {
        //TODO: Fill implementation

        if (priority < data[i].priority)
        {
            throw new IllegalArgumentException("Priority less than Current");
        }

        //create tuple with new priority
        Tuple newElement = new Tuple(priority, data[i].value);

        //put back into position
        data[i] = newElement;

        //swap until parent is bigger than child
        while (i > 1 && data[i/GROWTH_FACTOR].priority < data[i].priority)
        {
            Tuple temp1 = data[i];
            Tuple temp2 = data[i/GROWTH_FACTOR];

            data[i/GROWTH_FACTOR] = temp1;
            data[i] = temp2;

            i = i/GROWTH_FACTOR;
        }
    }

    /**
     * This function pushes a new element in the heap
     * @param arg Given tuple to add
     */
    public void heappush(Tuple arg) {
        //TODO: Fill implementation

        //if heap filled, grow heap by 1
        if (last_idx + 1 == data.length)
        {
            Tuple[] newData = new Tuple[data.length+1];
            for (int i = 0; i < data.length; i++)
            {
                newData[i] = data[i];
            }

            data = newData;
        }

        //move one space over to where tuple will be added
        last_idx++;
        //create tuple with temp priority
        Tuple newArg = new Tuple(Integer.MIN_VALUE, arg.value);
        //add to heap
        data[last_idx] = newArg;
        //update priority and rearrange
        this.increasePriority(last_idx, arg.priority);

    }

    /**
     * This function returns the size of the heap.
     * @return last_idx Number of nodes
     */
    public int getSize()
    {
        //TODO: Fill implementation
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
