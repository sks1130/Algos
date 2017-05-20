import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class AppearenceCount {
	static class Node{
		int x;
		int y;
		boolean visited;
		 Node(int x, int y, boolean visit) {
			this.x = x;
			this.y = y;
			this.visited = visit;
		}
	}
	public static List<Node> adjacentNodes(int x , int y){
		List<Node> nodeList = new ArrayList<>();
		nodeList.add(new Node(x+2, y+1, false));
		nodeList.add(new Node(x+2, y-1, false));
		nodeList.add(new Node(x-2, y+1, false));
		nodeList.add(new Node(x-2, y-1, false));
		nodeList.add(new Node(x+1, y+2, false));
		nodeList.add(new Node(x-1, y+2, false));
		nodeList.add(new Node(x+1, y-2, false));
		nodeList.add(new Node(x-1, y-2, false));
		return nodeList;
	}
	public static List<Node> traverse(Node start, Node end,List<Node> nodes ){
		if(nodes == null){
			nodes = new ArrayList<>();
		}
		if(start.x == end.x && start.y == end.y ){
			System.out.println("---End node found with nodeList--" + nodes.size());
			return nodes;
		} else if(start.x < 1 || start.x > 9 || start.y < 1 || start.y > 9){
			return null;
		} else if((start.x == 9 && start.y == 9) || (start.x == 0 && start.y == 0) ){
			return null;
		}
		nodes.add(start);
		List<Node> adjacentNodes = adjacentNodes(start.x, start.y);
		for (Node node : adjacentNodes) {
			node.visited = true;
			List<Node> startNodeList = new ArrayList<>();
			startNodeList.add(node);
			List<Node> nodeList = traverse(node, end, startNodeList);
			if(nodeList!=null && !nodeList.isEmpty()){
				System.out.println("start node x=" + node.x + " and y=" + node.y + " and nodeList size=" + nodeList.size());
			}
		}
		return adjacentNodes;
	}
	 
	 public static List<Node> getAllNodes(int x1 , int y1 ,int x2, int y2){
		return null;
		 
	 }

	public static int appearanceCount(int input1,int input2,String input3,String input4){ 
		int count = 0;
		if(input3 == null || input3.isEmpty() || input4 ==null || input4.isEmpty()){
			return count;
		} else if(input1 != input3.length() || (input2!=input4.length())){
			return count;
		}
		for (int i = 0; i < input2; i++) {
			if( (i+input1) > input2){
				break;
			}
			String subStr = input4.substring(i,i+input1);
			if(compareStrings(input3, subStr)){
				count++;
			}
		}
		return count;
	}

	public static boolean compareStrings(String s1 , String s2){
		if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty() || (s1.length()!=s2.length())){
			return false;
		}
		char[] s1CharArr = s1.toCharArray();
		char[] s2CharArr = s2.toCharArray();
		Arrays.parallelSort(s1CharArr);
		Arrays.parallelSort(s2CharArr);
		return new String(s1CharArr).equals(new String(s2CharArr));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(jumpCount(5, 2, 10, 0));
		//int[][] nArray = {{1,2,3,4},{3,4,1,2},{2,1,4,3},{4,3,2,1}}; //4 x4 //magical sqaure
		//		int[][] nArray = {
		//				{1,2,3,0,0,0,0,0,0},
		//				{0,0,0,0,0,0,1,2,3},
		//				{0,0,0,1,2,3,0,0,0},
		//				{2,3,1,0,0,0,0,0,0},
		//				{0,0,0,0,0,0,2,3,1},
		//				{0,0,0,2,3,1,0,0,0},
		//				{3,1,2,0,0,0,0,0,0},
		//				{0,0,0,0,0,0,3,1,2},
		//				{0,0,0,3,1,2,0,0,0}
		//
		//		};//magical sqaure

		/*Arrays.sort(nArray, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}

		});*/
		//sort2DArray(nArray);
		//System.out.println(compressString("abbrrrrtttttgggaaawwww"));
		List<String> players = new ArrayList<>();
		players.add("Ricky");
		players.add("Sachin");
		players.add("Dilshan");
		players.add("ABD");
		players.add("Virat");
		players.add("MSD");
		players.add("Adam");
		players.add("Amla");
		players.add("Duplesis");
		players.add("Gayle");
		players.add("Brandon");
		players.add("Guptil");
		//System.out.println(extractContent("/Users/sachin/Desktop/test11.txt"));

		int[] arr1  = {1,3,6,4,8,90,133};
		int[] arr2  = {2,3,1,17,18};
		int[] arr3  = {4,5,6,8,11};
		int[] arr4  = {125,9,10,13,34};
		int[] arr = new int[arr1.length + arr2.length + arr3.length + arr4.length];
		PriorityBlockingQueue<Integer> prq = new PriorityBlockingQueue<>();
		for (int i = 0; i < arr.length; i++) {
			if(i<arr1.length){
				prq.add(arr1[i]);
			}
			if(i<arr2.length){
				prq.add(arr2[i]);
			}
			if(i<arr3.length){
				prq.add(arr3[i]);
			}
			if(i<arr4.length){
				prq.add(arr4[i]);
			}
		}
		/*Random random = new Random();
		for (int i = 0; i < 50; i++) {
			int rand = random.nextInt(50);
			System.out.print(rand +" ");
			prq.add(rand);
			
		}
		System.out.println("------ ");*/
		while (!prq.isEmpty()) {
			System.out.print(prq.poll()+" ");
		}
		System.out.println(Boolean.getBoolean("true"));
	}
	
	public static String extractContent(String filename){
		String email ="";
		String name = "";
		String contactNumber = "";
		String[] contArr = null;
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				if(!(line.contains("CURRICULUM") || line.contains("Curriculam")|| line.contains("RESUME") || line.contains("CV"))){
					if(line.contains("91") || line.contains("91-") || line.contains("Mob") || line.contains("Contact") || line.contains("Phone") || line.contains("Mobile") || line.contains("Home") || line.contains("Cell")){
						String contact = line.replaceAll("-|:|91", " ");
						if(contArr == null || contArr.length == 0){
							contArr = contact.split(" ");
						}
					} 
					if(!line.isEmpty()){
						sb.append(line);
						sb.append(System.lineSeparator());
					}
				}
				line = br.readLine();
			}
			String everything = sb.toString();
			String[] words = everything.replaceAll("\t|\n|\r", " ").split(" ");
			int wordsLength = words.length;
			int j = 0;
			for (int i = 0; i < wordsLength-1; i++) {
				if(words[i]!=null && words[i]!="" && !words[i].trim().isEmpty() && words[i+1]!=null && words[i+1]!="" && !words[i+1].trim().isEmpty()){
					if(Character.isLetter(words[i].charAt(0)) && Character.isLetter(words[i+1].charAt(0))  &&  Character.isUpperCase(words[i].charAt(0)) && Character.isUpperCase(words[i+1].charAt(0))){
						name = words[i]  + " " + words[i+1];
						j = i+2;
						break;
					}
				}
			}
			StringBuilder sbContent = new StringBuilder();
			for (int i = j; i < wordsLength-1; i++) {
				if(words[i]!=null && words[i]!="" && !words[i].trim().isEmpty()){
					if(words[i].contains("@")){
						email = words[i];
						break;
					} else {
						sbContent.append(words[i]);
						sbContent.append("###");
					}
				} 
			}
			String[] contact = sbContent.toString().split("###");
			if(contact == null || contact.length == 0 || email!=null){
				contact = contArr;
			}
			if(contact!=null && contact.length>0){
				for (String string : contact) {
					if(!string.trim().isEmpty()){
						char[] ch = string.trim().toCharArray();
						boolean flag = false;
						int charLength = ch.length;
						for (int i = 0; i < charLength; i++) {
							if(!Character.isDigit(ch[i])){
								flag = true;
							}
						}
						if(!flag && string.length()>=8){
							contactNumber = string;
							break;
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "name=" + name + ",email=" + email + ", contactNumber=" + contactNumber;
	}

	public static int magicalSquare(int[][] input1){
		//int[][] nArray = {{1,2,3,4},{3,4,1,2},{2,1,4,3},{4,3,2,1}}; //4 x4 //magical sqaure
		//int[][] input1 = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}; //4 x4 //magical sqaure
		//int[][] nArray = {{2,1,3,4},{4,3,1,2},{1,2,4,3},{3,4,2,1}}; ////magical sqaure
		//int[][] nArray = {{1,0,0,0},{0,0,2,0},{0,3,0,0},{0,0,0,4}};
		//		int[][] nArray = {
		//				{1,2,3,0,0,0,0,0,0},
		//				{0,0,0,0,0,0,1,2,3},
		//				{0,0,0,1,2,3,0,0,0},
		//				{2,3,1,0,0,0,0,0,0},
		//				{0,0,0,0,0,0,2,3,1},
		//				{0,0,0,2,3,1,0,0,0},
		//				{3,1,2,0,0,0,0,0,0},
		//				{0,0,0,0,0,0,3,1,2},
		//				{0,0,0,3,1,2,0,0,0}
		//				
		//				};//magical sqaure

		int m =input1.length; 
		int n = input1.length;
		boolean flag = false;
		List<int[]> rowsList = new ArrayList<>();
		List<int[]> columnsList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int[] rows = new int[m];
			for (int j = 0; j < n; j++) {
				rows[j] = input1[i][j];
			}
			rowsList.add(rows);
		}
		for (int  j= 0; j < n; j++) {
			int[] columns = new int[n];
			for (int i = 0; i < m; i++) {
				columns[i] = input1[i][j];
			}
			columnsList.add(columns);
		}
		outerloop :for (int i = 0; i < rowsList.size(); i++) {
			innerloop:  for (int j = 0; j < columnsList.size(); j++) {
				Arrays.sort(rowsList.get(i));
				Arrays.sort(columnsList.get(j));
				flag = Arrays.equals(rowsList.get(i), columnsList.get(j));
				if(!flag){
					break innerloop;
				} else{
					flag = true;
				}
			}
		if(!flag){
			break outerloop;
		}
		}
		if(flag){
			System.out.println("Magical square");
			return 1;
		} else {
			System.out.println("Not a Magical square");
			return 0;
		}
	}

	public static int jumpCount(int jumpHeight,int slide,int wallHeight,int count){
		if(jumpHeight <=slide || (jumpHeight <= 0 || slide <= 0 || wallHeight <= 0)){
			throw new IllegalArgumentException("Invalid argument provided");
		}
		if(wallHeight <= jumpHeight){
			return ++count;
		} else {
			wallHeight = wallHeight -(jumpHeight - slide);
			return jumpCount(jumpHeight, slide, wallHeight, ++count);
		}
	}

	public static void sort2DArray(int[][] intArray){
		if(intArray == null || intArray.length== 0){
			return;
		}
		Arrays.parallelSort(intArray, (a, b) -> Integer.compare(a[0], b[0]));
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(Arrays.toString(intArray[i]));
		}
	}
	public  static String compressString(String input){
		/*
		 * @sachin srivastava
		 * tek9g.blogspot.com
		 * */
		StringBuilder sb = new StringBuilder();
		if(input == null || input.isEmpty()){
			return null;
		} else if(input.length() <= 2){
			return input;
		}
		char[] ch = input.toCharArray();
		int lenght = ch.length;
		int count = 1;
		for (int i = 0; i <=lenght-1; i++) {
			if(i!=lenght-1 && ch[i] == ch[i+1] ){
				count++;
			} else {
				sb.append(ch[i] + "" +count);
				count = 1;
			}
		}
		if(input.length() < sb.toString().length()){
			System.out.println("invalid input buffer overflow");
		}
		return sb.toString();
	}
	public static List<String> playerPairs(List<String> players,List<String> pairs){
		/*
		 * @sachin srivastava
		 * tek9g.blogspot.com
		 * */
		if(pairs == null){
			pairs = new ArrayList<>();
		}
		if((players == null || players.isEmpty())){
			return pairs;
		} else if(players.size() == 1){
			pairs.add(players.get(0));
			return pairs;
		} else {
			Random random = new Random();
			int next1 = random.nextInt(players.size());
			int next2 = random.nextInt(players.size());
			String first = players.get(next1);
			String second = players.get(next2);
			if(!first.equals(second)){
				//if((first.contains("M") && !second.contains("M")) || (first.contains("W") && !second.contains("W"))){
					pairs.add(first + "##" + second);
					players.remove(first);
					players.remove(second);
				//}
				
			}
			return playerPairs(players, pairs);
		}
	}
	
}
