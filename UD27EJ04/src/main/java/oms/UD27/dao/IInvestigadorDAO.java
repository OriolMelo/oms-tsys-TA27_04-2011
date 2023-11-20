package oms.UD27.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import oms.UD27.dto.Investigador;

public interface IInvestigadorDAO extends JpaRepository<Investigador, String>{
	
}
