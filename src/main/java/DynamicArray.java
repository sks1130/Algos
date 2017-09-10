/**
 * 
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sachin
 * @problem : https://www.hackerrank.com/challenges/dynamic-array?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 *
 */
public class DynamicArray {

	/**
	 * passes all the test cases
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int Q = scan.nextInt();
		 List<List<Integer>> list = new ArrayList<>();
		 for(int i=0;i<N;i++){
			 list.add(new ArrayList<>());
		 }
		 int lastAnswer = 0;
		 for(int i = 0;i< Q ;i++){
			 int o = scan.nextInt();
			 int x = scan.nextInt();
			 int y = scan.nextInt();
			 int index = (x ^ lastAnswer) % N;
				List<Integer> seq = list.get(index);
				if(o ==1){
					seq.add(y);
				}  else {
					lastAnswer = seq.get(y%seq.size());
					System.out.println(lastAnswer);
				}
		 }
		 scan.close();
		 
	}

}
