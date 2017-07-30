import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class StackUsingTwoQueues {

	private static Queue<Integer> queue1 = new LinkedList<>();
	private static Queue<Integer> queue2 = new LinkedList<>();
	
	public static void push(Integer e){
		if(queue1.isEmpty()){
			queue1.add(e);
		} else {
			while(queue1.size() > 0){
				queue2.add(queue1.poll());
			}
			queue1.add(e);
			while(queue2.size() > 0){
				queue1.add(queue2.poll());
			}
		}
	}
	
	public static Integer pop(){
		if(!queue1.isEmpty()){
			return queue1.poll();
		} else if(!queue2.isEmpty()){
			return queue2.poll();
		}
		return null;
	}
	public int peek(){
		if(!queue1.isEmpty()){
			return queue1.peek();
		} else if(!queue2.isEmpty()){
			return queue2.peek();
		}
		return 0;
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		StackUsingTwoQueues s1 = new StackUsingTwoQueues();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.push(6);
        s1.push(7);
        s1.push(8);
        s1.push(9);
        s1.push(10);
        System.out.println("stack-->" + s1);
        System.out.println("1st = " + s1.pop());
        System.out.println("2nd = " + s1.pop());
        System.out.println("3rd = " + s1.pop());
        System.out.println("4th = " + s1.pop());
        System.out.println("5th = " + s1.pop());
        System.out.println("6th = " + s1.pop());
        System.out.println("7th = " + s1.pop());
        System.out.println("8th = " + s1.pop());
        System.out.println("9th = " + s1.pop());
        System.out.println("10th= " + s1.pop());
	}

}
