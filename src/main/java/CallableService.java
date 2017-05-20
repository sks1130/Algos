import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 */

/**
 * @author sachin
 * @param <T>
 *
 */
public class  CallableService implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return Thread.currentThread().getName();
	}
	public static void main(String[] args) {
		Long start = new Date().getTime();
		System.out.println("startTime::" + start);
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<String>> futureList  = new ArrayList<>();
		Callable<String> callable = new CallableService();
		for (int i = 0; i < 50; i++) {
			Future<String> futureSubmit = executor.submit(callable);
			futureList.add(futureSubmit);
		}
		System.out.println("futureList=" + futureList.size());
		int i=1;
		for (Future<String> future : futureList) {
			try {
				System.out.println("i=" + i + " and " + new Date() + ":::" + future.get() + " :: and " + future.isDone() );
				i++;
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
		Long end = new Date().getTime();
		System.out.println("end::" + end);
		System.out.println("timetaken in ms = " + (end - start) + " and in seconds=" + (end-start)/1000);
	}
}
