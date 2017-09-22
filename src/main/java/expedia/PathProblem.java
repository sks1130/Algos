/**
 * 
 */
package expedia;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sachin
 * @problem : 
 * Given coordinates of a source point (x1, y1) determine if it is possible to reach 
 * the destination point (x2, y2). From any point (x, y) there only two types of valid movements:
(x, x + y) and (x + y, y). Return a boolean true if it is possible else return false.
 *
 */
public class PathProblem {

	/**
	 * @param : http://www.geeksforgeeks.org/check-destination-reachable-source-two-movements-allowed/
	 * Input : (x1, y1) = (2, 10)
        (x2, y2) = (26, 12)
		Output : True
		(2, 10)->(2, 12)->(14, 12)->(26, 12) 
		is a valid path.
		
		Input : (x1, y1) = (20, 10)
		        (x2, y2) = (6, 12)
		Output : False
		No such path is possible because x1 > x2
		and coordinates are positive
		Test : 
		int x1 = 2, y1 = 10;
	    int x2 = 2600, y2 = 1200;
	    false
		hasPath : total ms=3
		false
		pathExist : total ms=151  -- //@comment : this is slower though seems that that with the 
									recursive call would be costlier but it not the case which for 
									// int x2 = 26000, y2 = 12000; goes into hang state

		
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x1 = 2, y1 = 10;
	    int x2 = 26000, y2 = 12000;
	    long start = System.currentTimeMillis();
	    System.out.println(hasPath(x1, y1, x2, y2));
	    long end = System.currentTimeMillis();
	    System.out.println("hasPath : total ms=" + (end-start));
	    
	    System.out.println(pathExist(x1, y1, x2, y2));
	      end = System.currentTimeMillis();
	    System.out.println("pathExist : total ms=" + (end-start));
	}
	static boolean  hasPath(int x1 , int y1 , int x2 , int y2){
		//better and clean solution and perform better ...goes to stack overflow if number of call are veery
		if(x1 > x2 || y1 > y2){
			return false;
		}
		if(x1 == x2 && y1 == y2){
			return true;
		}
		return hasPath(x1, x1+y1, x2, y2) || hasPath(x1+y1, y1, x2, y2);
	}

	static boolean pathExist(int x1, int y1, int x2, int y2) {
		Node node = new Node(x1, y1);
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		HashSet<Node> visited = new HashSet<>();
		visited.add(node);
		while (!queue.isEmpty()) {
			Node head = queue.remove();
			if (head.x > x2 || head.y > y2) {
				continue;
			}
			if (head.x == x2 && head.y == y2) {
				return true;
			}
			Node first = new Node(head.x, head.x + head.y);
			Node second = new Node(head.x + head.y, head.y);
			if(!visited.contains(first)){
				queue.add(first);
				visited.add(first);
			}
			if(!visited.contains(second)){
				queue.add(second);
				visited.add(second);
			}
		}
		return false;
	}
	static class Node{
		int x ;
		int y;
		public Node(int x , int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

}
