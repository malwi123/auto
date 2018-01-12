package mapers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Transaction;

public class TransactionResultMapper implements ResultSetMapper{
	
	public Transaction map(ResultSet rs) throws SQLException {
		Transaction c = new Transaction();
		c.setId(rs.getInt("id"));
		c.setCarId(rs.getInt("carId"));
		c.setCustomerId(rs.getInt("CustomerId"));
		return c;
	}

}
