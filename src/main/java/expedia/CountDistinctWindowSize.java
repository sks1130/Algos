/**
 * 
 */
package expedia;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sachin
 * http://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
 * Given an array of size n and an integer k, return the of count of distinct numbers in all windows of size k.

Example:

Input:  arr[] = {1, 2, 1, 3, 4, 2, 3};
            k = 4
Output:
3
4
4
3

Explanation:
First window is {1, 2, 1, 3}, count of distinct numbers is 3
Second window is {2, 1, 3, 4} count of distinct numbers is 4
Third window is {1, 3, 4, 2} count of distinct numbers is 4
Fourth window is {3, 4, 2, 3} count of distinct numbers is 3
 *
 */
public class CountDistinctWindowSize {

	/**
	 * @param args
	 * There are two solution but O(n) is achievable
	 */
	public static void main(String[] args) {
		//O(n*k)
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;
		distinctWindowSize(arr, k);
		

	}
	static void distinctWindow(int[] arr , int k){
		for (int i = 0; i+k <= arr.length; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = i; j < i + k; j++) {
				System.out.print(arr[j] + " ");
				map.put(arr[j], arr[j]);
			}
			if (!map.isEmpty()) {
				System.out.println("distinct elements=" + map.size());
			}
		}
	}
	//O(n) solution is possible
	static void distinctWindowSize(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}

		}
		System.out.println(map.size());
		int x = 0;
		for (int j = k; j < arr.length; j++) {
			// removing the first element
			Integer old = map.get(arr[x]);
			if (old != null) {
				if (old > 1) {
					map.put(arr[x], map.get(arr[x]) - 1);
				} else {
					map.remove(arr[x]);
				}
			}
			if (map.get(arr[j]) == null) {
				map.put(arr[j], 1);
			} else {
				map.put(arr[j], map.get(arr[j]) + 1);
			}
			x++;
			System.out.println(map.size());
		}
	}
}