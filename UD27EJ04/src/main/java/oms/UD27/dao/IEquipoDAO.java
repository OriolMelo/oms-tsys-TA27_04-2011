package oms.UD27.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import oms.UD27.dto.Equipo;

public interface IEquipoDAO extends JpaRepository<Equipo, String>{
	
}
