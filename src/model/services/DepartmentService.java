package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao("jdbc:mysql://localhost:3306/coursejdbc?useSSL=false", "root", "1234567");

	public List<Department> findAll() {
		return dao.findAll();
	}
}
