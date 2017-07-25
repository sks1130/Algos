import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author sachin
 *
 */
public class ForkJoin extends RecursiveTask<Integer> {

	private static final long serialVersionUID = -8328882557807070491L;

	@Override
	protected Integer compute() {
		System.out.println("calling  ForkJoin class compute method");
		
		return null;
	}
	
	public static void main(String[] args) {
		ForkJoin forkJoin = new ForkJoin();
		forkJoin.fork();
		A a = forkJoin.new A();
		a.compute();
	}
	
	class A extends RecursiveAction {

		private static final long serialVersionUID = -4680888560856586914L;

		@Override
		protected void compute() {
			System.out.println("calling  A class compute method");
		}
		
	}

}
