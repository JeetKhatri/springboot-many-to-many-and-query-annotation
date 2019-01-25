package com.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT u FROM User u")
	List<User> findAllUsers(Sort sort);
	
	//Indexed Query Parameters
	// JPQL
	@Query("select u from User u where u.name= ?1 or u.name= ?2")
	List<User> findByNamesIndexedJPQL(@Param("name1") String name1,@Param("name2") String name2);
		
	// Native sql
	@Query(value="select * from User where name= ? or name= ?",nativeQuery = true)
	List<User> findByNamesIndexedSQL(String name1, String name2);
	
	//Named Parameters
	// JPQL
	@Query("select u from User u where u.name= :name1 or u.name= :name2")
	List<User> findByNamesNamedJPQL(@Param("name1") String name1,@Param("name2") String name2);
	
	// Native sql
	@Query(value="select * from User where name= :name1 or name= :name2",nativeQuery = true)
	List<User> findByNamesNamedSQL(@Param("name1") String name1,@Param("name2") String name2);
	
	// Update Queries with @Modifying - JPQL
	@Modifying
	@Transactional
	@Query("update User u set u.number= :number where u.name= :name")
	int updateUserSetNumberForNameUsingJPQL(@Param("number") String number, @Param("name") String name);
	
	@Modifying
	@Transactional
	@Query(value = "update User set number = ? where name = ?", nativeQuery = true)
	int updateUserSetNumberForNameUsingSQL(String number, String name);
}
