import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class DFS_Examples {

	private  int ROW = 5 , COL = 5;
	public DFS_Examples(int row , int col) {
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

	public static void main(String[] args) {
		
		System.out.println(totalNegativeArr(new int[]{1, -2, 4, -5 ,1}));
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
