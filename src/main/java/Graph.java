import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sachin
 *
 */
@SuppressWarnings("unchecked")
public class Graph {
	
	private int v;//number of vertices 
	private LinkedList<Integer> adj[];
	Graph(int v) {
		if(v < 0){
			System.out.println("Invalid vertex number");
			return;
		}
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
    void addEgde(int vertex , int egde){
    	adj[vertex].add(egde);
    }
    
    void BFS(int source){
    	//traversing the nodes from the source.
    	boolean visited[]  = new boolean[v];
    	LinkedList<Integer> queue = new LinkedList<>();
    	visited[source] = true;
    	queue.add(source);
    	while (queue.size()!=0) {
			source = queue.poll();
			System.out.print(source + " ");
			Iterator<Integer> it = adj[source].listIterator();
			if(it.hasNext()){
				int n = it.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
					
		}
    }
    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.addEgde(0, 1);
        graph.addEgde(0, 2);
        graph.addEgde(1, 2);
        graph.addEgde(2, 0);
        graph.addEgde(2, 3);
        graph.addEgde(3, 1);
        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
        graph.BFS(1);
	}
    
    class Node{
    	private Integer value;
    	boolean visited;
    	Node(int val){
    		this.value = val;
    	}
    }
    
    public static void  bfs(Node root){
    	if(root == null || root.value == null){
    		System.out.println("no root node is selected or root node value is null");
    		return ;
    	}
    	//get  queue
    	Queue<Node>  queue = new LinkedList<>();
    	queue.add(root);
    	root.visited = true;
    	System.out.print( root.value + " ");
    	
    }
    public static void printNode(Node node){
    	
    }
}
