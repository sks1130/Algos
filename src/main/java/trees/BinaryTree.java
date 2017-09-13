/**
 * 
 */
package trees;

import java.util.ArrayDeque;
import java.util.Queue;

import com.google.gson.Gson;

/**
 * @author sachin
 *
 */
class Node 
{
	int data;
	Node left, right;

	Node(int item) 
	{
		data = item;
		left = right = null;
	}
}

public class BinaryTree {

	Node root;

	/*
	 * Compute the "maxDepth" of a tree -- the number of nodes along the longest
	 * path from the root node down to the farthest leaf node.
	 */
	int maxDepth(Node node) {
		if (node == null)
			return -1;
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			return Math.max(lDepth, rDepth) + 1;
		}
	}
	static void topView(Node root){
		//1 2 5 3 4 6  --> 1 2 5 6
		//@hackerrank -- passes all the test case : https://www.hackerrank.com/challenges/tree-top-view?h_r=next-challenge&h_v=zen
		if(root == null) return;
		leftView(root.left);
        System.out.print(root.data+" ");
		rightView(root.right);
	}

	static void leftView(Node root) {
		if (root == null)
			return;
		leftView(root.left);
        System.out.print(root.data + " ");
	}

	static void rightView(Node root) {
		if (root == null)
			return;
         System.out.print(root.data + " ");
		rightView(root.right);
		
	}

	static void levelOrder(Node root) {
		// level wise left to right printing
		//LinkedList<Node> queue = new LinkedList<>();
		///***@problem :https://www.hackerrank.com/challenges/tree-level-order-traversal ****//
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node head = queue.remove();
			System.out.print(head.data + " ");
			Node left = head.left;
			if(left!=null){
				queue.add(left);
			}
			Node right = head.right;
			if(right!=null){
				queue.add(right);
			}
		}

	}

	static Node Insert(Node root, int value) {
		if (value > root.data) {
			Node right = Insert(root.right, value);
		} else {
			Node left = Insert(root.left, value);
		}
		return root;
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.right = new Node(2);
		tree.root.right.right = new Node(5);
		tree.root.right.right.left = new Node(3);
		tree.root.right.right.right = new Node(6);
		tree.root.right.right.left.left = new Node(4);

		System.out.println(new Gson().toJson(tree));
		//System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
		System.out.println("level order-->");
		levelOrder(tree.root);
	}
}
