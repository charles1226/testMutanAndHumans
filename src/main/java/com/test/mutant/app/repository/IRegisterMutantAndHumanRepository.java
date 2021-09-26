package com.test.mutant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.mutant.app.entity.RegisterMutantAndHuman;

public interface IRegisterMutantAndHumanRepository extends JpaRepository<RegisterMutantAndHuman, Long> {

	@Query(value = "SELECT COUNT(1)  FROM REGISTER_MUTANT_AND_HUMAN WHERE HUMAN =:humanType ", nativeQuery = true)
	public Long getMutantsAndHumans(@Param("humanType") boolean humanType);

}
