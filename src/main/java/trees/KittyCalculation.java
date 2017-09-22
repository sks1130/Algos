/**
 * 
 */
package trees;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author sachin
 * @problem : https://www.hackerrank.com/challenges/kittys-calculations-on-a-tree?h_r=next-challenge&h_v=zen
 * 
 *
 */
public class KittyCalculation {
	static class Node{
		int data;
		Node next;
		int depth = 0;
		HashSet<Integer> adj;
		public Node(int data){
			this.data = data;
			adj = new HashSet<>();
		}
	}
	private static int[][] matrix;
	private static Set<Integer> parentNodess = new HashSet<>();
	private static int dist(int[][]matrix, int a , int b){
		//2 to 4 .
		int dist = 0;
		for (Integer parent : parentNodess) {
			if(Arrays.binarySearch(matrix[parent],a) > 0 && Arrays.binarySearch(matrix[parent],b) > 0)  {
				 dist+=2;
				 return dist;
			}
			if((parent == a && Arrays.binarySearch(matrix[parent],b) > 0  ) || (parent == b && Arrays.binarySearch(matrix[parent],a) > 0  )){
				dist+=1;
				return 1;
			}
			dist++;
			if(Arrays.binarySearch(matrix[parent],b) > 0  ){
				return dist;
			}
		}
		return dist;
	}
	static void combinations2(int[] arr, int len, int startPosition, int[] result){
        if (len == 0){
            System.out.println(dist(matrix, result[0], result[1]));
            return;
        }       
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }     
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int q = scan.nextInt();
		matrix = new int[n+1][n+1];
		for (int[] row: matrix){
			Arrays.fill(row, -1);
		}
		while(n -- > 1){
			int a = scan.nextInt();
			int b = scan.nextInt();
			matrix[a][b] = b;
			parentNodess.add(a);
		}
		System.out.println(Arrays.deepToString(matrix));
		scan.close();
	}

}
