/**
 * 
 */
package trees;

import java.util.List;

/**
 * @author sachin
 *
 */
public class BinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

	static Node lca(Node root, int v1, int v2) {
		if(root == null){
			return root;
		}
        if(root.data == v1 || root.data == v2){
            return root;
        }
		if (Math.max(v1, v2) >= root.data && Math.min(v1, v2) <= root.data) {
			return root;  //if root is lying between v1 & v2 
		}
		Node left = lca(root.left, v1, v2);
		Node right = lca(root.right, v1, v2);
        if(left!=null && right!=null){
        	//if both the trees have node present then root node is the LCA
            return root;
        }
            return (left!=null) ? left : right; // either left or right would have LCA

	}
	static class Node{
		int data;
		Node left;
		Node right;
		
	}
	static boolean checkBST(Node root){
		return checkBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	static boolean checkBST(Node root , int min , int max){
		if(root == null){
			return true;
		}
		if(root.data < min || root.data > max){
			return false;
		}
		return checkBST(root.left, min, root.data-1) && checkBST(root.right, root.data+1, max); 
	}
}
