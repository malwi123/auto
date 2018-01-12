package mapers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Car;

public class CarResultMapper implements ResultSetMapper{
	
	public Car map(ResultSet rs) throws SQLException {
			Car c = new Car();
			c.setId(rs.getInt("id"));
			c.setBrand(rs.getString("brand"));
			c.setModel(rs.getString("model"));
			c.setType("type");
			c.setPrice(rs.getInt("price"));
			return c;
		}

}
