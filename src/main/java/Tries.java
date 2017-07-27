import java.util.HashMap;


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
		Tries tr = new Tries();
		tr.add("dog");
		tr.add("doggy");
		System.out.println(tr.search("dogg"));
		System.out.println(tr.search("doggy"));
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
