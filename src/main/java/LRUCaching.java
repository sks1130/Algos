import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author sachin.srivastava
 * tek9g.blogspot.com
 *
 */
public class LRUCaching<T> {
	private int capacity;
	private LinkedHashMap<String, T> map;

	public LRUCaching(int capacity) {
		this.capacity = capacity;
		map = new LinkedHashMap<>();
	}
	public T get(String key){
		T t = this.map.get(key);
		if(t == null){
			return null;
		} else {
			this.set(key, t);
			return t;
		}
	}
	public void set(String key,T value){
		if(this.map.containsKey(key)){
			this.map.remove(key);
		} else if(this.map.size() == this.capacity){
			Iterator<String> it =  this.map.keySet().iterator();
			it.next();
			it.remove();
		}
		this.map.put(key, value);
	}
	
	public static <T> void printMap(Map<String, T> map){
		System.out.println("\n--printing the map elements--\n");
		for (Entry<String, T> entry : map.entrySet()) {
			System.out.println("key=" + entry.getKey() + " and value=" + entry.getValue());
		}
	}
	
	
	public static void main(String[] args) {
		LRUCaching<Integer> lru = new LRUCaching<>(5);
		lru.set("a", 1);
		lru.set("b", 2);
		lru.set("c", 3);
		lru.set("d", 4);
		lru.set("e", 5);
		printMap(lru.map);
		System.out.println("\nget key=a and value=" + lru.get("a"));
		printMap(lru.map);
	}
}
