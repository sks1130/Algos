import java.util.LinkedList;
import java.util.List;

/**
 * @author sachin
	 * 
	 * Question 1:  Implement a stack using array.
	 * Question 2:  Implement a stack using Linked List :
     * Question 3:  Implement a stack using two queues .
     * Question 4 : Sort an stack using another stack
 */
public class StackUsingArray {
	//implementing a stack using an array.
	//stack -- LIFO  ///pop //peek //top of array should return head or top of stack.
	//   ------------
	private static final int capacity = 10;
	private static int[]  intArray = new int[capacity];
	private static  int top = -1;
	
	public static void push(int a ){
		if(top < (capacity-1)){
			top++;
			System.out.println("\n----adding element in stack  = " + a );
			intArray[top]  = a;
		} else {
			System.out.println("stack is full");
		}
	}
	public static void pop(){
		if(top > -1){
			top--;
		} else {
			System.out.println("no element in the stack to pop");
		}
	}
	
	public static int peek(){
		if(top == -1){
			return 0;
		}
		return intArray[top];
	}
	public static void printStack(){
		if(top > -1){
			System.out.println("\n-----printing the stack----\n");
			for (int i = 0; i <= top; i++) {
				System.out.print(intArray[i] + " ");
			}
			System.out.println("\n-----printing the stack- ends---\n");
		} else {
			System.out.println("\n---stack is empty---\n");
		}
	}
	public static int size(){
		return top+1;
	}
	
	public static void main(String[] args) {
		push(2);
		push(4);
		push(6);
		push(12);
		push(12);
		push(12);push(12);push(12);push(12);push(12);push(12);push(12);push(12);
		printStack();
		System.out.println("\nbfore pop  peek=" + peek() + " and size of stack=" + size());
		pop();
		System.out.println("\nafter pop ");
		printStack();
		System.out.println("\nbfore pop peek=" + peek() + " and size of stack=" + size());
		pop();
		System.out.println("\nafter pop ");
		printStack();
		System.out.println("\nbfore pop  peek=" + peek()+ " and size of stack=" + size());
		pop();
		System.out.println("\nafter pop ");
		printStack();
		System.out.println("\nbfore pop  peek=" + peek()+ " and size of stack=" + size());
		pop();
		System.out.println("\nafter pop  ");
		printStack();
	}
}
