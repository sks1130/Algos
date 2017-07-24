import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class Graph_BFS_DFS {

	private static int numberOfNodes;
	private static int[][] adjMatrix;
	private static boolean[] visited;

	public static void main(String[] args) {
		numberOfNodes   = 9 ;
		//adjMatrix  = new int[numberOfNodes][numberOfNodes];
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
	}
	public static void BFS(int root){
		if(root >= numberOfNodes){
			System.out.println("input node is beyond range");
		}
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
