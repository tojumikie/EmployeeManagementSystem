

import java.util.Scanner;

public class Debug {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			String choice = kb.nextLine(); 
			switch (choice) {
			case "1":
				break;
			case "2":
				loop = false;
				break;
			}
		}
		kb.close();
	}
	
}
