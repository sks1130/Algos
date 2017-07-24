import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 */

/**
 * @author sachin.srivastava
 * @tek9g.blogspot.com
 * @github.com/sks1130/
 *
 */
public class Graph_BFS_DFS {

	private static int numberOfNodes;
	private static int[][] adjMatrix;
	private static boolean[] visited;

	public static void main(String[] args) {
		numberOfNodes   = 9 ;
		adjMatrix  = new int[numberOfNodes][numberOfNodes];
		visited = new boolean[numberOfNodes];
		adjMatrix = new int[][]{  { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  
                 { 1, 0, 0, 0, 0, 0, 0, 1, 0 },       
                 { 0, 0, 0, 1, 0, 1, 0, 1, 0 },  
                 { 1, 0, 1, 0, 1, 0, 0, 0, 0 },  
                 { 0, 0, 0, 1, 0, 0, 0, 0, 1 },  
                 { 0, 0, 1, 0, 0, 0, 1, 0, 0 },  
                 { 0, 0, 0, 0, 0, 1, 0, 0, 0 },  
                 { 0, 1, 1, 0, 0, 0, 0, 0, 0 },  
                 { 1, 0, 0, 0, 1, 0, 0, 0, 0 } };

		for (int i = 0; i < numberOfNodes; i++) {
			System.out.println(Arrays.toString(adjMatrix[i]));
		}
		BFS(0);
		DFS(0);
	}
	public static void BFS(int root){
		if(root >= numberOfNodes){
			System.out.println("input node is beyond range");
			return;
		}
		System.out.println("---BFS--------");
		Queue<Integer> queue = new LinkedList<>();
		queue.add(root);
		visited[root]  = true;
		System.out.println("visited node-->" + root + " ");
		while(queue.size()!=0){
			int head = queue.remove();
			int child = -1;
			while((child=getUnvisitedNode(head))!=-1){
				queue.add(child);
				visited[child] = true;
				System.out.println("visited node-->" + child + " ");
			}
		}
		clearAllVisitedNodes();
	}
	
	public static void DFS(int root){
		if(root >= numberOfNodes){
			System.out.println("input node is beyond range");
			return;
		}
		System.out.println("---DFS--------");
		Stack<Integer> stack = new Stack<>();
		stack.push(root);
		visited[root]  = true;
		System.out.println("visited node-->" + root + " ");
		while(!stack.isEmpty()){
			int head = stack.peek();
			int child = -1;
			if(( child = getUnvisitedNode(head))!=-1){
				stack.push(child);
				visited[child] = true;
				System.out.println("visited node-->" + child + " ");
			} else {
				stack.pop();
			}
		}
		clearAllVisitedNodes();
	}
	
	public static void clearAllVisitedNodes(){
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}
	
	public static int getUnvisitedNode(int n ){
		for (int i = 0; i < adjMatrix[n].length; i++) {
			if( adjMatrix[n][i] == 1 && !visited[i]){
				return i;
			}
		}
		return -1;
	}
}

