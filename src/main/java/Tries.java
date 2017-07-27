import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


/**
 * @author sachin
 *
 */
public class Tries {
	private Node root;
	public Tries(){
		root = new Node();
	}
	class Node {
		HashMap<Character, Node> children;
		boolean end;
		public Node(){
			children = new HashMap<>();
			end = false;
		}
	}
	public static void main(String ... args){
		String line = "";
		Scanner input = null;
		try {
			input = new Scanner(System.in);
			line = input.nextLine();
			if(line == null || line.isEmpty()){
				System.out.println("invalid inout");
			}
			Double principal = Double.parseDouble(line);
			Integer interest = Integer.parseInt(input.nextLine()); 
			Integer year = Integer.parseInt(input.nextLine()); 
			Double simpleInterest = (principal*interest*year/100);
			System.out.println( Math.round(simpleInterest));
			input.close();
		} catch (Exception e) {
		}
	}

	private boolean search(String word) {
		Node crawl = root;
		int n = word.length();
		for(int i=0;i<n;i++){
			char ch = word.charAt(i);
			if(crawl.children.get(ch) == null){
				return false;
			}
			else {
				crawl = crawl.children.get(ch);
				if(i==n-1 && crawl.end){
					return true;
				}

			}
		}
		return false;
	}
	private void add(String word) {
		Node crawl = root;
		int n = word.length();
		for(int i=0;i<n;i++){
			char ch = word.charAt(i);
			if(crawl.children.containsKey(ch)){
				crawl = crawl.children.get(ch);
			} else {
				crawl.children.put(ch, new Node());
				Node temp = crawl.children.get(ch);
				if(i == n-1 ){
					temp.end = true;
				}
				crawl = temp;
			}
		}
	}
}
