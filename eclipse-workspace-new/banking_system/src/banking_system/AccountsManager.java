package banking_system;
import java.sql.Connection;
import java.util.Scanner;

public class AccountsManager {
	private Connection	connection;
	private Scanner scanner ;
	
	
	public AccountsManager(Connection connection, Scanner scanner) {
		this.connection = connection;
		this.scanner= scanner;
	}

}
