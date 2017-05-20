/**
 * 
 */

/**
 * @author sachin
 *
 */
class TestDeadLock2 {
	
	public  synchronized void method1(){
		System.out.println("c2-method1");
	}
	public  synchronized void method2(){
		System.out.println("c2-method2");
	}
}
public class TestDeadLock {
	
	public  synchronized void method1(){
		System.out.println("method1");
	}
	public  synchronized void method2(){
		System.out.println("method2");
	}
	
	public static void main(String[] args) {
		TestDeadLock t1 = new TestDeadLock();
		TestDeadLock2 t2 = new TestDeadLock2();
		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				t1.method1();
				t2.method2();
				
			}
		});
		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				t1.method1();
				t2.method2();
			}
		});
		th2.start();
		th1.start();
	}
}
