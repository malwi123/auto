package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.IHaveId;
import mapers.ResultSetMapper;

public abstract class RepositoryBase implements Repository {
	
	protected Connection connection;
	protected Statement createTable;
	protected PreparedStatement insert;
	protected PreparedStatement selectAll;
	protected PreparedStatement update;
	protected PreparedStatement delete;
	
	ResultSetMapper mapper;
	
	protected RepositoryBase(Connection connection, ResultSetMapper mapper) throws SQLException {
		
		this.mapper = mapper;
		this.connection = connection;
		
		this.Init();
		
		try {
			createTable = connection.createStatement();
			this.createTable();
			insert = connection.prepareStatement(insertSql());
			update = connection.prepareStatement(updateSql());
			delete = connection.prepareStatement(deleteSql());
			selectAll = connection.prepareStatement(selectAllSql());
		} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	protected abstract void Init();
	protected abstract String selectAllSql();
	protected abstract String deleteSql();
	protected abstract String updateSql();
	protected abstract String insertSql();
	
	protected abstract void setupUpdate(IHaveId entity) throws SQLException;
	protected abstract void setupInsert(IHaveId person) throws SQLException;
	
	public void delete(IHaveId entity) {
		try{
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void add(IHaveId entity){
		try{
			setupInsert(entity);
			insert.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

	public void update(IHaveId entity) {

		try{
			setupUpdate(entity);
			update.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public List<IHaveId> getAll(){
		List<IHaveId> result = new ArrayList<IHaveId>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()){ 
				result.add(mapper.map(rs));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void createTable(){
		try {
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			boolean tableExists = false;
			while(rs.next()){ 
				if(rs.getString("TABLE_NAME").equalsIgnoreCase(tableName())){
					tableExists=true;
					break;
				}
			}
			if(!tableExists) createTable.executeUpdate(createTableSql());
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract String tableName();
	protected abstract String createTableSql();	
}