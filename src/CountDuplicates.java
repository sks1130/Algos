import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 */

/**
 * @author sachin
 *
 */
public class CountDuplicates {
	
	public static void charsCountUsingMap(String str){
		Map<Character, Integer> map = new HashMap<>();
		char[] charArrInput =  str.toCharArray();
		for (char c : charArrInput) {
			if(!map.containsKey(c)){
				map.put(c, 1);
			} else {
				map.put(c, map.get(c)+1);
			}
		}
		for (Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println("char=" + entry.getKey() + " and count=" + entry.getValue());
		}
	}

	public static void charsCount(String str){
		int[] intArr = new int[256];
		char[] charArrInput =  str.toCharArray();
		int charLength = charArrInput.length;
		for (int i = 0; i < charLength; i++) {
			intArr[charArrInput[i]]++;
		}
		int j =0;
		for (int c : intArr) {
			if(c > 0){
				System.out.println( "char=" + (char)j + " and count=" + c );
			}
			j++;
		}
	}
	public static void main(String[] args) {
		String a = "My Name Is Sachin Srivastava and I am a Java Architect passionate "
				+ "about writing,blogging & coding , author of tek9g.blogspot.com and vedology.blogspot.com";
		//charsCount(a);
		charsCountUsingMap(a);
		
	}

}
