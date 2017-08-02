import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * @author sachin
 *
 */
public class Uber {

	static long teamFormation(int[] score, int team, int m) {
		int sum = 0;
		if(team == score.length){
			for (int i = 0; i < score.length; i++) {
				sum+=score[i];
			}
			return sum;
		}
		List<Integer> intList = new ArrayList<Integer>();
		for (int index = 0; index < score.length; index++){
		    intList.add(score[index]);
		}
		return splitArray(intList, team, m, team, sum);
    }
	
	static int splitArray(List<Integer> score, int team, int m, int teamSplit, int sum){
		if(teamSplit == 1 ){
			return sum;
		}
		int max = 0;
		for (int i = 0; i < m; i++) {
			if(max < score.get(i)){
				max = score.get(i);
			}
		}
		for (int i = score.size()-1; i >=  score.size()-1-m; i--) {
			if(max < score.get(i)){
				max = score.get(i);
			}
		}
		List<Integer> list = new ArrayList<>();
		int j = 0;
		for (int i = 0; i < score.size(); i++) {
			if(score.get(i) == max ){
				j++;
				if(j > 1 ){
					list.add(score.get(i));
				}
			} else {
				list.add(score.get(i));
			}
		}
		sum+=max;
		teamSplit = teamSplit-1;
		return splitArray(list, team, m,teamSplit, sum);
	}
	
	public static void main(String[] args) {
		int[] arr = {18,5,15,18,11,15,9,7};
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Runnable task = new Runnable() {
			@Override
			public void run() {
				for (int j = 0; j < arr.length; j++) {
					System.out.println(arr[j]);
				}
			}
		};
		Callable<Integer> callableTask = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 0; i < arr.length; i++) {
					sum+=arr[i];
				}
				return sum;
			}
		};
		System.out.println("------runnable task------");
		executor.submit(task);//runnable task 
		
		System.out.println("------callable task------");
		
		Future<Integer>  out = executor.submit(callableTask);
		try {
			System.out.println("sum of out-->" + out.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
