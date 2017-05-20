/**
 * 
 */

/**
 * @author sachin
 *
 */
public class PermutationString {

	/**
	 * @param args
	 */
	public static void swap(char[] charArr , int j , int k){
		char temp = charArr[j];
		charArr[j] = charArr[k];
		 charArr[k] = temp;
		
	}
	public static void main(String[] args) {
		String str = "abcd";
		char[] charArr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < charArr.length; i++) {
			for (int j = i+1; j < charArr.length; j++) {
				swap(str.toCharArray() , i, j);
				sb.append(charArr);
				sb.append(",");
			}
		}
		System.out.println(sb.toString());

	}

}
