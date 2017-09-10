import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * 
 */

/**
 * @author sachin.srivastava
 * @hackerrank - https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid?h_r=next-challenge&h_v=zen
 * awesome connected cells problem with dfs
 *
 */
public class DFSMaxRegion {

	public static void main(String[] args) {
		Node head = new Node();
		head.data = 1;
		head.next = new Node();
		head.next.data = 2;
		insertAtTail(head, 3);
		insertAtTail(head, 4);
		head = insertAtHead(head, 5);
		head = insertAtHead(head, 6);
		head = insertAtHead(head, 5);
		head = InsertNth(head, 7, 2);
		print(head);
	//	head = Delete(head, 0);
		print(head);
		//head = reverse(head);
		head = RemoveDuplicates(head);
		print(head);
	}
	static Node SortedInsert(Node head,int data) {
		//need to sort the LLs and insert the element accordingly.
		//2 5 4 --> 2 -> 4 <-> 5 -> null
		//@hacker trank --> https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list
		Node newNode = new Node();
	    newNode.data = data;
	    if(head == null){
	        return newNode;
	    }
	    if(head.data > data){
	        head.next = newNode;
	        newNode.next = head;
	        return newNode;
	    }
	    Node curr = head;
	    while(curr.next!=null){
	        if(curr.next.data > data){
	            Node temp =  curr.next;
	            curr.next = newNode;
	            newNode.next = temp; 
	            break;
	        }
	        curr = curr.next;
	    }
	    curr.next = newNode;
	    return head;
	}
	static Node partition(Node head){
		Node slow = head;
		Node fast = head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		Node temp = slow.next;
		slow.next = null;
		return temp;
	}
	private static int getMaxRegions(int[][] matrix) {
		int maxRegion = 0;
		for (int rows = 0; rows < matrix.length; rows++) {
			for (int col = 0; col < matrix[rows].length; col++) {
				if (matrix[rows][col] == 1) {
					int size = getRegionSize(matrix, rows, col);
					maxRegion = Math.max(maxRegion, size);
				}
			}
		}
		return maxRegion;
	}

	private static int getRegionSize(int[][] matrix, int rows, int cols) {
		if (rows < 0 || cols < 0 || rows >= matrix.length || cols >= matrix[rows].length) {
			return 0;
		}
		if (matrix[rows][cols] == 0) {
			return 0;
		}
		matrix[rows][cols] = 0;// added to avoid any kind of visited array
								// //making it 0 will keep it skipping for the
								// next ietrations
		int size = 1;
		for (int r = rows - 1; r <= rows + 1; r++) {
			for (int c = cols - 1; c <= cols + 1; c++) {
				size += getRegionSize(matrix, r, c);
			}
		}
		return size;
	}

	private static long sumContiguous(int a[]) {
		int size = a.length;
		long maxStart = Integer.MIN_VALUE, maxEnd = 0;
		for (int i = 0; i < size; i++) {
			maxEnd = maxEnd + a[i];
			if (maxStart < maxEnd) {
				maxStart = maxEnd;
			}
			if (maxEnd < 0) {
				maxEnd = 0;
			}
		}
		return maxStart;
	}

	static class Node {
		int data;
		Node next;
		Node prev;
	}

	static Node insertAtTail(Node head, int data) {
		if (head == null){
	        head = new Node();
	        head.data = data;
	    } else {
	        Node node = head;
	        while (node.next != null){
	            node = node.next;
	        }
	        node.next = new Node();
	        node.next.data = data;
	    }
	    return head;
	}
	static Node insertAtHead(Node head, int data){
		if(head == null){
			 head = new Node();
			 head.data = data;
		} else {
			Node newHead = new Node();
			newHead.data = data;
			newHead.next = head;
			head = newHead;
		}
		return head;
	}
	
	static Node InsertNth(Node head, int data, int position) {
	    Node node = new Node();
	    node.data = data;
	    if (position == 0) {
	    	node.next = head;
	        return node;
	    } else {
	        Node n = head;
	        for (int i = 0; i < position - 1; i++) {
	            n = n.next;
	        }
	        node.next = n.next;
	        n.next = node;
	        return head;
	    }
	}
	static Node Delete(Node head, int position) {
		  // Complete this method
		Node prev = head;
		if(position == 0){
			head = head.next;
			return head;
		}
		for(int i = 0; i< position-1;i++){
			prev = prev.next;
		}
		if(prev == null || prev.next == null){
			return null;
		}
			prev.next = prev.next.next;
			return head;
		}
	static Node reverse(Node head){
		if(head == null){
			return null;
		}
		Node prev = null;
		Node next = null;
		Node current = head;
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
	static Node reverseDLL(Node head){
		if(head == null){
			return head;
		}
		Node curr = head;
		Node next = null;
		Node prev = null;
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	static int compare(Node headA, Node headB){
		if((headA == null && headB!=null)  || (headB == null && headA !=null)){
			return 0;
		}
		while(headA!=null && headB!=null){
			if(headA.data != headB.data){
				return 0;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return 1;
	}

	static Node mergeList(Node headA, Node headB) {
		// This is a "method-only" submission.
		// You only need to complete this method requires extra space of O(n+m) where n and m are the sizes of two LLs.
		if (headA == null)
			return headB;
		if (headB == null)
			return headA;
		if (headA.data < headB.data) {
			headA.next = mergeList(headA.next, headB);
			return headA;
		} else {
			headB.next = mergeList(headB.next, headA);
			return headB;
		}
	}

	static Node getNode(Node head, int index) {
		if (index == 0) {
			return head;
		}
		Node node = head;
		int i = 0;
		while (node != null) {
			if (i == index) {
				return node;
			}
			node = node.next;
			i++;
		}
		return null;
	}
	static int getNodeFromTail(Node head , int n){
		Node prev = null;
	    Node curr = head;
	    Node next = null;
	    while(curr!=null){
	        next = curr.next;
	        curr.next =  prev;
	        prev = curr;
	        curr = next;
	    }
	    head = prev;
	    int i =0;
	    while(head!=null){
	        if(n == i){
	            return head.data;
	        }
	        head = head.next;
	        i++;
	    }
	    return i;
	}
	static Node RemoveDuplicates(Node head) {
		  // This is a "method-only" submission. 
		  // You only need to complete this method. 
		  //sorted elements in the head
			Map<Integer, Integer> map = new HashMap<>();
			Node curr = head;
			while(curr.next!=null){
				if(!map.containsKey(curr.data)){
					map.put(curr.data, curr.data);
				} else {
					//remove the current
					curr.next = curr.next.next;
				}
				curr = curr.next;
			}
			return head;

		}
	static int mergeNode(Node nodeA , Node nodeB){
		if(nodeA.next == nodeB.next){return nodeA.data;}
		while(nodeA.next!=null && nodeB.next!=null){
			if(nodeA.next == nodeB.next){
				return nodeA.next.data;
			}
			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}
		Node root = nodeA.next == null ? nodeA:nodeB;
		return root.data;
		
	}

	static void print(Node head) {
		System.out.println("------printinng list----");
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}
