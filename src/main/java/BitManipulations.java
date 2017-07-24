import java.util.concurrent.ThreadLocalRandom;

public class BitManipulations {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(ThreadLocalRandom.current().nextInt(100 + 1));
		}
	}
}