package Repository;

import java.sql.Connection;
import java.sql.SQLException;

import mapers.CarResultMapper;
import mapers.CustomerResultMapper;
import mapers.TransactionResultMapper;

public class RepositoryCatalog {
    
	private Connection connection;
	
	public RepositoryCatalog(Connection connection) {
		this.connection = connection;
	}

	public Repository GetCarRepository(){
		try {
			return new CarRepository(connection, new CarResultMapper());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Repository GetCustomerRepository(){
		try {
			return new CustomerRepository(connection, new CustomerResultMapper());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Repository GetTransactionRepository(){
		try {
			return new TransactionRepository(connection, new TransactionResultMapper());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
