import java.text.NumberFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Deque;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.swagger.models.auth.In;

/**
 * @author sachin.srivastava
 * @github @sks1130
 *
 */
public class HackerRank {

	private  int ROW = 5 , COL = 5;
	public HackerRank(int row , int col) {
		this.ROW = row;
		this.COL = col;
	}
	public static int numberOfIsland(int[][] M){
		int i = 0 ;
		return i;
	} 

	public static void series(int a , int b , int n){
		int s = a;
		for (int i = 0; i < n; i++) {
			s+=(int)( Math.pow(2, i)*b);
			System.out.print(s + " ");
		}
		System.out.println();
		
	}
	public static String getDay(String day, String month, String year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day), 0, 0, 0);
		int dayOfzweek = cal.get(Calendar.DAY_OF_WEEK);
		String actualDay = "";
		switch(dayOfzweek){
		case 1 : 
			actualDay  = "SUNDAY";
			break;
		case 2 : 
			actualDay  = "MONDAY";
			break;
		case 3 : 
			actualDay  = "TUESDAY";
			break;
		case 4 : 
			actualDay  = "WEDNESDAY";
			break;
		case 5 : 
			actualDay  = "THURSDAY";
			break;
		case 6 : 
			actualDay  = "FRIDAY";
			break;
		case 7 : 
			actualDay  = "SATURDAY";
			break;
		default : 
			//do nothing
		}

		return actualDay;
	}
	public static void printRows(){
		Scanner scan = new Scanner(System.in); 
		int n  = scan.nextInt();
		ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int d = scan.nextInt();
			ArrayList<Integer> row = new ArrayList<>();
			for (int j = 0; j < d; j++) {
				row.add( scan.nextInt());
			}
			rows.add(row);
		}
		int q = scan.nextInt();
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < 2; j++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				try{
					System.out.println(rows.get(x-1).get(y-1));
				}catch(Exception e){
					System.out.println("ERROR!");
				}
			}

		}
	}
	
	public static boolean canWin(int leap , int[] game){
		return solve(leap, game, 0);
	}

	public static void phoneBook() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		Map<String, Integer> nameNumberMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			Integer phone = in.nextInt();
			if(phone.toString().trim().length() == 8){
				nameNumberMap.put(name.toLowerCase(), phone);
			}
			in.nextLine();
		}
		while (in.hasNext()) {
			String s = in.nextLine();
			Integer phone = nameNumberMap.get(s.toLowerCase());
			if(phone == null){
				System.out.println("Not found");
			}
			System.out.println(s+"=" + phone);
		}
	}
	public static void  listOperations(){
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();//size of the input list
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			list.add(scan.nextInt()); ///addig elements in the ll
		}
		int q = scan.nextInt();//number of queries
		for (int i = 0; i < q; i++) {
			String str = scan.next();
			if("Insert".equalsIgnoreCase(str)){
				int index = scan.nextInt(); //index to be updated
				int value = scan.nextInt();
				list.add(index, value);
			} else if("Delete".equalsIgnoreCase(str)){
				list.remove(scan.nextInt()); //removing the index element
			}
		}
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		scan.close();
	}
	
	public static boolean solve(int leap , int[] game , int index){
		if(game == null || game.length == 0 || leap < 0 || index < 0 || game[index] == 1){
			return false;
		}
		if(index == game.length -1 || (index + leap > game.length -1)){
			return true;
		}
		game[index]  = 1;//for visited node marking as 1
		
		return solve(leap, game, index-1) || solve(leap, game, index+1) || solve(leap, game, index+leap);
	}
	
	public static void studentComparator() {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			testCases--;
		}
		Collections.sort(studentList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				int diff = Double.valueOf(o2.cgpa).compareTo(Double.valueOf(o1.cgpa));
				if (diff == 0) {
					diff = o1.fname.compareTo(o2.fname);
					if (diff == 0) {
						diff = o1.id - o2.id;
					}
				}
				return diff;
			}
		});
		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
	}

	public static void main(String[] args) {
		bitSet();
	}
	
	
	public static void bitSet() {
		Scanner scan = new Scanner(System.in,"UTF-8");
		int N = scan.nextInt();
		int M = scan.nextInt();
		BitSet B1 = new BitSet(N);
		BitSet B2 = new BitSet(N);
		Map<Integer, BitSet> map = new HashMap<>();
		map.put(1, B1);
		map.put(2, B2);
		while(M-- > 0 && scan.hasNext()) {
			String str = scan.next();
			if(!str.isEmpty()){
				int x = scan.nextInt();
				int y = scan.nextInt();
				if ("AND".equals(str)) {
					map.get(x).and(map.get(y));
				} else if ("ANDNOT".equals(str)) {
					map.get(x).andNot(map.get(y));
				} else if ("SET".equals(str)) {
					map.get(x).set(y, true);
				} else if ("FLIP".equals(str)) {
					map.get(x).flip(y);
				} else if ("OR".equals(str)) {
					map.get(x).or(map.get(y));
				} else if ("XOR".equals(str)) {
					map.get(x).xor(map.get(y));
				}
				System.out.println(B1.cardinality() + " " + B2.cardinality());
			}
		}
		scan.close();
	}
	
	public static void printBitsets(BitSet b1, BitSet b2, int size) {
		int bit1 = 0;
		int bit2 = 0;
		for (int i = 0; i < size; i++) {
			bit1 += b1.get(i) ? 1 : 0;
		}
		for (int i = 0; i < size; i++) {
			bit2 += b2.get(i) ? 1 : 0;
		}
		System.out.println(bit1 + " " + bit2);
	}
	public static void maxUniqueNumbers() {
		HashMap<Integer, Integer> map = new HashMap<>();
		Deque<Integer> deque = new ArrayDeque<>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (i >= m) {
				int head = deque.remove();
				if (map.get(head)!=null && map.get(head)  > 1) {
					map.put(head, map.get(head) - 1);
				} else {
					map.remove(head);
				}
			}
			int num = scan.nextInt();
			deque.add(num);
			if(map.get(num)!=null){
				map.put(num, map.get(num)+1);
			} else {
				map.put(num, 1);
			}
			max = Math.max(max, map.size());
		}
		scan.close();
		System.out.println(max);
	}
	
	public static long pow(int x, int y) {
		if (y == 0) {
			return 1;
		}
		if (y % 2 == 0) {
			return pow(x * x, y / 2);
		}
		return x * pow(x, y - 1);
	}
	
	public static boolean possible(int a , int b , int c){
		int fix = c;
		int twice = 2*a;
		int diff  = b-a;
		if(fix == twice && twice == diff){
			return true;
		}
		return possible(a, b, c) ||  possible(b, a, c) ||  possible(c, a, b);

	}
	public static void printArray(Object... array){
		for (Object object : array) {
			 System.out.println(  object.getClass().getSimpleName() + " and "+  object);
		}
       
    }
	static class Player{
	    String name;
	    int score;
	    
	    Player(String name, int score){
	        this.name = name;
	        this.score = score;
	    }
	}
	static class Student implements Comparator<Student>{
		private int id;
		private String fname;
		private double cgpa;
		public Student(int id, String fname, double cgpa) {
			super();
			this.id = id;
			this.fname = fname;
			this.cgpa = cgpa;
		}
		public int getId() {
			return id;
		}
		public String getFname() {
			return fname;
		}
		public double getCgpa() {
			return cgpa;
		}
		@Override
		public int compare(Student o1, Student o2) {
			int  diff = Double.valueOf(o2.cgpa).compareTo(Double.valueOf(o1.cgpa));
			if(diff == 0){
				diff  = o1.fname.compareTo(o2.fname);
				if(diff == 0){
					diff = o1.id - o2.id;
				}
			}
			return diff;
		}
	}
	
	static class Checker implements Comparator<Player> {
		@Override
		public int compare(Player o1, Player o2) {
			int diff = o2.score - o1.score;
			if(diff == 0){
				return o1.name.compareTo(o2.name);
			}
			return diff;
		}
	}
	
	public static boolean stackPattern(String input) {
		//{}()
//		({()})
//		{}(
//		[]
//		//({}[])
//		(({()})))
//		({(){}()})()({(){}()})(){()}
//		{}()))(()()({}}{}
//		}}}}
//		))))
//		{{{
//		(((
//		[]{}(){()}((())){{{}}}{()()}{{}{}}
//		[[]][][]
//		}{
		if (input == null || input.isEmpty() || input.length() % 2 != 0) {
			return false;
		}
		Map<Character, Character> pairMap = new HashMap<>();
		pairMap.put('[', ']');
		pairMap.put('{', '}');
		pairMap.put('(', ')');// use for constant time search
		Stack<Character> stack = new Stack<>();// it can be replaced with a  better unsynchronised ArrayDeque
		int length = input.length();
		for (int i = 0; i < length; i++) {
			Character ch = input.charAt(i);
			if (pairMap.containsKey(ch)) {
				stack.push(ch);
			} else if (stack.isEmpty() || !ch.equals(pairMap.get(stack.pop()))) {
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static int maxSumHourGlass(int[][] arr) {
		int maxSum = Integer.MIN_VALUE;
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				int sum = arr[row][col] + arr[row][col + 1] + arr[row][col + 2] + arr[row + 1][col + 1]
						+ arr[row + 2][col] + arr[row + 2][col + 1] + arr[row + 2][col + 2];
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}
	
	public synchronized int multiply(int a , int b){
		int c = a*b;
		c=c+10;
		return c;
	}
	
	public static int totalNegativeArr(int [] arr){
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			sum += arr[i];
			if (arr[i] < 0) {
				total++;
			}
			for (int j = i + 1; j < arr.length; j++) {
				sum += arr[j];
				if (sum < 0) {
					total++;
				}
			}
		}
		return total;
	}
	 class MyRegex{
		//for IP matching 
//		12.12.12.12
//		13.13.13.112
//		VUUT.12.12
//		111.111.11.111
//		1.1.1.1.1.1.1
//		.....
//		1...1..1..1
//		0.0.0.0
//		255.0.255.0
//		266.266.266.266
//		00000.000000.0000000.00001
//		0023.0012.0012.0034
//		true
//		true
//		false
//		true
//		false
//		false
//		false
//		true
//		true
//		false
//		false
//		false
		String pattern ="^(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])$";
	}
	 
	 public static String duplicateRemoval(String input){
		 StringBuffer sb = new StringBuffer();
		 
		 return sb.toString();
	 }

    public static boolean isValidIP(String ipAddr){
         
        Pattern ptn = Pattern.compile("^(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])$");
        Matcher mtch = ptn.matcher(ipAddr);
        return mtch.find();
    }
	public static void formatCurrencies(){
		Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        Locale indiaLocale = new Locale("en", "IN");


		/* Create NumberFormats using Locales */
		NumberFormat us     = NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat india  = NumberFormat.getCurrencyInstance(indiaLocale);
		NumberFormat china  = NumberFormat.getCurrencyInstance(Locale.CHINA);
		NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

		/* Print output */        
		System.out.println("US: "     + us.format(payment));
		System.out.println("India: "  + india.format(payment));
		System.out.println("China: "  + china.format(payment));
		System.out.println("France: " + france.format(payment));
	}
	public static Map<Currency, Locale> getCurrencyLocaleMap() {
	       Map<Currency, Locale> map = new HashMap<>();
	        for (Locale locale : Locale.getAvailableLocales()) {
	           try {
	             Currency currency = Currency.getInstance(locale);
	             map.put(currency, locale);
	           }
	           catch (Exception e){ 
	             // skip strange locale 
	           }
	        }
	        return map;
	    }

}
