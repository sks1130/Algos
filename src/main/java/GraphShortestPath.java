/**
 * @author sachin.srivastava
 * @hackerranks pass 100 % cases https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
 * shortest path to get BFS is designed for it and its a nice implementation of it. 
 *
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphShortestPath {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        for(int i = 0;i < q ; i++){
            int n = scan.nextInt();
            int m = scan.nextInt();
            Graph graph = new Graph(n);
            for(int j =0 ; j < m ; j++){
                int e1 = scan.nextInt();
                int e2 = scan.nextInt();
                graph.addEdges(e1 , e2);
            }
            int start = scan.nextInt();
            graph.getDistance(graph.nodes[start]);
            for (int k = 1; k <= n; k++) {
                if (k != start) {
                    System.out.print(graph.nodes[k].distance + " ");
                }
            }
            System.out.println();
        }
    }
   static  class Graph {
         Node[] nodes;
         private static final int EDGE_DISTANCE = 6;
        Graph(int n){
            nodes = new Node[n+1];
            for(int i=1; i<=n ; i++ ){
                nodes[i] = new Node(i);
            }
        }
    	class Node {
    		int data;
    		HashSet<Node> adjacent;
            int distance = -1;
    		Node(int data) {
    			this.data = data;
                adjacent = new HashSet<>();
    		}
    	}

    	private void addEdges(int src, int dest) {
    		Node s = nodes[src];
            Node d = nodes[dest];
    		s.adjacent.add(d);
    		d.adjacent.add(s);
    	}

    	private void getDistance(Node src) {
            if(src == null){
                return;
            }
			LinkedList<Node> queue = new LinkedList<>();
			queue.add(src);
            src.distance = 0;
			while (!queue.isEmpty()) {
				Node node = queue.poll();;
				for (Node child : node.adjacent) {
					if (child.distance == -1) {
						child.distance = node.distance + EDGE_DISTANCE;
						queue.add(child);
					}
				}
			}
		}
    }
}


