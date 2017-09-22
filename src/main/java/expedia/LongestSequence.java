/**
 * 
 */
package expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sachin
 
 */
public class LongestSequence {

	
	public static void main(String[] args) {
		int[] arr = {3, 10, 2, 1, 20};
		System.out.println(longestIncreasingSequence(arr));
	}
	
	static int longestIncreasingSequence(int[] arr){
		/**
		 * @http://www.geeksforgeeks.org/longest-increasing-subsequence/
		 *  LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
		 *  Input  : arr[] = {3, 10, 2, 1, 20}
		Output : Length of LIS = 3
		The longest increasing subsequence is 3, 10, 20
		
		Input  : arr[] = {3, 2}
		Output : Length of LIS = 1
		The longest increasing subsequences are {3} and {2}
		
		//in the following input logic would get failed as first element is greater than 2nd
		Input : arr[] = {50, 3, 10, 7, 40, 80}
		Output : Length of LIS = 4
		The longest increasing subsequence is {3, 7, 40, 80}
		*****
		//@Best solution in O(nlogn) https://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
		 @Hackerrank : http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
		 ***/
		int len = 1;
		int n = arr.length;
		int[] S  = new int[n];
		S[0] = arr[0];
		for(int i =1; i < n;i++){
			if(S[0] > arr[i]){
				S[0] = arr[i];
			} else if(arr[i] > S[len-1]){
				S[len++] = arr[i];
			} else {
				for(int j = 0; j<len;j++){
					if(arr[i] < S[j]){
						S[j] = arr[i];
					}
				}
			}
		}
		return len;
	}
	static int longestSeqWithAdjacent0or1(int[] arr) {
		/***
		 * @problem : http://www.geeksforgeeks.org/maximum-length-subsequence-
		 *          difference-adjacent-elements-either-0-1/
		 * 
		 *          Input : arr[] = {2, 5, 6, 3, 7, 6, 5, 8} Output : 5 The
		 *          subsequence is {5, 6, 7, 6, 5}.
		 * 
		 *          Input : arr[] = {-2, -1, 5, -1, 4, 0, 3} Output : 4 The
		 *          subsequence is {-2, -1, -1, 0}.
		 */
		// O(n) time O(n) extra space

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			int diff = 0;
			if (list.isEmpty()) {
				diff = arr[i] - arr[i + 1];
			} else {
				diff = arr[i] - list.get(list.size() - 1);
			}
			if (Math.abs(diff) == 0 || Math.abs(diff) == 1) {
				list.add(arr[i]);
			}

		}
		return list.size();
	}

}
