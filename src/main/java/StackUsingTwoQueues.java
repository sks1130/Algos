import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	
	public static void sordStack(Stack<Integer> stack){
		if(!stack.isEmpty()){
			int top = stack.pop();
			sordStack(stack);
			sortedInsert(stack, top);
		}
	}
	
	public static void sortedInsert(Stack<Integer> stack , int x){
		if(stack.isEmpty()  ||  (x > stack.peek())){
			stack.push(x);
			return;
		}
		int temp = stack.pop();
		sortedInsert(stack, x);
		stack.push(temp);
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<>();
        s1.push(11);
        s1.push(2);
        s1.push(31);
        s1.push(42);
        s1.push(5);
        s1.push(61);
        s1.push(71);
        s1.push(8);
        s1.push(91);
        s1.push(10);
        
        System.out.println("stack before sorting-->" + s1);
        sordStack(s1);
        System.out.println("stack after sorting-->" + s1);
	}

}
