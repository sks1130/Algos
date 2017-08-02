import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sachin.srivastava
 * tek9g.blogspot.com
 *
 */
public class ProducerConsumer extends Thread{
	
	static Queue<Integer> queue = new LinkedList<>();
	private static final int capacity = 10;
	private static  int counter = 1;
	public static void main(String[] args) {
		///starting the producer and consumer
		new Producer().start();
		new Consumer().start();
	}

	static class Producer extends Thread {
		public void run(){
			for ( ;;) {
				try {
					Thread.sleep(2000);
					synchronized (queue) {
						if( queue.size() <= capacity){
							queue.add(counter);
							System.out.println("queue added counter produced=" + counter);
							counter++;
						} else if(queue.size() > capacity)  {
							queue.remove(queue.size()-1);
							System.out.println("queue is full so can't produce new element");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	static class Consumer extends Thread {
		public void run(){
			for (;;) {
				try {
					Thread.sleep(2000);
					synchronized (queue) {
						if(!queue.isEmpty()){
							Integer head = queue.remove();
							System.out.println("queue pop counter consumer=" + head);
						} else {
							System.out.println("queue is empty so nothing to pop for consumers");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
