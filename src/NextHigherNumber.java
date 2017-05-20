import java.util.Arrays;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class NextHigherNumber {
	
	public static void swap(char[]  charArray, int j , int k){
		char temp = charArray[j];
		charArray[j] = charArray[k];
		charArray[k] = temp;
	}
	public static void nextHigherInteger(Integer input){
		if(input == null || input<=0 ){
			return;
		}
		String s = input.toString();
		char[] charArr = s.toCharArray();
		int charLength = charArr.length;
		int breakPoint = 0;
		for (int i = charLength-1; i > 0; i--) {
			char last = charArr[i];
			char secondLast = charArr[i-1];
			if(secondLast < last ){
				breakPoint = i-1;
				break;
			} 
		}
		if(breakPoint == 0){
			System.out.println("This is the highest number");
			return;
		}
		String first = s.substring(0, breakPoint+1);
		String second = s.substring(breakPoint+1, charLength);
		char[] secondCharArra = second.toCharArray();
		Arrays.sort(secondCharArra);
		StringBuffer sb2 =new StringBuffer();
		sb2.append(first);
		for (char c : secondCharArra) {
			sb2.append(c);
		}          
		char[] charArray = sb2.toString().toCharArray();
		int j = breakPoint;
		int k = ++breakPoint;
		while(true){
			if(charArray[j] < charArray[k]){
				swap(charArray, j, k);
				break;
			} else {
				k++;
			}
		}
		StringBuffer sb3 = new StringBuffer();
		for (char c : charArray) {
			sb3.append(c);
		}  
		System.out.println(sb3.toString());
	}
	public static void main(String[] args) {
		//nextHigherInteger(34722641);//34724126
		//nextHigherInteger(1234675);//1234756
		//nextHigherInteger(23514);//23541
		nextHigherInteger(38276);//38627
	}
}