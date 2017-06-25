import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author sachin.srivastava
 * @tek9g.blogpspot.com
 * {@code checking various scenarios of handling the sorting cases.}
 */
public class Sorting {
	//checking if a list is sorted means asceding or descending in either way.
	//complexity is O(n) beacaue of traversal of n elements of the list
	public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
		if(list == null || list.isEmpty()){
			return false;
		}
		if(list.size() == 1) {
			return true;
		}
		T prev =null;
		boolean asc = true;
		boolean desc = true;
		for (T t : list) {
			//ascending
			if(prev!=null && prev.compareTo(t) > 0 ){
				asc = false;
			} 
			//descending
			if(prev!=null && prev.compareTo(t) < 0 ){
				desc = false;
			}
			prev  = t;
		}
		return asc || desc;
	}
	public static <T> List<T> longestSequence(List<T> list){
		return list;
		
	}
	public static void main(String[] args) {
		System.out.println(isSorted(Arrays.asList(1,2,4,5)));//true
		System.out.println(isSorted(Arrays.asList(5,2,4,5)));//false
		System.out.println(isSorted(Arrays.asList("abc","bcd","def","fgh")));//true
		System.out.println(isSorted(Arrays.asList("b","a","c","d")));//false
	}
	
}
