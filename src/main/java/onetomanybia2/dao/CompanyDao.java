package onetomanybia2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybia2.dto.Company;
import onetomanybia2.dto.Employee;

public class CompanyDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public void saveCompany(Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}

	public void updateCompany(int id, Company company) {
		EntityManager entityManager = getEntityManager();
		Company dbCompany = entityManager.find(Company.class, id);

		if (dbCompany != null) {
//			id is present
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			company.setId(id);
			company.setEmployees(dbCompany.getEmployees());
			entityManager.merge(company);
			entityTransaction.commit();
		} else {
			System.out.println("Sorry company id is not present");
		}
	}
	public void findCompany(int id) {
		EntityManager entityManager = getEntityManager();
		Company dbCompany = entityManager.find(Company.class, id);

		if (dbCompany != null) {
//			id is present
			System.out.println(dbCompany);
		} else {
			System.out.println("Sorry company id is not present");
		}

	}
	public void deleteCompany(int id) {
		EntityManager entityManager = getEntityManager();
		Company dbCompany = entityManager.find(Company.class, id);

		if (dbCompany != null) {
//			id is present
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			List<Employee> employees=dbCompany.getEmployees();
			
			for(Employee employee:employees) {
				employee.setCompany(null);
			}
			
			entityManager.remove(dbCompany);
			entityTransaction.commit();
		} else {
			System.out.println("Sorry company id is not present");
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
