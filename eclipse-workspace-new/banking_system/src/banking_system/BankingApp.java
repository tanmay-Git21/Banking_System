package banking_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class BankingApp {
	
	
			private static final String password = "iloveSql_21";
			private static final String url = "jdbc:mysql://localhost:3306/banking_system";
			private static final String username = "root";
		
	public static void main(String []args) throws ClassNotFoundException,SQLException {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // This line is to load the driver from the class and if not found then throw Class not found error
			}catch(ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				//Below two lines are responsible to make objects of 1st Connection Interface and 2nd Scanner Class 
				//and to make resuabilty of this instances we passed this objects to other classes as well
				Connection connection = DriverManager.getConnection(url, username, password);
				Scanner scanner = new Scanner(System.in); 
				
				//Passing objects to others classes
				User user = new User(connection , scanner);
				Accounts accounts = new Accounts(connection ,scanner);
				AccountsManager accountManager = new AccountsManager(connection , scanner);
				
			}
			
		
}

