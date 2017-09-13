/**
 * 
 */
package trees;

/**
 * @author sachin
 * @problem : https://www.hackerrank.com/challenges/tree-preorder-traversal
 *
 */
public class PreOrderTraversal {

	/**
	 * @param args
	 */
	static class Node{
		int data;
		Node left;
		Node right;
	}

	static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}
	public static void main(String[] args) {

	}

}
