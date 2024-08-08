package banking_system;

import java.sql.Connection;
import java.util.Scanner;

public class User {
	
	// As the object of this class is made a paramterized constructor is used to set or assign valus of passed arguments those are
	// Connection interface object and Scanner class object to make program effiecient 
	private Connection	connection;
	private Scanner scanner ;
	
	
	public User(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner= scanner;
	}
	
	
	
	public void register() {
		scanner.nextLine();
		System.out.println("Full Name:");
		String fullName = scanner.nextLine();
		System.out.println("Email: ");
		String email = scanner.nextLine();
		System.out.println("Password: ");
		String password = scanner.nextLine();
		
		
//		if(user.exists(email)) {
//			System.out.println("User is already registered for this email address !! ");
//			return ;
//		}
//		
//		String register_query ="INSERT into User(full_name , email,password ) VALUES (?,?,?);";
		
	}

}
