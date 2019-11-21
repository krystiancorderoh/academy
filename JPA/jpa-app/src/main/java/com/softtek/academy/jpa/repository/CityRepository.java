package com.softtek.academy.jpa.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softtek.academy.jpa.domain.model.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

	@Query(value="select c.* from city c where c.state_id=1", nativeQuery=true)
	Page<CityEntity> findAguascalientesCities(Pageable pageable);
	

	@Query(value="select c from CityEntity c where c.state.id=2")
	Page<CityEntity> findBajaCaliforniaCities(Pageable pageable);
	
	@Query(value="select c from CityEntity c inner join c.state e where e.description='Colima'")
	Page<CityEntity> findColimaCities(Pageable pageable);
	
	@Query(value="select c from CityEntity c where c.state.id=:stateId")
	Page<CityEntity> findCitiesByStateId(Pageable pageable, @Param("stateId") Long stateId);
	
	Page<CityEntity> findById(Pageable pageable, Long id);
	
	@Query(value="select c from CityEntity c where c.state.id= ?1")
	Page<CityEntity> findCitiesByStateIdAlternative(Pageable pageable, Long stateId);
	
	@Query(value="select c from CityEntity c where c.state.description IN :stateNames")
	Page<CityEntity> findCitiesByStateNames(Pageable pageable, @Param("stateNames") Collection<String> names);
	
	
}
