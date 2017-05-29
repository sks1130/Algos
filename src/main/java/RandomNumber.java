import java.util.concurrent.ThreadLocalRandom;
public class RandomNumber {

	public static void main(String[] args) {
		
		System.out.println(ThreadLocalRandom.current().nextInt(1, 99999+ 1));

	}

}
