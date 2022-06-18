
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * class that handles a lot of the operations for the employees, kind of like the "backend" code
 * @author tojum
 *
 */
public class Employee {
	private String firstName;
	private String lastName;
	private int id;
	private Date DOE; //date of employment
	private int salary;
	private String department;
	List<Employee> emps = new ArrayList<Employee>();
//	List<String> fname = new ArrayList<String>();
	
	//constructor
	public Employee(String firstName, String lastName, int id, Date doe, int salary, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		DOE = doe;
		this.salary = salary;
		this.department = department;
	}
	
	//getters, setters, and toString methods
	public Employee() {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", DOE=" + DOE
				+ ", salary=" + salary + ", department=" + department + "]";
	}
	public Date getDOE() {
		return DOE;
	}
	public void setDOE(Date doe) {
		DOE = doe;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	//add employee method
	public void addEmployee(String firstName, String lastName, int id, Date DOE, int salary, String department) {
		emps.add(new Employee(firstName, lastName, id, DOE, salary, department));
//		emps.add();
	}
	//show the employees
	public void displayEmployees() {
		long total = emps.stream().count();
		System.out.println(total + " rows total.");
		for(int i = 0, j = 1; i < emps.size(); i++, j++) {
			System.out.println(j + ": " + emps.get(i));
		}
//		int i = 1;
//		String index = emps.indexOf();
//		emps.stream().map(emps -> emps).forEach(emps -> System.out.println(emps));
	}
	//remove employees at a specific row
	public void removeEmployees(int number) {
		number = number++;
		emps.remove(number - 1);
	}
	//change employee information at a specific row
	public void updateEmployees(int number, String firstName, String lastName, int id, Date DOE, int salary, String department) {
		number = number++;
		emps.set(number - 1, new Employee(firstName, lastName, id, DOE, salary, department));
	}
	//checks for duplicates when trying to insert a second id for another employee. Can be improved.
	public void checkForIDduplicates(int numberToCheck) {
		for(int i = 0; i < emps.size(); i++) {
//			System.out.println(emps.get(i).id);
			if(numberToCheck == emps.get(i).id) {
				System.out.println("ID already exists!");
				throw new IllegalStateException("You were supposed to enter a different ID!");
			}
		}
	}
}
