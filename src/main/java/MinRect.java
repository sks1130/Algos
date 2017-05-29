import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class MinRect {

public static int homesteadThatDefinesANewLivingPlanet(int input1,int input2,int input3,int input4,int[][] input5)
{
	if((1>input1 || input1> 250) || (1>input2 || input2> 250) ||  (2>input3 || input3>5000) ||  (1>input4 || input4>2500) || input5.length!=input3){
		return 0;
	}
	List<Node> nodes = new ArrayList<>();
	Arrays.parallelSort(input5, (a, b) -> Integer.compare(a[0], b[0]));
	for(int i=0;i < input5.length;i++){
		int[] arrInt = input5[i];
		Node node = new Node(arrInt[0],arrInt[1]);
		nodes.add(node);
	}
	List<String> rects = findAllValidRect(nodes);
	int min = 0;
	for(String rect  :rects){
		System.out.println(rect.split(",")[3]);
		int perimeter = Integer.parseInt(rect.split(",")[3].replaceAll("perimeter=", ""));
		if(min == 0){
			min = perimeter;
		}
		if(min > perimeter){
			min = perimeter;
		}
	}
	String rectString = null;
	for(String rect  :rects){
		int perimeter = Integer.parseInt(rect.split(",")[3].replaceAll("perimeter=", ""));
		if(min == perimeter){
			rectString = rect;
			break;
		}
	}
	System.out.println("min rect=" + rectString);
	String node1 = rectString.split(",")[0];
	String node2 = rectString.split(",")[0];
	String node3 = rectString.split(",")[0];
	return min;
}
    
    public static int peremeter(Rect rect){
        Node a = rect.a;
         Node b = rect.b;
          Node c = rect.c;
          int  l = Math.max(Math.abs(a.x- b.x), Math.abs(b.x- c.x))+1;
          int  w =  Math.max(Math.abs(a.y- b.y), Math.abs(b.y- c.y))+1;
          return 2*(l+w);
    }
    public static List<String> findAllValidRect(List<Node> nodes){
        if(nodes == null || nodes.isEmpty()){
            return null;
        }
        int nodeSize = nodes.size();
        List<String> recList = new ArrayList<>();
        for(int i= 0; i< nodeSize;i++){
        	for(int j=i+1;j<nodeSize-1;j++){
        		for(int k=j+1;k<nodeSize;k++){
        			Node node1 = nodes.get(i);
        			Node node2 = nodes.get(j);
        			Node node3 = nodes.get(k);
        			recList.add("node" + (i+1) + ","+ "node" + (j+1) + "," + "node" + (k+1)+ ",perimeter=" + peremeter(new Rect(node1, node2, node3, true)));
        		}
        	}
        }
        return recList;
    }
    static class Rect{
        Node a;
        Node b;
        Node c;
        boolean visited;
       
        Rect(Node a , Node b,Node c,boolean visited){
            this.a = a;
            this.b = b;
            this.c = c;
            this.visited = visited;
        }
    }
    static class Node{
        int x;
        int y;
        Node(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
    	int[][] arr = {{3,4},{3,3},{6,1},{1,1},{5,5},{5,5},{3,1}};
    	System.out.println(homesteadThatDefinesANewLivingPlanet(6, 5, 7, 3, arr));
    }
}
