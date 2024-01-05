package onetomanybia2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybia2.dao.CompanyDao;
import onetomanybia2.dto.Company;
import onetomanybia2.dto.Employee;

public class CompEmpCont {
public static void main(String[] args) {
	
//	Company company=new Company();
//	company.setId(1);
//	company.setName("TYSS");
//	company.setGst("tyss@123");
//	
//	Employee employee1=new  Employee();
//	employee1.setId(1);
//	employee1.setName("Deepika");
//	employee1.setAddress("MH");
//	employee1.setCompany(company);
//	
//	
//	Employee employee2=new  Employee();
//	employee2.setId(3);
//	employee2.setName("sudarshan");
//	employee2.setAddress("MH");
//	employee2.setCompany(company);
//	
//	
//	List<Employee> employees=new ArrayList<Employee>();
//	employees.add(employee1);
//	employees.add(employee2);
//	
//	company.setEmployees(employees);
//	
//	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
//	EntityManager entityManager=entityManagerFactory.createEntityManager();
//	EntityTransaction entityTransaction=entityManager.getTransaction();
//	entityTransaction.begin();
//	
//	entityManager.persist(employee1);
//	entityManager.persist(employee2);
//	entityManager.persist(company);
//	
//	entityTransaction.commit();
//	
//	
//	
	CompanyDao companyDao=new  CompanyDao();
	companyDao.deleteCompany(1);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
