import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test
{
	public static void main(String args[] ) throws Exception {
		int N = 0, Q =0;
		int[] A = null;
		int[] B = null;
		try {
			// Get the object of DataInputStream
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String line = "";
			int i = 1;
			int k =0;
			while ((line = br.readLine()) != null ){
				if(line.isEmpty()){
					continue;
				}
				String[] strArry = line.split("\\s+");
				if(i == 1){
					N = Integer.parseInt(strArry[0]);
					Q = Integer.parseInt(strArry[1]);
					if((N< 1) || (Q< 1) || (N > 100000) || (Q > 1000000)){
						System.out.println("Invalid arguments");
						return;
					}
					A = new int[N];
					B = new int[Q];
				}
				if(i == 2){
					for (int j = 0; j < N; j++) {
						A[j] = Integer.parseInt(strArry[j]);
					}
				}
				if(i>2 && k< Q){
					B[k] =  Integer.parseInt(strArry[0]);
					k++;
				} 
				if(k == Q){
					isr.close();
					break;
				}
				i++;
			}
			for (int q = 0; q < Q; q++) {
				int in = B[q];
				if(in < 0 || in > 100000){
					System.out.println("Invalid arguments");
					return;
				}
				System.out.println(productOfTwoPrimes(A, in));
			}
		} catch (Exception e) {
			System.out.println("exception::" + e.getMessage());
		}
	}
	public static String productOfTwoPrimes(int[] arr , int inputNumber){
		if(arr == null || arr.length == 0 || inputNumber<=1){
			return "NO";
		}
		for (int i = 0; i < arr.length; i++) {
			if(checkMultiplierOfPrime(inputNumber, arr[i])){
				return "YES";
			}
		}
		return "NO";
	}
	 public static boolean isPrimeNumber(int number){
	    	if(number<=1){
	    		return false;
	    	}
	    	for(int i=2; i<=number/2; i++){
	    		if(number % i == 0){
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	public static boolean checkMultiplierOfPrime(int n){
		int k = (int) Math.sqrt(n);
		for (int i = k; i >= 2; i--) {
			if(n % i == 0){
				int j = n/i;
				if(isPrimeNumber(i) && isPrimeNumber(j)){
					return true;
				}
			}
		}
		return false;
	}
	public static  boolean checkMultiplierOfPrime(int i , int j ){
		if(i%j == 0){
			int k  = i/j;
			if(checkMultiplierOfPrime(k)){
				return true;
			} else {
				return checkMultiplierOfPrime(k, j);
			}
		} else {
			return false;
		}
	}
	public static void swap(int[] arr , int i , int j){
		int temp =arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
    public static int subArrayLength(int N , int[] bitsArray){
        if(bitsArray == null || bitsArray.length == 0 || N!=bitsArray.length){
            return 0;
        }
    	int j=0;
    	for (int i = bitsArray.length-1; i >=0 ; i--) {
    		if(bitsArray[i] != 0 && bitsArray[i]!=1){
    			return 0;
    		}
    		if((i-1)>=0 && bitsArray[i] > bitsArray[i-1]){
    			swap(bitsArray, i, i-1);
    		} else {
    			j++;
    		}
		}
		return j;
    }
}