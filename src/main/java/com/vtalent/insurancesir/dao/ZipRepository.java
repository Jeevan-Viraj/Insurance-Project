package com.vtalent.insurancesir.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vtalent.insurancesir.model.UsaZipInfo;

@Repository
public interface ZipRepository extends JpaRepository<UsaZipInfo, Integer>{
	
	@Query("SELECT u FROM UsaZipInfo u WHERE u.zipCode = ?1")
	public UsaZipInfo findByZipCode(String zipCode);

}
