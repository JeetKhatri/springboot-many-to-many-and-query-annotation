package com.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT u FROM User u")
	List<User> findAllUsers(Sort sort);
	
	//Indexed Query Parameters
	// JPQL
	@Query("select u from User u where u.name= ?1 or u.name= ?2")
	List<User> findByNamesIndexedJPQL(@Param("name1") String name1,@Param("name2") String name2);
		
	// Native sql
	@Query(value="select * from User where name= ?1 or name= ?2",nativeQuery = true)
	List<User> findByNamesIndexedSQL(@Param("name1") String name1,@Param("name2") String name2);
	
	//Named Parameters
	// JPQL
	@Query("select u from User u where u.name= :name1 or u.name= :name2")
	List<User> findByNamesNamedJPQL(@Param("name1") String name1,@Param("name2") String name2);
	
	// Native sql
	@Query(value="select * from User where name= :name1 or name= :name2",nativeQuery = true)
	List<User> findByNamesNamedSQL(@Param("name1") String name1,@Param("name2") String name2);
}
