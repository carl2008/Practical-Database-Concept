package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
	// add a method to sort by last name
	List<Employee> findAllByOrderByLastNameAsc();

	// add a method for search by keyword
	@Query(value = "SELECT * FROM employee e WHERE e.first_name LIKE %:keyword% OR e.last_name LIKE %:keyword%", nativeQuery = true)
	List<Employee> findByKeyword(@Param("keyword") String keyword);
}
