import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sachin.srivastava
 * @github @sks1130
 *
 */
public class HackerRank {

	@SuppressWarnings("unused")
	private int ROW = 5, COL = 5;

	public HackerRank(int row, int col) {
		this.ROW = row;
		this.COL = col;
	}

	public static int numberOfIsland(int[][] M) {
		int i = 0;
		return i;
	}

	public static void series(int a, int b, int n) {
		int s = a;
		for (int i = 0; i < n; i++) {
			s += (int) (Math.pow(2, i) * b);
			System.out.print(s + " ");
		}
		System.out.println();

	}

	public static void add(Integer... intArr) {
		// vargs use case of adding the number and printing it
		if (intArr == null || intArr.length < 2) {
			return;
		}
		int sum = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < intArr.length; i++) {
			sum += intArr[i];
			if (i >= 1) {
				sb.append("+" + intArr[i]);
			} else {
				sb.append(intArr[i]);
			}
		}
		sb.append("=" + sum);
		System.out.println(sb.toString());
	}

	public static String getDay(String day, String month, String year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day), 0, 0, 0);
		int dayOfzweek = cal.get(Calendar.DAY_OF_WEEK);
		String actualDay = "";
		switch (dayOfzweek) {
		case 1:
			actualDay = "SUNDAY";
			break;
		case 2:
			actualDay = "MONDAY";
			break;
		case 3:
			actualDay = "TUESDAY";
			break;
		case 4:
			actualDay = "WEDNESDAY";
			break;
		case 5:
			actualDay = "THURSDAY";
			break;
		case 6:
			actualDay = "FRIDAY";
			break;
		case 7:
			actualDay = "SATURDAY";
			break;
		default:
			// do nothing
		}

		return actualDay;
	}

	public static void printRows() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int d = scan.nextInt();
			ArrayList<Integer> row = new ArrayList<>();
			for (int j = 0; j < d; j++) {
				row.add(scan.nextInt());
			}
			rows.add(row);
		}
		int q = scan.nextInt();
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < 2; j++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				try {
					System.out.println(rows.get(x - 1).get(y - 1));
				} catch (Exception e) {
					System.out.println("ERROR!");
				}
			}

		}
		scan.close();
	}

	public static boolean canWin(int leap, int[] game) {
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
			if (phone.toString().trim().length() == 8) {
				nameNumberMap.put(name.toLowerCase(), phone);
			}
			in.nextLine();
		}
		in.close();
		while (in.hasNext()) {
			String s = in.nextLine();
			Integer phone = nameNumberMap.get(s.toLowerCase());
			if (phone == null) {
				System.out.println("Not found");
			}
			System.out.println(s + "=" + phone);
		}
	}

	public static void listOperations() {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();// size of the input list
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			list.add(scan.nextInt()); /// addig elements in the ll
		}
		int q = scan.nextInt();// number of queries
		for (int i = 0; i < q; i++) {
			String str = scan.next();
			if ("Insert".equalsIgnoreCase(str)) {
				int index = scan.nextInt(); // index to be updated
				int value = scan.nextInt();
				list.add(index, value);
			} else if ("Delete".equalsIgnoreCase(str)) {
				list.remove(scan.nextInt()); // removing the index element
			}
		}
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		scan.close();
	}

	public static boolean solve(int leap, int[] game, int index) {
		if (game == null || game.length == 0 || leap < 0 || index < 0 || game[index] == 1) {
			return false;
		}
		if (index == game.length - 1 || (index + leap > game.length - 1)) {
			return true;
		}
		game[index] = 1;// for visited node marking as 1

		return solve(leap, game, index - 1) || solve(leap, game, index + 1) || solve(leap, game, index + leap);
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
		in.close();
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

	class Priorities {

		public List<Student> getStudents(List<String> events) {
			List<Student> list = new ArrayList<>();
			PriorityQueue<Student> pq = new PriorityQueue<>(events.size(), new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					int diff = Double.valueOf(o2.getCgpa()).compareTo(Double.valueOf(o1.getCgpa()));
					if (diff == 0) {
						diff = o1.getFname().compareTo(o2.getFname());
						if (diff == 0) {
							diff = o1.getId() - o2.getId();
						}
					}
					return diff;
				}
			});
			int size = events.size();
			for (int i = 0; i < size; i++) {
				String[] strArr = events.get(i).split(" ");
				if ("ENTER".equalsIgnoreCase(strArr[0])) {
					Student s = new Student(Integer.parseInt(strArr[3]), strArr[1], Double.parseDouble(strArr[2]));
					pq.add(s);
				} else if ("SERVED".equalsIgnoreCase(strArr[0])) {
					pq.poll();
				}
			}
			int pqSize = pq.size();
			for (int i = 0; i < pqSize; i++) {
				list.add(pq.poll());
			}
			return list;
		}
	}

	public static void tokeniser(String str) {
		String regex = "[\\s  !,?._'@]+";
		String sample = "".trim();
		if (!sample.isEmpty()) {
			String[] arr = sample.split(regex);
			System.out.println(arr.length);
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} else {
			System.out.println(0);
		}
	}

	public static List<String> tags(String str, List<String> list) {
		if (str == null || str.isEmpty()) {
			return list;
		}
		int start = str.indexOf("<");
		int end = str.indexOf(">");
		if (start != -1 && end != -1) {
			String tag = str.substring(start, end + 1);
			list.add(tag);
		} else {
			return list;
		}
		return tags(str.substring(end + 1), list);
	}

	public static void bigIntegerOperations() {
		Scanner scan = new Scanner(System.in);
		BigInteger big1 = scan.nextBigInteger();
		BigInteger big2 = scan.nextBigInteger();
		System.out.println(big1.add(big2));
		System.out.println(big1.multiply(big2));
		scan.close();
	}

	public static void bigDecimalStringSorting() {
		// Input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n + 2];
		for (int i = 0; i < n; i++) {
			s[i] = sc.next();
		}
		sc.close();
		// Write your code here
		Arrays.sort(s, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1 == null || o2 == null) {
					return 0;
				}
				return new BigDecimal(o2).compareTo(new BigDecimal(o1));
			}
		});
		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void iteratorTest() {

		ArrayList mylist = new ArrayList();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			mylist.add(sc.nextInt());
		}

		mylist.add("###");
		for (int i = 0; i < m; i++) {
			mylist.add(sc.next());
		}
		sc.close();
		Iterator it = func(mylist);
		while (it.hasNext()) {
			Object element = it.next();
			System.out.println((String) element);
		}

	}

	@SuppressWarnings("rawtypes")
	static Iterator func(ArrayList mylist) {
		Iterator it = mylist.iterator();
		while (it.hasNext()) {
			Object element = it.next();
			if (!(element instanceof String)) {// Hints: use instanceof operator
				it.remove();
			} else {
				break;
			}
		}
		return it;

	}

	public static final MyCalculator my_calculator = new MyCalculator();
	public static final Scanner in = new Scanner(System.in);

	static class Inner {
		// System.out.println(num + " is " + ((Solution.Inner.Private)(o =
		// (Object) new Solution.Inner().new Private())).powerof2(num));
		// System.out.println(num + " is " + new HackerRank.Inner().new
		// Private().powerof2(num));
		@SuppressWarnings("unused")
		private class Private {
			private String powerof2(int num) {
				return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public static void reflection() {
		Class student = Student.class;
		Method[] methods = student.getDeclaredMethods();
		ArrayList<String> methodList = new ArrayList<>();
		for (Method method : methods) {
			methodList.add(method.getName());
		}
		Collections.sort(methodList);
		for (String name : methodList) {
			System.out.println(name);
		}
	}

	public static String generateSHA256(String input) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.reset();
		byte[] buffer = input.getBytes("UTF-8");
		md.update(buffer);
		byte[] digest = md.digest();
		String hexStr = "";
		for (int i = 0; i < digest.length; i++) {
			hexStr += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);
		}
		return hexStr;
	}

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr) {
		mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd) {
			return;
		}
		int mid = (leftStart + rightEnd) / 2;
		mergeSort(arr, temp, leftStart, mid);
		mergeSort(arr, temp, mid + 1, rightEnd);
		merge(arr, temp, leftStart, rightEnd);
	}

	public static void merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				temp[index] = arr[left];
				left++;
			} else {
				temp[index] = arr[right];
				right++;
			}
			index++;
		}
		System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, size);
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = arr[(left + right) / 2];
		int index = partition(arr, left, right, pivot);
		quickSort(arr, left, index - 1);
		quickSort(arr, index, right);
	}

	public static int partition(int[] arr, int left, int right, int pivot) {
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	static class MyCalculator {
		/*
		 * Create the method long power(int, int) here.
		 */
		long power(int x, int y) throws Exception {
			if (x < 0 || y < 0) {
				throw new Exception("n or p should not be negative.");
			} else if (x == 0 && y == 0) {
				throw new Exception("n and p should not be zero.");
			}
			if (y == 0 && x != 0) {
				return 1;
			} else if (x == 0 && y != 0) {
				return 0;
			} else {
				return x * power(x, y - 1);
			}
		}

	}

	public static void validateHTMLTags() {
		// hacker rank
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());

		while (testCases-- > 0) {
			String line = scan.nextLine();
			boolean matchFound = false;
			Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
			Matcher m = r.matcher(line);
			while (m.find()) {
				System.out.println(m.group(2));
				matchFound = true;
			}
			if (!matchFound) {
				System.out.println("None");
			}
		}
		scan.close();

	}

	public static long abs(long a) {
		return a < 0 ? -a : a;
	}

	public static double abs(double a) {
		return a < 0 ? -a : a;
	}

	static boolean isAnagramShorter(String first, String second) {
		int[] ch = new int[256];
		for (int i = 0; i < first.length(); i++) {
			int x = first.charAt(i) - 'a';
			ch[Math.abs(x)]++;
		}
		for (int i = 0; i < second.length(); i++) {
			int x = second.charAt(i) - 'a';
			ch[Math.abs(x)]--;
		}
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != 0) {
				return false;
			}
		}
		return true;
	}

	static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		Map<Character, Integer> mapA = new HashMap<>();
		Map<Character, Integer> mapB = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			char ch = a.toLowerCase().charAt(i);
			char ch2 = b.toLowerCase().charAt(i);
			if (mapA.get(ch) == null) {
				mapA.put(ch, 1);
			} else {
				mapA.put(ch, mapA.get(ch) + 1);
			}
			if (mapB.get(ch2) == null) {
				mapB.put(ch2, 1);
			} else {
				mapB.put(ch2, mapB.get(ch2) + 1);
			}
		}
		for (Character key : mapA.keySet()) {
			if (!mapA.get(key).equals(mapB.get(key))) {
				return false;
			}
		}
		return true;
	}

	public static String checkAnagrams(String first, String second) {
		char[] c = new char[256];
		String s = first + second;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			c[ch]++;
		}
		System.out.println(c);
		return null;
	}

	public static String reverse(String str) {
		StringBuffer sb = new StringBuffer();
		;
		sb.append(str);
		return sb.reverse().toString();
	}

	public static String isPalindrome(String str) {
		if (str == null || str.isEmpty() || str.length() == 1) {
			return "No";
		}
		if (isPalindrome(str).equals(reverse(str))) {
			return "Yes";
		}
		return "No";
	}

	public static String getMaxAndMinString(String str, int k) {
		List<String> list = new ArrayList<>();
		list = subString(str, k, list);
		Collections.sort(list);
		return list.get(0) + "\n" + list.get(list.size() - 1);
	}

	public static List<String> subString(String str, int len, List<String> list) {
		if (str == null || str.isEmpty() || str.length() < (len)) {
			return list;
		}
		if (list == null) {
			list = new ArrayList<>();
		}
		String sub = str.substring(0, len);
		list.add(sub);
		String rem = str.substring(1);
		return subString(rem, len, list);
	}

	public static void stringProblem() {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		System.out.println(A.length() + B.length());
		int comp = A.compareTo(B);
		if (comp < 0) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
		sc.close();
		System.out.println(camelCasing(A) + " " + camelCasing(B));
	}

	public static String camelCasing(String str) {
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, 1).toUpperCase() + (str.substring(1)));
		return sb.toString();
	}

	public static void bitSet() {
		Scanner scan = new Scanner(System.in, "UTF-8");
		int N = scan.nextInt();
		int M = scan.nextInt();
		BitSet B1 = new BitSet(N);
		BitSet B2 = new BitSet(N);
		Map<Integer, BitSet> map = new HashMap<>();
		map.put(1, B1);
		map.put(2, B2);
		while (M-- > 0 && scan.hasNext()) {
			String str = scan.next();
			if (!str.isEmpty()) {
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
				if (map.get(head) != null && map.get(head) > 1) {
					map.put(head, map.get(head) - 1);
				} else {
					map.remove(head);
				}
			}
			int num = scan.nextInt();
			deque.add(num);
			if (map.get(num) != null) {
				map.put(num, map.get(num) + 1);
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

	public static boolean possible(int a, int b, int c) {
		int fix = c;
		int twice = 2 * a;
		int diff = b - a;
		if (fix == twice && twice == diff) {
			return true;
		}
		return possible(a, b, c) || possible(b, a, c) || possible(c, a, b);

	}

	public static void printArray(Object... array) {
		for (Object object : array) {
			System.out.println(object.getClass().getSimpleName() + " and " + object);
		}

	}

	static class Player {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

	public static void bubbleSort(int[] a) {
		// O(n2) and in space
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static class Student implements Comparator<Student> {
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

		public void anothermethod() {
		}

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
	}

	static class Checker implements Comparator<Player> {
		@Override
		public int compare(Player o1, Player o2) {
			int diff = o2.score - o1.score;
			if (diff == 0) {
				return o1.name.compareTo(o2.name);
			}
			return diff;
		}
	}

	public static boolean stackPattern(String input) {
		// {}()
		// ({()})
		// {}(
		// []
		// //({}[])
		// (({()})))
		// ({(){}()})()({(){}()})(){()}
		// {}()))(()()({}}{}
		// }}}}
		// ))))
		// {{{
		// (((
		// []{}(){()}((())){{{}}}{()()}{{}{}}
		// [[]][][]
		// }{
		if (input == null || input.isEmpty() || input.length() % 2 != 0) {
			return false;
		}
		Map<Character, Character> pairMap = new HashMap<>();
		pairMap.put('[', ']');
		pairMap.put('{', '}');
		pairMap.put('(', ')');// use for constant time search
		Stack<Character> stack = new Stack<>();// it can be replaced with a
		// better unsynchronised
		// ArrayDeque
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

	public synchronized int multiply(int a, int b) {
		int c = a * b;
		c = c + 10;
		return c;
	}

	public static int totalNegativeArr(int[] arr) {
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

	class MyRegex {
		// for IP matching
		// 12.12.12.12
		// 13.13.13.112
		// VUUT.12.12
		// 111.111.11.111
		// 1.1.1.1.1.1.1
		// .....
		// 1...1..1..1
		// 0.0.0.0
		// 255.0.255.0
		// 266.266.266.266
		// 00000.000000.0000000.00001
		// 0023.0012.0012.0034
		// true
		// true
		// false
		// true
		// false
		// false
		// false
		// true
		// true
		// false
		// false
		// false
		String pattern = "^(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])$";
	}

	public static String duplicateRemoval(String input) {
		StringBuffer sb = new StringBuffer();

		return sb.toString();
	}

	public static boolean isValidIP(String ipAddr) {

		Pattern ptn = Pattern.compile(
				"^(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])$");
		Matcher mtch = ptn.matcher(ipAddr);
		return mtch.find();
	}

	public static void formatCurrencies() {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();

		Locale indiaLocale = new Locale("en", "IN");

		/* Create NumberFormats using Locales */
		NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat india = NumberFormat.getCurrencyInstance(indiaLocale);
		NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
		NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

		/* Print output */
		System.out.println("US: " + us.format(payment));
		System.out.println("India: " + india.format(payment));
		System.out.println("China: " + china.format(payment));
		System.out.println("France: " + france.format(payment));
	}

	public static Map<Currency, Locale> getCurrencyLocaleMap() {
		Map<Currency, Locale> map = new HashMap<>();
		for (Locale locale : Locale.getAvailableLocales()) {
			try {
				Currency currency = Currency.getInstance(locale);
				map.put(currency, locale);
			} catch (Exception e) {
				// skip strange locale
			}
		}
		return map;
	}

	public enum Singleton {
		INSTANCE;
		public Singleton getInstance() {
			return INSTANCE;
		}
	}

	public static String generateMD5(String input) {
		if (input == null) {
			return null;
		}
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.reset();
			byte[] buffer = input.getBytes("UTF-8");
			byte[] arr = md.digest(buffer);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < arr.length; ++i) {
				sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
				// sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100,
				// 16).substring(1));
				//
				// convert the byte to hex format method 2
				// StringBuffer hexString = new StringBuffer();
				// for (int i=0;i<mdbytes.length;i++) {
				// String hex=Integer.toHexString(0xff & mdbytes[i]);
				// if(hex.length()==1) hexString.append('0');
				// hexString.append(hex);
				// }
				// System.out.println("Digest(in hex format):: " +
				// hexString.toString());
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	class Flower {

		String whatsYourName() {
			return "I have many names and types.";
		}
	}

	class Jasmine extends Flower {
		@Override
		String whatsYourName() {
			return "Jasmine";
		}
	}

	class Lily extends Flower {
		@Override
		String whatsYourName() {
			return "Lily";
		}
	}

	class Lotus extends Flower {
		@Override
		String whatsYourName() {
			return "Lotus";
		}
	}

	class State {

		Flower yourNationalFlower() {
			return new Flower();
		}
	}

	class WestBengal extends State {

		@Override
		Jasmine yourNationalFlower() {
			return new Jasmine();
		}
	}

	class Karnataka extends State {

		@Override
		Lotus yourNationalFlower() {
			return new Lotus();
		}
	}

	class AndhraPradesh extends State {

		@Override
		Lily yourNationalFlower() {
			return new Lily();
		}
	}

	interface PerformOperation {
		boolean check(int a);
	}

	class MyMath {
		public boolean checker(PerformOperation p, int num) {
			return p.check(num);
		}

		public PerformOperation isOdd() {
			return n -> (n & 1) == 1;
		}

		public PerformOperation isPrime() {
			return n -> {
				if (n < 2) {
					return false;
				}
				return BigInteger.valueOf(n).isProbablePrime(1);
			};
		}

		public PerformOperation isPalindrome() {
			return n -> {
				return new StringBuilder().append(n).reverse().toString().equals(Integer.toString(n));
			};
		}

	}

	class Graph {

		private Map<Integer, Node> nodeLookup = new HashMap<>();

		class Node {
			private int id;
			LinkedList<Node> adj = new LinkedList<>();

			private Node(int id) {
				this.id = id;
			}
		}

		public void addNode(int id) {
			if (nodeLookup.get(id) == null) {
				nodeLookup.put(id, new Node(id));
			}
		}

		private Node getNode(int id) {
			return nodeLookup.get(id);
		}

		public void addEdge(int src, int dest) {
			Node s = getNode(src);
			Node d = getNode(dest);
			s.adj.add(d);
		}

		public boolean hasPathDfs(int src, int dest) {
			// more of recursive function asking adjacent nodes and keep the
			// array of visited nodes
			Node s = getNode(src);
			Node d = getNode(dest);
			Set<Integer> visited = new HashSet<>();
			return hasPathDfs(s, d, visited);
		}

		public boolean hasPathDfs(Node src, Node dest, Set<Integer> visited) {
			// more of recursive function asking adjacent nodes and keep the
			// array of visited nodes
			if (visited.contains(src.id)) {
				return false;
			}
			if (src.id == dest.id) {
				return true;
			}
			visited.add(src.id);
			for (Node child : src.adj) {
				if (hasPathDfs(child, dest, visited)) {
					return true;
				}
			}
			return false;
		}

		public boolean hasPathBFS(int src, int dest) {
			if (src == dest) {
				return true;
			}
			return hasPathBFS(src, dest);
		}

		@SuppressWarnings("unused")
		private boolean hasPathBFS(Node src, Node dest) {
			LinkedList<Node> nextToVisit = new LinkedList<>();
			Set<Integer> visited = new HashSet<>();
			nextToVisit.add(src);
			while (!nextToVisit.isEmpty()) {
				Node node = nextToVisit.remove();
				if (node.id == dest.id) {
					return true;
				}
				if (visited.contains(node.id)) {
					continue;
				}
				visited.add(node.id);
				for (Node child : node.adj) {
					nextToVisit.add(child);
				}
			}
			return false;
		}

	}

	public static void main(String[] args) {
		int[] arr = {2, 1, 3, 1 ,2};
		System.out.println(countInversions(arr));
	}
	
	class MinHeap{
		Node[] nodes;
		Node left;
		Node right;
		Node root;
		
	}

	public static void showFlavours(int money, int[] arr) {
		// O(n2) is most possible solution and no extra space
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] + arr[j] == money) {
					System.out.println((i + 1) + " " + (j + 1));
					return;
				}
			}
		}

	}

	public static void showFlavoursOptimised(int money, int[] arr) {
		// O(n) time complexity
		// O(n) space complexity
		// optimised way to search the sum of two values
		Map<Integer, Integer> map = new HashMap<>();
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int cost = arr[i];
			int id = i + 1;
			int key = money - cost;
			if (map.containsKey(key)) {
				System.out.println(map.get(key) + " " + id);
				break;

			}
			map.putIfAbsent(cost, id);
		}

	}
	public static void method(int[] node){
		node[0] = 3;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void printIndiaMap() {
		//prints the map of India
		int a = 10, b = 0, c = 10;
		String s1 = "TFy!QJu ROo TNn(ROo)SLq SLq ULo+UHs UJq TNn*RPn/QPbEWS_JSWQAIJO^NBELPeHBFHT}TnALVlBLOFAkHFOuFETpHCStHAUFAgcEAelclcn^r^r\\tZvYxXyT|S~Pn SPm SOn TNn ULo0ULo#ULo-WHq!WFs XDt!";
		a = s1.charAt(b);
		while (a != 0) {
			if (b < 170) {
				a = s1.charAt(b);
				b++;
				while (a > 64) {
					a--;
					if (++c == 'Z') {
						c /= 9;
						System.out.print((char) (c));
					} else
						System.out.print((char) (33 ^ (b & 0x01)));
				}
			} else
				break;
		}

	}

	public static void tries() {
		// excellent way of adding nodes and searchign a word frequency from the
		// tree
		// time complexit O(n) requires O(n) space
		TrieNode node = new TrieNode();
		node.add("hackerhackerhacker");
		node.add("hackerrank");
		node.add("hackos");
		System.out.println(node.find("hac"));
		System.out.println(node.find("hak"));
		System.out.println(node.find("hacker"));
	}

	public static void minAndMaxSum(int[] arr) {
		Arrays.sort(arr);
		int min = arr[0];
		int max = arr[arr.length - 1];
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println((sum - max) + " " + (sum - min));

	}

	public static void formatDecimal() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String str = "";
			for (int j = 0; j < i + 1; j++) {
				str += "#";
			}
			System.out.println(String.format("%1$" + n + "s", str));
		}
		in.close();
	}

	public static void sumDiagonals(int[][] mat) {
		int sumDiag1 = 0;
		int sumDiag2 = 0;
		int n = mat.length;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < mat[row].length; col++) {
				if (row == col) {
					sumDiag1 += mat[row][col];
				}
				if ((col == n - 1 - row)) {
					sumDiag2 += mat[row][col];
				}
			}
		}
		System.out.println(Math.abs(sumDiag1 - sumDiag2));
	}

	public static void duplicateInNoExtraSpace(int[] arr) {
		// awesome solution to focus
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] - 1;
		}
		for (int j = 0; j < n; j++) {
			arr[arr[j] % n] += n;
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] / n >= 2) {
				System.out.println(i + 1 + "-->" + arr[i] / n);// finding
			}
		}
	}

	static void findCounts(int arr[], int n) {
		// Traverse all array elements
		int i = 0;
		while (i < n) {
			// If this element is already processed,
			// then nothing to do
			if (arr[i] <= 0) {
				i++;
				continue;
			}

			// Find index corresponding to this element
			// For example, index for 5 is 4
			int elementIndex = arr[i] - 1;

			// If the elementIndex has an element that is not
			// processed yet, then first store that element
			// to arr[i] so that we don't loose anything.
			if (arr[elementIndex] > 0) {
				arr[i] = arr[elementIndex];

				// After storing arr[elementIndex], change it
				// to store initial count of 'arr[i]'
				arr[elementIndex] = -1;
			} else {
				// If this is NOT first occurrence of arr[i],
				// then increment its count.
				arr[elementIndex]--;

				// And initialize arr[i] as 0 means the element
				// 'i+1' is not seen so far
				arr[i] = 0;
				i++;
			}
		}

		System.out.println("Below are counts of all elements");
		for (int j = 0; j < n; j++)
			System.out.println(j + 1 + "->" + Math.abs(arr[j]));
	}

	static void printfrequency(int arr[], int n) {
		// Subtract 1 from every element so that the elements
		// become in range from 0 to n-1
		for (int j = 0; j < n; j++)
			arr[j] = arr[j] - 1;

		// Use every element arr[i] as index and add 'n' to
		// element present at arr[i]%n to keep track of count of
		// occurrences of arr[i]
		for (int i = 0; i < n; i++)
			arr[arr[i] % n] = arr[arr[i] % n] + n;

		// To print counts, simply print the number of times n
		// was added at index corresponding to every element
		for (int i = 0; i < n; i++)
			System.out.println(i + 1 + "->" + arr[i] / n);
	}

	public static void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty() || stack == null) {
			return;
		}
		if (!stack.isEmpty()) {
			Integer top = stack.pop();
			reverseStack(stack);
			reverseStack(stack, top);
		}

	}

	public static void reverseStack(Stack<Integer> stack, Integer top) {
		if (stack.isEmpty()) {
			stack.push(top);
		} else {
			Integer x = stack.pop();
			reverseStack(stack, top);
			stack.push(x);
		}
	}

	public static int[] arraysLeftRotation(int[] a, int n, int k) {
		if (n == k) {
			return a;
		}
		if (k > n) {
			k = k % n;
		}
		int[] arr = new int[n];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (i > k - 1) {
				arr[j] = a[i];
				j++;
			}
		}
		int diff = arr.length - j;
		for (int p = 0; p < diff; p++, j++) {
			arr[j] = a[p];
		}
		return arr;
	}

	public static boolean checkBST(BinaryNode root) {
		// root node must be greater than left tree and lesser than right tree
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		// Inorder traversal
	}

	public static boolean checkBST(BinaryNode root, Integer min, Integer max) {
		// awesome solution
		// O(logn) and time complexityO(n) -- linear
		if (root == null) {
			return true;
		}
		if (root.data < min || root.data > max) {
			return false;
		}
		return checkBST(root.left, min, root.data - 1) && checkBST(root.right, root.data + 1, max);
	}

	static class BinaryNode {
		int data;
		BinaryNode left;
		BinaryNode right;

		public BinaryNode(int data) {
			this.data = data;
		}
	}

	public static int numberNeeded(String first, String second) {
		int count = 0;
		int[] c1 = new int[26];
		int[] c2 = new int[26];

		for (int i = 0; i < first.length(); i++) {
			char c = first.charAt(i);
			int off = c - 'a';
			c1[off]++;
		}
		for (int i = 0; i < second.length(); i++) {
			char c = second.charAt(i);
			int off = c - 'a';
			c2[off]++;
		}
		for (int i = 0; i < c2.length; i++) {
			if (c2[i] != c1[i]) {
				int abs = Math.abs(c2[i] - c1[i]);
				int j = 0;
				while (abs > 0 && j < abs) {
					count++;
					j++;
				}
			}
		}
		System.out.println(Arrays.toString(c1));
		System.out.println(Arrays.toString(c2));
		return count;
	}

	static class TrieNode {

		private static final int Num_Chars = 26;
		TrieNode[] children = new TrieNode[Num_Chars];
		int size = 0;

		private static int getCharIndex(Character c) {
			return c - 'a';
		}

		private TrieNode getNode(Character c) {
			return children[getCharIndex(c)];
		}

		private void setNode(Character c, TrieNode node) {
			children[getCharIndex(c)] = node;
		}

		public void add(String word) {
			add(word, 0);

		}

		private void add(String word, int index) {
			size++;
			if (index == word.length()) {
				return;
			}
			Character c = word.charAt(index);
			TrieNode child = getNode(c);
			if (child == null) {
				child = new TrieNode();
				setNode(c, child);
			}
			child.add(word, index + 1);
		}

		public int find(String word) {
			return find(word, 0);
		}

		public int find(String word, int index) {
			if (word.length() == index) {
				return size;
			}
			TrieNode child = getNode(word.charAt(index));
			if (child == null) {
				return 0;
			}
			return child.find(word, index + 1);
		}
	}

	boolean hasCycle(Node head) {
		// O(n) space & time complexity. if want in O(1) space then fast slow or
		// turtle hare algorithm works pretty well.
		if (head == null) {
			return false;
		}
		HashSet<Node> set = new HashSet<>();
		while (head.next != null) {
			if (set.contains(head.next)) {
				return true;
			}
			set.add(head.next);
			head = head.next;
		}
		return false;
	}

	class Node {
		Node[] nodes;
		Node next;
		Node root = this;
		Node left;
		Node right;
		int data;
		long swap = 0;
		public Node(int data){
			this.data = data;
		}
		public Node(int[] arr) {
			nodes = new Node[arr.length];
			for(int i =0 ; i< arr.length ; i++){
				nodes[i] = new Node(arr[i]);
			}
		}
		void heapify(){
		}
	}

	static String median(List<Integer> list) {
		//this is work but time complexity
		
		
		//adding element , sort the elements and print the median
		//{1} -- 1 , {1,2} --> 1.5 , {1,2,3} --> 2
		//problems with the fix size of the array with the default value 0
		if(list == null || list.isEmpty()){
			return "";
		}
		Collections.sort(list);
		int len = list.size();
		int index = 0;
		double d = 0;
		if (len == 1) {
			d = Double.valueOf(list.get(index));
			return d+"";
		}
		if (len % 2 != 0) {
			 index = (len + 1) / 2 - 1;
			d = (double) list.get(index);
		} else {
			index = len / 2 - 1;
			d =  (Double.valueOf(list.get(index)) + Double.valueOf(list.get(index+1))) / 2;
		}
		return new DecimalFormat("0.0").format(d);
	}

	static double[] median(int[] arr) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // top would be
																// min
		// 1 4 5 6 2
		double[] medians = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			addNumber(num, minHeap,maxHeap);
			rebalance( minHeap,maxHeap);
			medians[i] = getMedian( minHeap,maxHeap);
		}
		return medians;
	}
	private static void addNumber(Integer num , PriorityQueue<Integer> maxHeap , PriorityQueue<Integer> minHeap){
		if(minHeap.size() == 0 || num < minHeap.peek()){
			minHeap.add(num);
		} else {
			maxHeap.add(num);
		}
	}
	private static void rebalance(PriorityQueue<Integer> maxHeap , PriorityQueue<Integer> minHeap){
		PriorityQueue<Integer> biggerHeap = (maxHeap.size() > minHeap.size() ) ? maxHeap : minHeap;
		PriorityQueue<Integer> smallerHeap = (maxHeap.size() > minHeap.size() ) ? minHeap : maxHeap;
		if(biggerHeap.size() - smallerHeap.size() >= 2 ){
			smallerHeap.add(biggerHeap.poll());
		}
	}
	private static double getMedian(PriorityQueue<Integer> maxHeap , PriorityQueue<Integer> minHeap){
		PriorityQueue<Integer> biggerHeap = (maxHeap.size() > minHeap.size() ) ? maxHeap : minHeap;
		PriorityQueue<Integer> smallerHeap = (maxHeap.size() > minHeap.size() ) ? minHeap : maxHeap;
		if(biggerHeap.size() == smallerHeap.size()){
			return ((double)(biggerHeap.peek()+smallerHeap.peek()))/2;
		} else {
			return biggerHeap.peek();
		}
	}
	static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
        	stackNewestOnTop.push(value); //newest will be one top of this stackNewestOnTop
        }

        public T peek() {
        	shiftStack();
        	return stackOldestOnTop.peek();
        }

        public T dequeue() {
        	shiftStack();
            return stackOldestOnTop.pop();
        }
        private void shiftStack(){
        	while(stackOldestOnTop.isEmpty()){
        		while(!stackNewestOnTop.isEmpty()){
        			stackOldestOnTop.push(stackNewestOnTop.pop());
        		}
        	}
        }
    }
	public static void queueUsingStack(){
		
		MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
	}
	public static int stairCase(int numberOfStairs){
		//for height n total number of jumps
		if(numberOfStairs < 0 ){
			return 0;
		}
		if(numberOfStairs == 1 || numberOfStairs == 0){
			return 1;
		}
		if(numberOfStairs == 2){
			return 2;
		}
		int[] memo = new int[numberOfStairs+1];
		return 	stairCase(numberOfStairs - 1, memo) + stairCase(numberOfStairs - 2,memo) + stairCase(numberOfStairs -3,memo);
	
	}
	public static int stairCase(int numberOfStairs, int[] memo){
		//using memonization technique
		if(numberOfStairs < 0){
			return 0;
		} else if(numberOfStairs == 0){
			return 1;
		}
		if(memo[numberOfStairs] == 0){
			memo[numberOfStairs]  = stairCase(numberOfStairs-1, memo) + stairCase(numberOfStairs-2, memo) + stairCase(numberOfStairs-3, memo);
		}
		return memo[numberOfStairs];
	}

	public static int countStairs(int steps) {
		// Using DP
		if (steps < 0) {
			return 0;
		} else if (steps <= 1) {
			return 1;
		}
		int[] paths = { 1, 1, 2 };
		for (int i = 3; i <= steps; i++) {
			int count = paths[0] + paths[1] + paths[2];
			paths[0] = paths[1];
			paths[1] = paths[2];
			paths[2] = count;
		}
		return paths[2];
	}

	public static long countChanges(int money , int[] coins){
		return countChanges(money, coins, 0, new HashMap<String, Long>());
	}
	public static long countChanges(int money , int[] coins , int index , HashMap<String, Long> memo){
		if(index>= coins.length){
			return 0;
		}
		if(money == 0){
			return 1;
		}
		long ways = 0;
		int amountWithCoins = 0;
		String key = money + "-" + index;
		if(memo.containsKey(key)){
			return memo.get(key);
		}
		while(amountWithCoins<=money){
			int rem = money  - amountWithCoins;
			ways+=countChanges(rem, coins, index+1, memo);
			amountWithCoins+=coins[index];
		}
		memo.put(key, ways);
		return ways;
	}
	 static long countInversions(int[] arr) {
		 long count = 0;
		 
		 
		 	//solution# 1
	        // Complete this function but O(n2) is worst case
//	        int n = arr.length;
//	        for(int i=0 ; i< n;i++){
//	            for(int j=i+1 ; j< n ; j++){
//	                if(arr[i] > arr[j]){
//	                    swap(arr, i , j);
//	                    count++;
//	                }
//	            }
//	        }
		//solution# 2
	   // Complete this function but O(nlogn) & O(n) extra space in worst and best case
	        
	        return count;
	    }
}
