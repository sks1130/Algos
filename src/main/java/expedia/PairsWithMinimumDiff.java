/**
 * 
 */
package expedia;

import java.util.TreeMap;

/**
 * @author sachin
 * @problme : http://www.geeksforgeeks.org/expedia-interview-experience-set-12-campus/
 * Given an array of integers, print all (i,j) pairs (in ascending order) having minimum difference.
 *
 */
public class PairsWithMinimumDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMap<Integer, Integer> map = new TreeMap<>((m1 , m2) -> m2.compareTo(m1) );
		map.put(1, 1);
		map.put(3, 3);
		map.put(4, 4);
		map.put(2, 2);
		map.put(5, 5);
		System.out.println(map);
	}
	private static void printAllPairs(int[] arr){
		//
	}

}
