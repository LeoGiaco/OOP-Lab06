package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private static final int ELEMS = 100000;
	private static final int NUMBERS = 1000;
	private static final int INF_LIMIT = 1000;
	private static final int SUP_LIMIT = 2000;
    private static final int TO_MS = 1_000_000;
	
    private UseCollection() {
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
    	List<Integer> arrayList = new ArrayList<>();
    	Random r = new Random();
    	for(int i = 0; i < NUMBERS; i++) {
    		arrayList.add(r.nextInt(SUP_LIMIT - INF_LIMIT) + INF_LIMIT);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	List<Integer> linkedList = new LinkedList<>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int temp = arrayList.get(0);
    	arrayList.set(0, arrayList.get(NUMBERS - 1));
    	arrayList.set(arrayList.size() - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (Integer i : linkedList) {
			System.out.println(i);
		}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long arrayTime = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            arrayList.add(0, 1);
        }
        arrayTime = System.nanoTime() - arrayTime;
        System.out.println("Write to ArrayList: " + arrayTime / TO_MS + " ms");
        // Second list
        long linkedTime = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            linkedList.add(0, 1);
        }
        linkedTime = System.nanoTime() - linkedTime;
        System.out.println("Write to LinkedList: " + linkedTime / TO_MS + " ms");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        long readArrayTime = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            arrayList.get(arrayList.size() / 2);
        }
        readArrayTime = System.nanoTime() - readArrayTime;
        System.out.println("Read on ArrayList: " + readArrayTime / TO_MS + " ms");
        // Second list
        long readLinkedTime = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
        	linkedList.get(linkedList.size() / 2);
        }
        readLinkedTime = System.nanoTime() - readLinkedTime;
        System.out.println("Read on LinkedList: " + readLinkedTime / TO_MS + " ms");
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
        Map<String, Long> continents = new HashMap<>();
        continents.put("Africa", 1110635000L);
        continents.put("Americas", 972005000L);
        continents.put("Antarctica", 0L);
        continents.put("Asia", 4298723000L);
        continents.put("Europe", 742452000L);
        continents.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
        long population = 0;
        for (String cont : continents.keySet()) {
			population += continents.get(cont);
		}
        System.out.println("Total population: " + population);
    }
}
