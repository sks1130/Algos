import java.util.ArrayList;
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
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("4");
		list.add("3");
		list.add("2");
		list.add("1");
		System.out.println(isSorted(Arrays.asList("a","b","c","d")));
	}
}
