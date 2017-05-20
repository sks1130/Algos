import java.util.PriorityQueue;
import java.util.Random;

/**
 * 
 */

/**
 * @author sachin srivastava
 * tek9g.blogspot.co
 *
 */
public class MergingSortedSequence {
	
	public static void main(String[] args) {
		int[] arr1  = {1,3,6,4,8,90,133};
		int[] arr2  = {2,3,1,17,18};
		int[] arr3  = {4,5,6,8,11};
		int[] arr4  = {125,9,10,13,34};
		int[] arr = new int[arr1.length + arr2.length + arr3.length + arr4.length];
		PriorityQueue<Integer> prq = new PriorityQueue<>((x,y)->y-x);
		/*for (int i = 0; i < arr.length; i++) {
			if(i<arr1.length){
				prq.add(arr1[i]);
			}
			if(i<arr2.length){
				prq.add(arr2[i]);
			}
			if(i<arr3.length){
				prq.add(arr3[i]);
			}
			if(i<arr4.length){
				prq.add(arr4[i]);
			}
		}*/
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			int rand = random.nextInt(20);
			System.out.print(rand +" ");
			prq.add(rand);

		}
		System.out.println("\n------\n");
		while (!prq.isEmpty()) {
			System.out.print(prq.poll()+" ");
		}
	}
}
