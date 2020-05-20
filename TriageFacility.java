package com.cse.ds.hospital;

import com.cse.ds.heaps.Heap;
import com.cse.ds.heaps.Tuple;
import java.util.*;

/**
 * Author: Vicki Chen
 * CSE12 Login: cs12sp19af
 * Date: 5/22/19
 * File: TriageFacility.java
 * Source of Help: PA7 write up, Piazza
 *
 * This file contains the class TriageFacility.
 * It determines when patients can get service
 */

/**
 * This class contains methods organizes and add patients based on priority to 
 * determine who will be seen at the facility
 * */
public class TriageFacility {

    private Heap heap;

    private static final int CALC_PRIORITY = 95;
    private static final String COLON_KEY = ":";

    /**
     * Initializes a TriageFacility by constructing a Generic heap, where each
     * element has a value(patient name) and an integer priority (patient
     * priority)
     * @param patients List of patients
     * @return TriageFacility object
     * */
    public TriageFacility(String[] patients) {
        //TODO: Implementation here

        Tuple[] patientList = new Tuple[patients.length];

        //iterate through extract info to add into a tuple array
        for (int i = 0; i < patients.length; i++)
        {
            String temp = patients[i];

            //extract priority
            int priority = 
                Math.abs(CALC_PRIORITY-Integer.parseInt(
                            temp.substring(temp.indexOf(COLON_KEY)+1, 
                                temp.length())));

            //create tuple with extracted info
            Tuple add = new Tuple(priority,
                    temp.substring(0, temp.indexOf(COLON_KEY)));

            //add newly created tuples into list
            patientList[i] = add;

        }

        //create heap
        heap = new Heap(patientList);

    }

    /**
     * Removes and returns the patient with highest priority from the
     * TriageFacility.
     * @return patient with highest priority
     * */
    public String serviceNextPatient() {
        //TODO: Implementation here
        if (heap.getSize() == 0)
        {
            return null;
        }

        //get patient
        Tuple nextPatient = heap.heappop();

        //get patient name
        return (String) nextPatient.value;


    }

    /**
     * Takes a new patient string and adds to the TriageFacility
     * @param patient Patient to add
     * @return void
     * */
    public void addNewPatient(String patient) {
        //TODO: Implementation here

        //extract priority info
        int priority = Math.abs(CALC_PRIORITY-Integer.parseInt(
                    patient.substring(patient.indexOf(COLON_KEY)+1, 
                        patient.length())));

        //create new tuple with extracted info
        Tuple add = new Tuple(priority,patient.substring(0, 
                    patient.indexOf(COLON_KEY)));

        //add tuple to heap
        heap.heappush(add);        
    }

    /**
     * Number of patients who still needs to be serviced by the TriageFacility
     * @return number of patients waiting for service
     * */
    public int getTriageLength() {
        //TODO: Implementation here
        return heap.getSize();
    }
}
