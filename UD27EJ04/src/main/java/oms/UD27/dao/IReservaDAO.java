package oms.UD27.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import oms.UD27.dto.Reserva;

public interface IReservaDAO extends JpaRepository<Reserva, Integer>{
	
}
