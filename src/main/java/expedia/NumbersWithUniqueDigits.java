/**
 * 
 */
package expedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author sachin
 * @problem : http://www.geeksforgeeks.org/expedia-interview-experience-set-12-campus/
 *
 */
public class NumbersWithUniqueDigits {

	/**
	 * @param: Given a range [m,n] , print the count of numbers having distinct digits. 
	 * For eg, 12 is said to have all digits distinct while 121 is not.
	 */
	public static void main(String[] args) {
		int m = 2;
		int n = 100;
		List<Integer> list = new ArrayList<>();
		for (int i = m; i <= n; i++) {
			if (checkUniqueDigits(i)) {
				list.add(i);
			}
		}
		System.out.println(list.size());
	}

	public static boolean hasUniqueDigits(int n) {
		String num = Integer.toString(n);
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < num.length(); i++) {
			if (!map.containsKey(num.charAt(i))) {
				map.put(num.charAt(i), 1);
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean checkUniqueDigits(int n) {
		HashSet<Integer> set = new HashSet<>();
		int count = 0;
		while (n > 0) {
			int d = n % 10;
			set.add(d);
			n = n / 10;
			count++;
		}
		return set.size() == count;
	}
}
