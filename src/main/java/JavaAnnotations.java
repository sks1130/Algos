/**
 * @hackerRank https://www.hackerrank.com/challenges/java-annotations
 * 
 */

/**
 * @author sachin.srivastava
 *
 */
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;import freemarker.log.SLF4JLoggerFactory;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
   String userRole() default "GUEST";
   int budget() default 100;
}

class FamilyMember {
   @FamilyBudget(userRole = "SENIOR" , budget = 100)
   public void seniorMember(int budget, int moneySpend) {
      System.out.println("Senior Member");
      System.out.println("Spend: " + moneySpend);
      System.out.println("Budget Left: " + (budget - moneySpend));
   }

   @FamilyBudget(userRole = "JUNIOR", budget = 50)
   public void juniorUser(int budget, int moneySpend) {
      System.out.println("Junior Member");
      System.out.println("Spend: " + moneySpend);
      System.out.println("Budget Left: " + (budget - moneySpend));
   }
}

public class JavaAnnotations {
	
	public static void annotationUse(){

	      Scanner in = new Scanner(System.in);
	      int testCases = Integer.parseInt(in.nextLine());
	      while (testCases > 0) {
	         String role = in.next();
	         int spend = in.nextInt();
	         try {
	            Class annotatedClass = FamilyMember.class;
	            Method[] methods = annotatedClass.getMethods();
	            for (Method method : methods) {
	               if (method.isAnnotationPresent(FamilyBudget.class)) {
	                  FamilyBudget family = method
	                        .getAnnotation(FamilyBudget.class);
	                  String userRole = family.userRole();
	                  int budgetLimit = family.budget();//~~Complete this line~~;
	                  if (userRole.equals(role)) {
	                     if(spend<= budgetLimit){
	                        method.invoke(FamilyMember.class.newInstance(),
	                              budgetLimit, spend);
	                     }else{
	                        System.out.println("Budget Limit Over");
	                     }
	                  }
	               }
	            }
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	         testCases--;
	      }
	}
   public static void main(String[] args) {
	   int[] arr = new int[]{3,1,4,2,7,4,5,8,9,3,10,3,12,45};
	  // quickSort(arr);
	   mergeSort(arr);
	   System.out.println(Arrays.toString(arr));
	   
   }
   
   public static void mergeSort(int[] arr){
	   mergeSort(arr,new int[arr.length], 0, arr.length-1);
   }
   public static void mergeSort(int[] arr,int[] temp, int leftStart , int rightEnd){
	   if(leftStart>= rightEnd){
		   return;
	   }
	   int mid = (leftStart + rightEnd)/2;
	   mergeSort(arr, temp, leftStart, mid);
	   mergeSort(arr, temp, mid+1, rightEnd);
	   merge(arr, temp, leftStart, rightEnd);
   }
   public static void merge(int[] arr , int[] temp , int leftStart , int rightEnd){
	   int leftEnd = (leftStart+rightEnd)/2;
	   int rightStart = leftEnd+1;
	   int size = rightEnd - leftStart + 1;
	   
	   int left = leftStart;
	   int right = rightStart;
	   int index = leftStart;
	   
	   while(left <= leftEnd && right<= rightEnd){
		   if(arr[left] <= arr[right]){
			   temp[index] = arr[left];
			   left++;
		   } else {
			   temp[index] = arr[right];
			   right++;
		   }
		   index++;
	   }
	   
	   System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
	   System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
	   System.arraycopy(temp, leftStart, arr, leftStart, size);
	   
   }
   public static void quickSort(int[] arr){
	   quickSort(arr, 0, arr.length-1);
   }
   
   public static void quickSort(int[] arr , int left , int right){
	   if(left>=right){
		   return;
	   }
	   int pivot = arr[(left+right)/2];
	   int index = partition(arr, left, right, pivot);
	   quickSort(arr, left, index-1);
	   quickSort(arr, index, right);
	   
   }
   public static int partition(int[] arr , int left , int right, int pivot){
	   while(left<= right){
		   while(arr[left] < pivot){
			   left++;
		   }
		   while(arr[right] > pivot){
			   right--;
		   }
		   if(left <= right){
			   swap(arr, left, right);
			   left++;
			   right--;
		   }
	   }
	   return  left;
   }
   public static void swap(int[] arr , int i , int j){
	   int temp = arr[i];
	   arr[i] = arr[j];
	   arr[j] = temp;
   }
}
