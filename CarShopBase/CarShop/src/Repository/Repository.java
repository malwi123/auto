package Repository;

import java.util.List;

import domain.IHaveId;

public interface Repository {

	public void delete(IHaveId item);

	public List<IHaveId> getAll();
	
	public void add(IHaveId item);
	
	public void update(IHaveId item);
	
	public void createTable();

}
