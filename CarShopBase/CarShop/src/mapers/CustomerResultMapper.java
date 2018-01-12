package mapers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Customer;

public class CustomerResultMapper implements ResultSetMapper{
	
	public Customer map(ResultSet rs) throws SQLException {
		Customer c = new Customer();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setAdress(rs.getString("adress"));
		c.setPhone(rs.getString("phone"));
		return c;
	}

}
