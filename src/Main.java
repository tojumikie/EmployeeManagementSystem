import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This program acts as a console application to manage employees (Employee Management System). The user and add, remove, modify,
 * and view employees in the system.
 * @author tojum
 *
 */
//driver method that will run the menu
public class Main {
	static Employee employee = new Employee();
	static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {
//		Employee employee = new Employee();
		menu();
//		Employee employee = new Employee("Toju", "Mikie", 1, "1995-03-25", 30000, "IT");
//		employee.addEmployee("Toju", "Mikie", 1, "1995-03-25", 30000, "IT");
//		employee.addEmployee("Toju", "Mikie", 1, "1995-03-25", 30000, "IT");
//		employee.addEmployee("Toju", "Mikie", 1, "1995-03-25", 30000, "IT");
//		employee.addEmployee("Toju", "Mikie", 1, "1995-03-25", 30000, "IT");
//		employee.addEmployee("Toju", "Mikie", 1, "1995-03-25", 30000, "IT");
//		employee.addEmployee("Toju", "Mikie", 1, "1995-03-25", 30000, "IT");
//		for(int i = 0; i < employee.emps.size(); i++) {
//			System.out.println(employee.emps.get(i));
//		}
//		Employee employee1 = new Employee("Toju", "Mikie", 2, "1995-03-25", 30000, "IT");
//		employee.addEmployee();
//		menu();
//		String date = "2022-01-30";
//		try {
//			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//			System.out.println(date1);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	//method that will display the menu
	public static void menu() {
		String selection = null;
//		Employee employee = new Employee();
		do {
			System.out.println("Welcome to the Employee Management System.");
			System.out.println("Press 1 to add an employee.");
			System.out.println("Press 2 to update employee information.");
			System.out.println("Press 3 to remove employees.");
			System.out.println("Press 4 to list employee information.");
			System.out.println("Press Q to quit.");
			selection = kb.nextLine();
			switch (selection) {
				case "1" -> addEmployeePrompt();
				case "2" -> updateEmployeeInfoPrompt();
				case "3" -> removeEmployeePrompt();
				case "4" -> employee.displayEmployees();
				case "Q", "q" -> System.out.println("Application terminated!");
				default -> System.out.println("Invalid option selected. Please select a valid option.\n");
			}			
		} while (!selection.equalsIgnoreCase("Q"));
	}
	//runs when an employee needs to be added to the system
	public static void addEmployeePrompt() {
		String firstName;
		String lastName;
		int id = 0;
		String DOE; //date of employment
		Date dateDOE = null;
		int salary = 0;
		String department;
		System.out.println("Enter first name of employee: ");
		firstName = kb.nextLine();
		System.out.println("Enter last name of employee: ");
		lastName = kb.nextLine();
		try {
			System.out.println("Enter id of employee: ");
			id = kb.nextInt();
			employee.checkForIDduplicates(id);
			kb.nextLine();
		}
		catch (InputMismatchException e) {
			System.out.println("You need to enter a number!");
		}
		System.out.println("Enter date of employment of employee: (type in the format: yyyy-mm-dd)");
		DOE = kb.nextLine();
		try {
			dateDOE = new SimpleDateFormat("yyyy-MM-dd").parse(DOE);
//			System.out.println(dateDOE);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Enter salary of employee as an integer: ");
			salary = kb.nextInt();
			kb.nextLine();
			if(salary < 0) throw new NegativeNumberException();
		} catch (NegativeNumberException e) {
			System.out.println("You didn't enter a positive number!");
			throw new IllegalStateException();
		}
		System.out.println("Enter department of employee: ");
		department = kb.nextLine();
		employee.addEmployee(firstName, lastName, id, dateDOE, salary, department);
	}
	//runs when an employee needs to be removed from the system
	public static void removeEmployeePrompt() {
		System.out.println("Which employee would you like to remove? Type the number");
		employee.displayEmployees();
		int number = kb.nextInt();
		kb.nextLine();
		employee.removeEmployees(number);
	}
	//runs when employee information needs to be updated
	public static void updateEmployeeInfoPrompt() {
		String firstName;
		String lastName;
		int id = 0;
		String DOE; //date of employment
		Date dateDOE = null;
		int salary;
		String department;
		System.out.println("Which employee would you like to update? Type the number");
		employee.displayEmployees();
		int number = kb.nextInt();
		kb.nextLine();
		System.out.println("Enter first name of employee: ");
		firstName = kb.nextLine();
		System.out.println("Enter last name of employee: ");
		lastName = kb.nextLine();
		System.out.println("Enter id of employee: ");
		try {
			id = kb.nextInt();
			kb.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("You need to enter a number!");
		}
		System.out.println("Enter date of employment of employee: (type in the format: yyyy-mm-dd)");
		DOE = kb.nextLine();
		try {
			dateDOE = new SimpleDateFormat("yyyy-MM-dd").parse(DOE);
//			System.out.println(dateDOE);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Enter salary of employee as an integer: ");
		try {
			salary = kb.nextInt();
			kb.nextLine();
			if(salary < 0) throw new NegativeNumberException();
		} catch (NegativeNumberException e) {
			System.out.println("You didn't enter a positive number!");
			throw new IllegalStateException();
		}
		System.out.println("Enter department of employee: ");
		department = kb.nextLine();
		employee.updateEmployees(number, firstName, lastName, id, dateDOE, salary, department);
	}
}