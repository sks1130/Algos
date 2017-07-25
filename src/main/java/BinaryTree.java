import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class BinaryTree{

	static Node root;

	// driver program to test above functions
	public static void main(String args[]) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		preOrderTraversal(root);

	}

	public static void preOrderTraversal(Node root) {
		if (root == null) {
			System.out.println("root node is null");
			return;
		}
		System.out.println("PreOrder traversal in Binary tree with the root node=" + root.value);
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node top = stack.peek();
			stack.pop();
			System.out.println("node=" + top.value);
			if (top.right != null) {
				stack.push(top.right);
			}
			if (top.left != null) {
				stack.push(top.left);
			}
		}
	}
	
	public static void postOrderTraversal(Node root) {
		if (root == null) {
			System.out.println("root node is null");
			return;
		}
		System.out.println("PostOrder traversal in Binary tree with the root node=" + root.value);
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		//todo need to write the post traversal
	}

	static class Node {
		int value;
		Node left;
		Node right;
		Node(int val) {
			this.value = val;
			right = left = null;
		}
	}

}
