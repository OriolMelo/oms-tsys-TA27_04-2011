package oms.UD27.services;

import java.util.List;

import oms.UD27.dto.Facultad;

public interface IFacultadService {
	//Metodos del CRUD
			public List<Facultad> listarFacultades(); //Listar All 
			
			public Facultad guardarFacultad(Facultad facultad);	//Guarda una facultad CREATE
			
			public Facultad facultadXID(int id); //Leer datos de una facultad READ
			
			public Facultad actualizarFacultad(Facultad facultad); //Actualiza datos de la facultad UPDATE
			
			public void eliminarFacultad(int id);// Elimina la facultad DELETE
}
