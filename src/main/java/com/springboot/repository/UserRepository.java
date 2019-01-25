package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where u.name= :name1 or u.name= :name2")
	List<User> findByNamesNamedJPQL(@Param("name1") String name1,@Param("name2") String name2);
	
	
	@Query(value="select * from User where name= :name1 or name= :name2",nativeQuery = true)
	List<User> findByNamesNamedSQL(@Param("name1") String name1,@Param("name2") String name2);
}
