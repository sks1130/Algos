import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class StackImplementationUsingSingleQueue {
	
	private static Queue<Integer> queue = new LinkedList<>();
	
	public static Integer pop(){
		if(queue.isEmpty()){
			return -1;
		}
		return queue.poll();
	}
	
	public static Integer peek(){
		if(queue.isEmpty()){
			return -1;
		}
		return queue.peek();
	}
	public static int size(){
		if(queue.isEmpty()){
			return 0;
		}
		return queue.size();
	}
	public static Integer push(Integer e){
		int size = queue.size();
		queue.add(e);
		for (int i = 0; i < size; i++) {
			Integer q  = queue.remove();
			queue.add(q);
		}
		return e;
	}

	public static void main(String[] args) {
		push(1);
		push(3);
		push(4);
		push(2);
		push(7);
		push(10);
		int size = size();
		for (int i = 0; i < size; i++) {
			System.out.println("stack-->" + queue);
			System.out.println("peek-->" + peek());
			System.out.println("pop-->" + pop());
		}
	}
}
