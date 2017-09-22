/**
 * @problem : https://www.hackerrank.com/challenges/swap-nodes-algo
 */

/**
 * @author sachin
 *
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwapBinaryNode {

    static class Node{
       public Node(int data , int depth){
            this.data = data;
            this.depth = depth;
        }
        int data;
        int depth;
        Node left;
        Node right;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] childs = new int[n][2];//total number of nodes and each node has two childs
        for(int i =0;i<n;i++){
            childs[i][0] = scan.nextInt();
            childs[i][1] = scan.nextInt();
        }
        Node root = createTree(childs);
        int q = scan.nextInt();
        while(q-- > 0){
            int d = scan.nextInt();
            swap(root , d);
            printInOrder(root);
            System.out.println();
        }
        scan.close();
        
    }
    public static void printInOrder(Node root){
        if(root!=null){
            printInOrder(root.left);
            System.out.print(root.data + " ");
             printInOrder(root.right);
        }
    }
    public static void swap(Node root , int d){
        if(root!=null){
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node head = queue.remove();
                if(head.depth%d == 0){
                    Node tmp = head.left;
                    head.left = head.right;
                    head.right = tmp;
                }
                if(head.left!=null){
                    queue.add(head.left);
                }
                if(head.right!=null){
                    queue.add(head.right);
                }
            }
        }
    }
    public static Node createTree(int[][] childs){
        Node root = new Node(1,1);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        int i =0;
        while(!queue.isEmpty()){
            Node head = queue.remove();
            int depth = head.depth +1;
            if(childs[i][0]!=-1){
                Node newNode = new Node(childs[i][0],depth);
                head.left = newNode;
                queue.add(newNode);
            }
            if(childs[i][1]!=-1){
                Node newNode = new Node(childs[i][1],depth);
                head.right = newNode;
                queue.add(newNode);
            }
            i++;
        }
         return root;
    }
   
}