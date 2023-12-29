package onetomanybia2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybia2.dto.Company;
import onetomanybia2.dto.Employee;

public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	
	public void saveEmployee(int companyId,Employee employee) {
		EntityManager  entityManager=getEntityManager();
		Company dbCompany=entityManager.find(Company.class, companyId);
		if(dbCompany!=null) {
//			id is present then ican add the employee
			
//			1.add employee
//			2.update the company details
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(employee);
			List<Employee> employees=dbCompany.getEmployees();
			employees.add(employee);
			
			dbCompany.setEmployees(employees);
			
			entityTransaction.commit();
		}else{
			System.out.println("Sorry that id is not present for Company");
		}
	}
	
	public void updateEmployee(int id,Employee employee) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			employee.setId(id);
	        employee.setCompany(dbEmployee.getCompany());
			entityManager.merge(employee);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	public void findEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
//			id is present
			System.out.println(dbEmployee);
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	public void deleteEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
//			id is present
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			entityManager.remove(dbEmployee);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
