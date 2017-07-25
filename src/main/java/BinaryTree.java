import java.util.Stack;


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
		System.out.println("--------------------");
		preOrderTraversalWithRecursion(root);
		System.out.println("--------------------");
		postOrderTraversalWithRecursion(root);
		System.out.println("--------------------");
		inOrderTraversalWithRecursion(root);
		System.out.println("--------------------");
		System.out.println("-----height of tree=" + height(root));
		System.out.println("--------------------");
		printLevelOrder(root);
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
	}
	
	public static void postOrderTraversalWithRecursion(Node root) { 
		if(root == null){
			return;
		}
		if(root.left !=null){
			postOrderTraversalWithRecursion(root.left);
		}
		if(root.right !=null){
			postOrderTraversalWithRecursion(root.right);
		}
		System.out.println(" postOrderTraversalWithRecursion node-->" + root.value);
		
	}
	
	public static void preOrderTraversalWithRecursion(Node root) { 
		if(root == null){
			return;
		}
		System.out.println(" preOrderTraversalWithRecursion node-->" + root.value);
		if(root.left !=null){
			preOrderTraversalWithRecursion(root.left);
		}
		if(root.right !=null){
			preOrderTraversalWithRecursion(root.right);
		}
		
	}
	
	public static void inOrderTraversalWithRecursion(Node root) { 
		if(root == null){
			return;
		}
		if(root.left !=null){
			inOrderTraversalWithRecursion(root.left);
		}
		System.out.println(" inOrderTraversalWithRecursion node-->" + root.value);
		if(root.right !=null){
			inOrderTraversalWithRecursion(root.right);
		}
		
	}
	
	public static int height(Node root){
		if(root == null){
			return 0;
		} else {
			int heightLeft = height(root.left);
			int rightLeft  = height(root.right);
			if(heightLeft > rightLeft){
				return heightLeft +1 ;
			} else {
				return rightLeft +1 ;
			}
		}
	}
	public static void printGivenLevelOrder(Node root , int level){
		if(root == null || (level < 1)){
			return;
		}
		if(level == 1 ){
			System.out.println("node=" + root.value);
		} else {
			printGivenLevelOrder(root.left, level-1);
			printGivenLevelOrder(root.right, level-1);
		}
	}
	
	public static void printLevelOrder(Node root){
		if(root == null){
			return;
		}
		int height = height(root);
		for (int i = 1; i <= height; i++) {
			printGivenLevelOrder(root, i);
		}
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
