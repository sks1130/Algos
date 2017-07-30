/**
 * 
 */

/**
 * @author sachin
 *
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class SinglyLinkedList<E> {
	Node<E> head;

	public <T> void add(T data) {
		Node current = tail();
		if (current == null) {
			head = new Node(data);
		} else {
			current.next = new Node(data);
		}
	}
	
	public void printSLL(Node head){
		Node current = head;
		System.out.print(current.data + " ");
		while(current.next !=null){
			current = current.next;
			System.out.print(current.data + " ");
		}
	}
	public boolean isEmpty(){
		return length() == 0;
	}
	
	public Node peek(){
		return head;
	}
	
	public Node tail(){
		Node tail = head;
		if(tail == null){
			return null;
		}
		while(tail.next!=null){
			tail = tail.next;
		}
		return tail;
	}

	public int length() {
		if (head == null) {
			return 0;
		}
		int len = 1;
		Node current = head;
		while (current.next != null) {
			len++;
			current = current.next;
		}
		return len;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		sll.add(21);
		sll.add(121);
		sll.add(321);
		sll.add(421);
		sll.add(2121);
		System.out.println("size of sll =" + sll.length());
		System.out.println("head of sll =" + sll.head.data);
		System.out.println("tail of sll =" + sll.tail().data);
		System.out.println("\n----printing all the nodes---\n");
		sll.printSLL(sll.head);
		System.out.println("\n----printing all the nodes after reversal---\n");
		sll.printSLL(sll.reverse(sll.head));
	}
    public Node reverse(Node node){
    	Node currentNode = node;
    	Node next = null;
    	Node prev = null;
    	while(currentNode!=null){
    		next = currentNode.next;
    		currentNode.next = prev;
    		prev = currentNode;
    		currentNode = next;
    	}
		return prev;
    }
    
	private static class Node<T> {
		Node<T> next;
		T data;
		public Node(T data) {
			this.data = data;
		}
	}
}
