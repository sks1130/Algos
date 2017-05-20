import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author sachin
 *
 */
class Employee{
	String name;
	Integer age;
	Employee(String name,Integer age){
		this.name = name;
		this.age = age;
	}
}
public class LambdaExpression  {
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("John", 23));
		empList.add(new Employee("Adam", 26));
		empList.add(new Employee("Rollins", 28));
		empList.add(new Employee("Richard", 26));
	     // old way of sorting  on name using anonymous class
		System.out.println("--- sorting on the name using anonymous class using comparator --- ");
		Collections.sort(empList, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		for (Employee employee : empList) {
			System.out.println(employee.name + " " + employee.age);
		}
		System.out.println("\n--- sorting on the age using lambda expression with type removing the anonymous class --- ");
		//Anonymous Inner class replaced with Lambda expression with type declaration and sorting on age
		Collections.sort(empList, (Employee e1 ,Employee e2) -> e1.age.compareTo(e2.age));
		for (Employee employee : empList) {
			System.out.println(employee.name + " " + employee.age);
		}
		System.out.println("\n--- sorting on the age using lambda expression without type removing the anonymous class --- ");
		//Anonymous Inner class replaced with Lambda expression with type declaration and sorting on age
		Collections.sort(empList, ( e1 , e2) -> e1.age.compareTo(e2.age));
		for (Employee employee : empList) {
			System.out.println(employee.name + " " + employee.age);
		}
		
		System.out.println("\n--- sorting on the name using sort of the List and lambda expression --- ");
		//Anonymous Inner class replaced with Lambda expression without type declaration and sorting on name
		Collections.sort(empList, (Employee e1 ,Employee e2) -> e1.age.compareTo(e2.age));
		empList.sort((e1,e2) -> e1.name.compareTo(e2.name));
		for (Employee employee : empList) {
			System.out.println(employee.name + " " + employee.age);
		}
	}
}
