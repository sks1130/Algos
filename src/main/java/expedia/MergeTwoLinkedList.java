/**
 * 
 */
package expedia;

/**
 * @author sachin
 * http://www.geeksforgeeks.org/expedia-interview-experience-set-12-campus/
 * Given two linked list, merge them such that all the similar elements are merged together.
 *  (You’re not allowed to sort and merge or take additional memory, should have O(n) approach)
 *
 */
public class MergeTwoLinkedList {

	/**
	 * @param args
	 *            /**** Given two linked lists combine them in a way such that
	 *            the resultant must contain the elements alternatively from one
	 *            list and the other list? For ex. LL1 : 1->2->3->4 LL2 :
	 *            5->6->7 Result : 1->5->2->6->3->7->4
	 *****/
	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.next = new Node(2);
		root1.next.next = new Node(3);
		root1.next.next.next = new Node(4);

		Node root2 = new Node(5);
		root2.next = new Node(6);
		root2.next.next = new Node(7);
		Node head = mergeList(root1, root2);//mergeLLWithAlterElements(root1, root2);
		printNodes(head);
	}

	static Node mergeLLWithAlterElements(Node head1, Node head2) {

		return mergeLLWithAlterElements(head1, head2, null, true);

	}

	static void printNodes(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
	}

	static Node mergeList(Node head1, Node head2) {
		boolean flag = true;
		Node head = null;
		Node curr = null;
		while (head1 != null && head2 != null) {
			if (flag) {
				curr = new Node(head1.data);
				flag = false;
				head1 = head1.next;
			} else {
				curr = new Node(head2.data);
				flag = true;
				head2 = head2.next;
			}
			if (head == null) {
				head = curr;
			} else {
				addNext(head, curr);
			}
			curr = curr.next;
		}
		Node rem = head1 == null ? head2 : head1;
		addNext(head, rem);
		return head;
	}
	static void addNext(Node root, Node curr){
		Node temp = root;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = curr;
	}
	static Node mergeLLWithAlterElements(Node head1, Node head2, Node head, boolean flag) {
		/****
		 * Given two linked lists combine them in a way such that the resultant
		 * must contain the elements alternatively from one list and the other
		 * list? For ex. LL1 : 1->2->3->4 LL2 : 5->6->7 Result :
		 * 1->5->2->6->3->7->4
		 *****/
		if (head1 == null && head2 == null) {
			return head;
		}
		if (flag) {
			flag = false;
			if (head1 != null) {
				head = new Node(head1.data);
			}
			head.next = mergeLLWithAlterElements(head1.next, head2, head.next, flag);
		} else {
			flag = true;
			if (head2 != null) {
				head = new Node(head2.data);
			}
			head.next = mergeLLWithAlterElements(head1, head2.next, head.next, flag);
		}
		return head;

	}

	static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
}
