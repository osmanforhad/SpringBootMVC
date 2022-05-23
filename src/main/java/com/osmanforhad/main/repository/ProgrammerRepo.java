package com.osmanforhad.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.osmanforhad.main.model.Programmer;

@Repository
public interface ProgrammerRepo extends	JpaRepository<Programmer, Integer> {

	//find programmer by using Query DSL format
	List<Programmer> findBypLang(String pLang);
	
	//find programmer by using Query Annotation / custom Query
	@Query("from Programmer where pName= ?1")
	List<Programmer> findProgrammer(String pName);

}
