/**
 * 
 */
package expedia;

import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;

/**
 * @author sachin
 *
 */
public class VerticalSumOfBinaryTree {

	/**
	 * @param http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
	 *            Examples:
	 * 
	 *            1 / \ 2 3 / \ / \ 4 5 6 7 The tree has 5 vertical lines
	 * 
	 *            Vertical-Line-1 has only one node 4 => vertical sum is 4
	 *            Vertical-Line-2: has only one node 2=> vertical sum is 2
	 *            Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is
	 *            1+5+6 = 12 Vertical-Line-4: has only one node 3 => vertical
	 *            sum is 3 Vertical-Line-5: has only one node 7 => vertical sum
	 *            is 7
	 * 
	 *            So expected output is 4, 2, 12, 3 and 7
	 */
	public static void main(String[] args) {

		Node root = new Node(1, 0);
		addLeft(root, 2);
		addRight(root, 3);
		addLeft(root.left, 4);
		addRight(root.left, 5);

		addLeft(root.right, 6);
		addRight(root.right, 7);
		System.out.println(new Gson().toJson(root));
		printVerticalSums(root);

	}

	static void printVerticalSums(Node root) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		printVerticalSums(root, map);
		System.out.println(map);

	}

	static void printVerticalSums(Node root, Map<Integer, Integer> map) {
		if (root == null) {
			return;
		}
		printVerticalSums(root.left, map);
		int prev = map.get(root.hd) == null ? 0 : map.get(root.hd);
		map.put(root.hd, prev + root.data);
		printVerticalSums(root.right, map);
	}

	static class Node {
		public Node(int data, int hd) {
			this.data = data;
			this.hd = hd;
		}

		int data;
		int hd;
		Node left, right;
	}

	static void addLeft(Node root, int data) {
		root.left = new Node(data, root.hd - 1);//-1 is the horizontal axis towards left
	}

	static void addRight(Node root, int data) {
		root.right = new Node(data, root.hd + 1); //+1 horizontal axis towards right
	}
}
