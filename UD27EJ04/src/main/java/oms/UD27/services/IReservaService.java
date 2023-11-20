package oms.UD27.services;

import java.util.List;

import oms.UD27.dto.Reserva;

public interface IReservaService {
	//Metodos del CRUD
		public List<Reserva> listarReservas(); //Listar All 
		
		public Reserva guardarReserva(Reserva reserva);	//Guarda una reserva CREATE
		
		public Reserva reservaXID(int id); //Leer datos de una reserva READ
		
		public Reserva actualizarReserva(Reserva reserva); //Actualiza datos de la reserva UPDATE
		
		public void eliminarReserva(int id);// Elimina la reserva DELETE
}
