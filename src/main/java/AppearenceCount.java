import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

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
//		while (!prq.isEmpty()) {
//			System.out.print(prq.poll()+" ");
//		}
		//System.out.println(Boolean.getBoolean("true"));
		//System.out.println(rowVol(Arrays.asList(1,5,2,3,1,7,2)));
		int[] a = {3,3,7,3,1,3,4,3,1,4,2,6,4,1,4,2,4,1};//{3,3,4,4,4,2,3,1,3,2,1,4,7,3,1,6,4,1};
		
		//System.out.println(getTotalVol(6,3, a));
		int[] b = {1,5,2,3,1,7,2};
		System.out.println(trap(b));
	}
	public static int accumulatedRainTotal(final int[] tower) {
	    final int n = tower.length;
	    final int max_right[] = new int[n];
	    final int max_left[] = new int[n];

	    max_right[n - 1] = tower[n - 1];
	    for (int i = n - 2; i >= 0; i--) {
	        max_right[i] = Math.max(max_right[i + 1], tower[i]);
	    }
	    max_left[n - 1] = 0;
	    int totalRain = Math.max(Math.min(max_left[0], max_right[0]) - tower[0], 0);
	    for (int i = 1; i < n; i++) {
	        max_left[i] = Math.max(max_left[i - 1], tower[i]);
	        totalRain += Math.max(Math.min(max_left[i], max_right[i]) - tower[i], 0);
	    }
	    return totalRain;
	}
	public static int getMaxRainwaterBetweenTowers(int[] towerHeight) {
		int maxSeenSoFar = 0;
		int[] maxSeenRight = new int[towerHeight.length];
		int maxSeenLeft = 0;
		int rainwater = 0;
		for (int i = towerHeight.length - 1; i >= 0; i--) {
			if (towerHeight[i] > maxSeenSoFar) {
				maxSeenSoFar = towerHeight[i];
				maxSeenRight[i] = maxSeenSoFar;
			} else {
				maxSeenRight[i] = maxSeenSoFar;
			}
		}
		for (int i = 0; i < towerHeight.length; i++) {
			rainwater = rainwater + Integer.max(Integer.min(maxSeenLeft, maxSeenRight[i]) - towerHeight[i], 0);
			if (towerHeight[i] > maxSeenLeft) {
				maxSeenLeft = towerHeight[i];
			}
		}
		return rainwater;
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
	@SuppressWarnings("resource")
	public static String convertWordToText(String src, String desc){
		try{
			FileInputStream fs=new FileInputStream(src);
			XWPFDocument docx=new XWPFDocument(fs); 
			XWPFWordExtractor extractor=new XWPFWordExtractor(docx);
			FileWriter fw=new FileWriter(desc);
			fw.write(extractor.getText());
			fw.flush();
			fs.close();
			fw.close();
			return extractor.getText();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
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
	public static int rowVol(List<Integer> list){
		if(list == null || list.isEmpty()){
			return 0;
		}
		Integer[] arr = new Integer[list.size()];
		Integer[] height = list.toArray(arr);

		if (height.length <= 2) return 0;
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
				maxIndex = i;
			}
		}
		int leftMax = height[0];
		int water = 0;
		for (int i = 1; i < maxIndex; i++) {
			if (height[i] > leftMax) {
				leftMax = height[i];
			} else {
				water += leftMax - height[i];
			}
		}
		int rightMax = height[height.length - 1];
		for (int i = height.length - 2; i > maxIndex; i--) {
			if (height[i] > rightMax) {
				rightMax = height[i];
			} else {
				water += rightMax - height[i];
			}
		}
		return water;
	
	}
	public static int getWater(int[] heights){ 
		int n = heights.length;
		int[] mol = new int[n];
		int[] mor = new  int[n]; 
		int max=0;
		int i = 0;

		for(i=0; i<n; i++){
			if( heights[i] >= max){
				max = heights[i];
				mol[i] = 0;
			}
			else{
				mol[i] = max;
			}
		}
		max = 0;
		for(i=n-1; i>=0; i--){
			if( heights[i] >= max){
				max = heights[i];
				mor[i] = 0;
			}
			else{
				mor[i] = max;
			}
		}
		int sumwater = 0;
		for( i=0; i<n; i++){
			if(mol[i]!=0 && mor[i]!=0){
				sumwater+= Math.min(mol[i],mor[i]) - heights[i];
			}
		}
		return  sumwater;
	}
	public static int getTotalVol (int input1 , int input2 , int[] input3 ){
		if(input1 < 1 || input1 > 10 || input2 < 1 || input2 > 10){
			return 0;
		}
		int l = input1;
		int b = input2;
		int max  = Math.max(l, b);
		int v = 0;
		int[] heights = input3;
		List<List<Integer>> listOfRows = new ArrayList<>();
		List<Integer> rows = new ArrayList<>();
		for (int i = 0; i < heights.length; i++) {
			if(heights[i] < 1 || heights[i] > 10){
				return -1;
			}
			rows.add(heights[i]);
			if((i+1)%l == 0){
				listOfRows.add(rows);
				rows = new ArrayList<>();
			}
		}
		int rowsNumber = listOfRows.size();
		if(rowsNumber <= 2){
			return 0;
		}
		int i=0;
		for (List<Integer> row : listOfRows) {
			if(!(i== 0 || i == (rowsNumber -1))){
				v+=rowVol(row);
			}
			i++;
		}
		return v;
	}
	public static int trap(int[] height) {
		if (height.length <= 2) return 0;
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
				maxIndex = i;
			}
		}

		int leftMax = height[0];
		int water = 0;
		for (int i = 1; i < maxIndex; i++) {
			if (height[i] > leftMax) {
				leftMax = height[i];
			} else {
				water += leftMax - height[i];
			}
		}

		int rightMax = height[height.length - 1];
		for (int i = height.length - 2; i > maxIndex; i--) {
			if (height[i] > rightMax) {
				rightMax = height[i];
			} else {
				water += rightMax - height[i];
			}
		}

		return water;
	}
	public static int[] stockSpan(int[] stock) {
	    // we will use stack for indexes and not for "stock values"
	    int[] span = new int[stock.length];

	    for (int i = 0; i < stock.length; i++) {
	        int index = i - 1;
	        span[i] = 1;
	        while (index >= 0 && stock[index] <= stock[i]) {
	            // previous member is the same or smaller price.
	            // that member, plus all of its span, are also smaller.
	            span[i] += span[index];
	            // we can skip the span and check if the next span is smaller too.
	            index -= span[index];
	        }
	    }

	     System.out.printf("Input %s -> SPans %s%n",  Arrays.toString(stock), Arrays.toString(span));
	    return span;
	}
	
}
