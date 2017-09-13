/**
 * 
 */

/**
 * @author sachin
 * @problem : https://www.hackerrank.com/challenges/binary-search-tree-insertion
 *
 */
public class BinarySearchTree {

	static Node Insert(Node root, int value) {
		if(root == null){
			root = new Node();
			root.data = value;
			return root;
		}
		if(root.data > value){
			root.left = Insert(root.left, value);
		} else {
			root.right = Insert(root.right, value);
		}
		return root;
	}

	public static void main(String[] args) {

	}

	static class Node {
		int data;
		Node left;
		Node right;
	}
}
