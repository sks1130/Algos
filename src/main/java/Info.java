/**
 * 
 */

/**
 * @author sachin
 *
 */
public class Info implements Cloneable {

	private String name;
	private Double salary;
	private Integer age;
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


}
