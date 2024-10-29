package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int LOWERBOUND_RANGE = 1000;
    private static final int UPPERBOUND_RANGE = 2000;
    private static final int ELEMS = 100;
    private static final int READS = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> integerArray = new ArrayList<Integer>();

        for(int i = LOWERBOUND_RANGE; i < UPPERBOUND_RANGE; i++){
            integerArray.add(i);
        }
        
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> integerList = new LinkedList<Integer>(integerArray);



        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final Integer tmpFirst = integerArray.get(0);
        
        integerArray.set(0, integerArray.get(integerArray.size()-1));
        integerArray.set(integerArray.size()-1, tmpFirst);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(Integer elem : integerArray){
            System.out.println(elem);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long arrayListTime = System.nanoTime();

        for(int i = 1; i <= ELEMS; i++){
            integerArray.addFirst(i);
        }

        arrayListTime = System.nanoTime() - arrayListTime;

        long linkedListTime = System.nanoTime();

        for(int i = 1; i <= ELEMS; i++){
            integerList.addFirst(i);
        }

        linkedListTime = System.nanoTime() - linkedListTime;

        System.out.println("ArrayList time: " + arrayListTime);
        System.out.println("LinkedList time: " + linkedListTime);

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        arrayListTime = System.nanoTime();

        for(int i = 0; i < READS; i++){
            integerArray.get(integerArray.size()/2);
        }

        arrayListTime = System.nanoTime() - arrayListTime;

        linkedListTime = System.nanoTime();

        for(int i = 0; i < READS; i++){
            integerList.get(integerArray.size()/2);
        }

        linkedListTime = System.nanoTime() - linkedListTime;

        System.out.println("ArrayList time: " + arrayListTime);
        System.out.println("LinkedList time: " + linkedListTime);

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String,Long> continentsPopulation = new HashMap<String,Long>();

        continentsPopulation.put("Africa", 1110635000L);
        continentsPopulation.put("Americas", 972005000L);
        continentsPopulation.put("Antarctica", 0L);
        continentsPopulation.put("Asia", 4298723000L);
        continentsPopulation.put("Europe", 742452000L);
        continentsPopulation.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */

        long totalPopulation = 0;

        for(Long elem : continentsPopulation.values()){
            totalPopulation += elem;
        }

        System.out.println(totalPopulation);

    }
}
