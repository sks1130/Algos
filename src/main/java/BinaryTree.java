import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;


/**
 * @author sachin
 *
 */
public class BinaryTree {

	static Node root;

	// driver program to test above functions
	public static void main(String args[]) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("--------------------");
		preOrderTraversalWithRecursion(root);
		System.out.println("--------------------");
		postOrderTraversalWithRecursion(root);
		System.out.println("--------------------\n");
		inOrderTraversalWithRecursion(root);
		System.out.println("--------------------");
		System.out.println("\n-----height of tree=" + height(root));
		System.out.println("\n-------Level Order traversal-----------\n");
		printLevelOrder(root);
		System.out.println("\nSpiral order traversal of Binary Tree is\n ");
		levelOrderSpiralTraversal(root);
		System.out.println("-----all the leaf nodes------");
		printLeafNodes(root);
		System.out.println("-----all the paths frm root to leaf nodes------");
		printAllPathsRootToLeaf(root, null);
		System.out.println("-----max value in the tree------");
		System.out.println(maxNodeInTree(root));
		System.out.println("---findLCA--------");
		System.out.println(findLCA(root, 5, 4).value);
		System.out.println("\n---printBoundaryNodes--------\n");
		printBoundaryNodes(root);
		System.out.println("\n-------verticalSums-----\n");
		verticalSums(root);
	}

	public static void verticalSums(Node root) {
		if (root == null) {
			System.out.println("vertical sum=" + 0);
		}
		// for the left node level l-- and //for the right node l++
		Map<Integer, Integer> verticalSumMap = new HashMap<>();
		verticalSums(root, root.level, verticalSumMap);
		for (Entry<Integer, Integer> entry : verticalSumMap.entrySet()) {
			System.out.println("level=" + entry.getKey() + " and sum=" + entry.getValue());
		}

	}

	public static void verticalSums(Node root, int level, Map<Integer, Integer> levelMap) {
		if (root == null) {
			return;
		}
		// for the left node level l-- and //for the right node l++
		verticalSums(root.left, level - 1, levelMap);
		if (levelMap.get(level) == null) {
			levelMap.put(level, root.value);
		} else {
			levelMap.put(level, levelMap.get(level) + root.value);
		}
		verticalSums(root.right, level + 1, levelMap);
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
		if (root == null) {
			return;
		}
		if (root.left != null) {
			postOrderTraversalWithRecursion(root.left);
		}
		if (root.right != null) {
			postOrderTraversalWithRecursion(root.right);
		}
		System.out.println(" postOrderTraversalWithRecursion node-->" + root.value);

	}

	public static void preOrderTraversalWithRecursion(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(" preOrderTraversalWithRecursion node-->" + root.value);
		if (root.left != null) {
			preOrderTraversalWithRecursion(root.left);
		}
		if (root.right != null) {
			preOrderTraversalWithRecursion(root.right);
		}

	}

	public static void inOrderTraversalWithRecursion(Node root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			inOrderTraversalWithRecursion(root.left);
		}
		System.out.println(" inOrderTraversalWithRecursion node-->" + root.value);
		if (root.right != null) {
			inOrderTraversalWithRecursion(root.right);
		}

	}

	public static int height(Node root) {
		if (root == null) {
			return 0;
		} else {
			int heightLeft = height(root.left);
			int rightLeft = height(root.right);
			if (heightLeft > rightLeft) {
				return heightLeft + 1;
			} else {
				return rightLeft + 1;
			}
		}
	}

	public static void printGivenLevelOrder(Node root, int level) {
		if (root == null || (level < 1)) {
			return;
		}
		if (level == 1) {
			System.out.println("node=" + root.value);
		} else {
			printGivenLevelOrder(root.left, level - 1);
			printGivenLevelOrder(root.right, level - 1);
		}
	}

	public static void printGivenLevelOrderSpiral(Node root, int level, boolean ltr) {
		if (root == null || (level < 1)) {
			return;
		}
		if (level == 1) {
			System.out.println("node=" + root.value);
		} else {
			if (ltr) {
				printGivenLevelOrderSpiral(root.left, level - 1, ltr);
				printGivenLevelOrderSpiral(root.right, level - 1, ltr);
			} else {
				printGivenLevelOrderSpiral(root.right, level - 1, ltr);
				printGivenLevelOrderSpiral(root.left, level - 1, ltr);
			}
		}
	}

	public static void printLevelOrder(Node root) {
		if (root == null) {
			return;
		}
		int height = height(root);
		for (int i = 1; i <= height; i++) {
			printGivenLevelOrder(root, i);
		}
	}

	public static void levelOrderSpiralTraversal(Node root) {
		if (root == null) {
			return;
		}
		int height = height(root);
		boolean ltr = false;
		;
		for (int i = 1; i <= height; i++) {
			printGivenLevelOrderSpiral(root, i, ltr);
			ltr = !ltr;
		}

	}

	public static void printLeafNodes(Node root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.println("leaf node-->" + root.value);
		}
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}

	public static void printAllPathsRootToLeaf(Node root, Node parent) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			while (root != null) {
				System.out.print(root.value + " ");
				root = root.parent;
			}
			System.out.println();
			return;
		}
		root.left.parent = root;
		root.right.parent = root;
		parent = root;
		printAllPathsRootToLeaf(root.left, parent);
		printAllPathsRootToLeaf(root.right, parent);
	}

	public static int maxNodeInTree(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int max = root.value;
		if (root.left != null) {
			max = Math.max(max, maxNodeInTree(root.left));
		}
		if (root.right != null) {
			max = Math.max(max, maxNodeInTree(root.right));
		}
		return max;
	}

	public static Node findLCA(Node root, int start, int end) {
		if (root == null) {
			return null;
		}
		if (root.value == start || root.value == end) {
			return root;
		}
		Node left = findLCA(root.left, start, end);
		Node right = findLCA(root.right, start, end);
		if (left != null && right != null) {
			return root;
		}

		return (left != null) ? left : right;
	}

	public static void printBoundaryNodes(Node root) {
		if (root == null) {
			return;
		}
		System.out.println("root node-->" + root.value);
		printLeftBoundaryNodes(root.left);
		printLeafNodes(root);
		printRightBoundaryNodes(root.right);
	}

	public static void printLeftBoundaryNodes(Node root) {
		if (root != null) {
			if (root.left != null) {
				System.out.println("left boundary node-->" + root.value);
				printLeftBoundaryNodes(root.left);
			} else if (root.right != null) {
				System.out.println("left boundary node-->" + root.value);
				printLeftBoundaryNodes(root.right);
			}
		}
	}

	public static void printRightBoundaryNodes(Node root) {
		if (root != null) {
			if (root.right != null) {
				System.out.println("right boundary node-->" + root.value);
				printRightBoundaryNodes(root.right);
			} else if (root.left != null) {
				System.out.println("right boundary node-->" + root.value);
				printRightBoundaryNodes(root.left);
			}
		}
	}

	static class Node {
		int value;
		int level;
		Node left;
		Node right;
		Node parent;

		Node(int val) {
			this.value = val;
			right = left = parent = null;
		}
	}
}
