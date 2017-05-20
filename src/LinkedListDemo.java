/**
 * @author sachin
 *
 */
public class LinkedListDemo {
	static Node head;
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	static Node reverse(Node head){
		
		Node current = head;
		Node next = null;
		Node prev = null;
		while(current!=null){
			next = current.next;
			current.next=prev; 
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
	static void printList(Node head){
		while(head!=null){
			System.out.println(head.data + " ");
			head = head.next;
		}

	}
	//	static void recursiveReverse(Node head)  {
	//		if(head ==null){
	//			return;
	//		}
	//		recursiveReverse(head.next);
	//		System.out.println(head.data + " ");
	//	}
	public static void main(String[] args) {
		LinkedListDemo.head = new Node(25);
		LinkedListDemo.head.next = new Node(35);
		LinkedListDemo.head.next.next = new Node(14);
		LinkedListDemo.head.next.next.next = new Node(12);
		System.out.println("Original Linked list is :");
		LinkedListDemo.printList(head);
		System.out.println("Reversed linked list : ");
		//LinkedListDemo.recursiveReverse(head);
		head = LinkedListDemo.reverse(head);
		LinkedListDemo.printList(head);
	}

}
