import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author sachin
 * @problem : https://www.hackerrank.com/challenges/crush
 * 
 ****really a tough problems and great challengw
 */
public class ArrayManipulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long[] arr = new long[n + 1];
		for (int a0 = 0; a0 < m; a0++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();
			arr[a - 1] += k;
			arr[b] -= k;
		}
		long sum = 0;
		long max = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			max = Math.max(sum, max);
		}
		System.out.println(max);
		in.close();
	}
}
