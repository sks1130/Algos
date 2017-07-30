import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class StackUsingLinkedList<E>  {

	public static final int capacity = 10;
	public  List<E> stackList  = new LinkedList<>();
	public static int mod = 0;

	public  E push(E item){
		if(mod < (capacity -1)){
			mod++;
			stackList.add(item);
			return item;
		} else {
			System.out.println("stack size exceeds the capacity");
			return null;
		}
	}

	public E peek(){
		if(mod > 0){
			return stackList.get(mod-1);
		} else {
			return null;
		}
	}

	public static int size(){
		return mod;
	}

	public E pop(){
		if(mod > 0){
			E top = stackList.get(mod-1);
			stackList.remove(mod-1);
			return top;
		} else {
			return null;
		}
	}

	public  void printStack(){
		for (int i = 0; i <= mod -1; i++) {
			System.out.println("element at index=" + i  + " and value=" + this.stackList.get(i)) ;
		}
	}
	public static void main(String[] args) {
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
		stack.push(1);
		stack.push(11);
		stack.push(111);
		stack.push(1111);
		stack.push(133);
		stack.push(1323);stack.push(1323);stack.push(1323);stack.push(1323);stack.push(1323);stack.push(1323);
		stack.printStack();
	}

}
