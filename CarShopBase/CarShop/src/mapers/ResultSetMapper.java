package mapers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.IHaveId;

public interface ResultSetMapper {

	public IHaveId map(ResultSet rs) throws SQLException;
}
