import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sachin.srivastava
 * tek9g.blogspot.com
 *
 */
public class KnightChess {
	
	public static int  traverseCount(Node start , Node end){
		if(start ==null || end == null || (start.x == end.x && start.y == end.y) ){
			return 0;
		} 
		List<Node> visitedNodes = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		start.visited = true;
		queue.add(start);
		int minMoves = 0;
		while (!queue.isEmpty()) {
			Node head = queue.poll();
			if(head.x < 1 || head.x > 8 || head.y <1 || head.y > 8 ){
				continue;
			}
			if(head.x == end.x && head.y == end.y){
				head.visited = true;
				break;
			}
			List<Node> adjNodes = adjNodes(head, visitedNodes, end);
			int count = printVisitedNodes(adjNodes,end,head);
			if(count > 0){
				if(minMoves <= count -1){
					minMoves = count-1;
				}
			}
			for (Node node : adjNodes) {
				if(!node.visited){
					queue.add(node);
					node.visited = true;
				}
			}
		}
		return minMoves;
	}
	public static int printAllNodes(Node node, int count){
		if(node == null){
			System.out.print("\n");
			return count;
		}
		count++;
		System.out.print( "("+ node.x + "," +node.y + ")" + " ");
		return printAllNodes(node.parent,count);
	}
	public static int printVisitedNodes(List<Node> visitedNodes,Node end,Node parent){
		if(visitedNodes!=null && !visitedNodes.isEmpty()){
			for (Node node : visitedNodes) {
				if(matchEndNode(node, end)){
					return printAllNodes(node,0);
				}
			}
		}
		return 0;
	}
	public  static boolean nodeVisited(Node node,List<Node> visitedNodes,Node end ){
		boolean flag = false;
		if(node.x <1 || node.x >8 || node.y <1 || node.y >8 || (node.x == 1 && node.y == 1 || node.x==8 && node.y==8)) {
			node.visited = true;
			return true;
		}
		if(node!=null && !node.visited && visitedNodes!=null && !visitedNodes.isEmpty()){
			for (Node node2 : visitedNodes) {
				if(node2.x == node.x && node2.y == node.y ){
					node.visited = true;
					node2.visited = true;
					flag= true;
					break;
				}
			}
		}
		return flag;
	}
	public static boolean matchEndNode(Node start, Node end){
		if(start.x== end.x && start.y == end.y){
			return true;
		}
		return false;
	}
	public static List<Node> adjNodes(Node start , List<Node> visitedNodes,Node end){
		int x = start.x;
		int y = start.y;
		Node parent = start;
		List<Node> adjNodes = new ArrayList<>();
		if(!nodeVisited(new Node(x+2, y+1,parent), visitedNodes,end)){
			adjNodes.add(new Node(x+2, y+1,parent));
			if(matchEndNode(new Node(x+2, y+1,parent), end)){
				return adjNodes;
			}
		}
		if(!nodeVisited(new Node(x+2, y-1,parent), visitedNodes,end)){
			adjNodes.add(new Node(x+2, y-1,parent));
			if(matchEndNode(new Node(x+2, y-1,parent), end)){
				return adjNodes;
			}
		}
		if(!nodeVisited(new Node(x+1, y+2,parent), visitedNodes,end)){
			adjNodes.add(new Node(x+1, y+2,parent));
			if(matchEndNode(new Node(x+1, y+2,parent), end)){
				return adjNodes;
			}
		}
		if(!nodeVisited(new Node(x-1, y+2,parent), visitedNodes,end)){
			adjNodes.add(new Node(x-1, y+2,parent));
			if(matchEndNode(new Node(x-1, y+2,parent), end)){
				return adjNodes;
			}
		}
		if(x > end.x){
			if(!nodeVisited(new Node(x-2, y+1,parent), visitedNodes,end)){
				adjNodes.add(new Node(x-2, y+1,parent));
				if(matchEndNode(new Node(x-2, y+1,parent), end)){
					return adjNodes;
				}
			}
			if(!nodeVisited(new Node(x-2, y-1,parent), visitedNodes,end)){
				adjNodes.add(new Node(x-2, y-1,parent));
				if(matchEndNode(new Node(x-2, y-1,parent), end)){
					return adjNodes;
				}
			}
		}
		if(y > end.y){
			if(!nodeVisited(new Node(x+1, y-2,parent), visitedNodes,end)){
				adjNodes.add(new Node(x+1, y-2,parent));
				if(matchEndNode(new Node(x+1, y-2,parent), end)){
					return adjNodes;
				}
			}
			if(!nodeVisited(new Node(x-1, y-2,parent), visitedNodes,end)){
				adjNodes.add(new Node(x-1, y-2,parent));
				if(matchEndNode(new Node(x-1, y-2,parent), end)){
					return adjNodes;
				}
			}
		}
		return adjNodes;
	}

	static class Node{
		int x;
		int y;
		Node parent;
		boolean visited;
		public Node(int x , int y, Node parent) {
			this.x = x;
			this.y = y;
			this.parent = parent;
		}
	}
	public static void main(String[] args) {
		Node start = new Node(1, 1,null);
		Node end = new Node(8,8,null);
		System.out.println("Minimum moves for knight="+ traverseCount(start, end));
	}
}
