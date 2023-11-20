package oms.UD27.services;

import java.util.List;

import oms.UD27.dto.Equipo;

public interface IEquipoService {
	//Metodos del CRUD
	public List<Equipo> listarEquipos(); //Listar All 
	
	public Equipo guardarEquipo(Equipo equipo);	//Guarda un equipo CREATE
	
	public Equipo equipoXID(String id); //Leer datos de un equipo READ
	
	public Equipo actualizarEquipo(Equipo equipo); //Actualiza datos del equipo UPDATE
	
	public void eliminarEquipo(String id);// Elimina el equipo DELETE
}
