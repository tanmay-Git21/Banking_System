package banking_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


//This class has three methods 
//1 register method - which will register user while taking his name , email, password and also check if it already exists in database using his enterd emial by using another method called user_exists
//2 login method - this method is to login that user who has alreadyd registerd
//3 user_exists method 




public class User {
	
	// As the object of this class is made a paramterized constructor is used to set or assign valus of passed arguments those are
	// Connection interface object and Scanner class object to make program effiecient 
	private Connection	connection;
	private Scanner scanner ;
	private String Email;
	
	
	public User(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner= scanner;
	}
	
	
	
	public void register() {
		scanner.nextLine();
		System.out.println("Full Name:");
		String full_name = scanner.nextLine();
		System.out.println("Email: ");
		String email = scanner.nextLine();
		System.out.println("Password: ");
		String password = scanner.nextLine();
		
		// this condition is to check weather the user with same email id is already registerd or not 
		if(user_exists(email)) {
			System.out.println("User is already registered for this email address !! ");
			return ;
		}
		// this is register query with variable parameters
		String register_query ="INSERT into User(full_name , email,password ) VALUES (?,?,?);";
		
		try {
			PreparedStatement  preparedStatement = connection.prepareStatement (register_query);
			
			preparedStatement.setString(1,full_name );
			preparedStatement.setString(2,email);
			preparedStatement.setString(3,password);
			
			// this try catch block is to prepare a statemnt or like cook a statement which is to be served to sql
			int affectedRows = preparedStatement.executeUpdate();
			if(affectedRows > 0 ) {
				System.out.println("Registration Succesfull");
				
			}else {
				System.out.println("Registration Failed");
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
	}
	
	public String login() { // this method has return type string because if user has correctly been logged as per the database then his email will 
		// be used to access his information and manipulate his data thorough other classes
		
		scanner.nextLine();
		System.out.println("Email: ");
		String email = scanner.nextLine();
		System.out.println("Password: ");
		String password = scanner.nextLine();
		String login_query = "SELECT * FROM User WHERE email= ? AND password = ?;";
		
		
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(login_query);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return email;
			}else {
				return null;	
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean user_exists(String email) {
		
		String exist_query = "Select * From user WHERE email = ?;";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(exist_query);
			prepareStatement.setString(1,email);
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
