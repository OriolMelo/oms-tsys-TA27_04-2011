package oms.UD27.services;

import java.util.List;

import oms.UD27.dto.Investigador;

public interface IInvestigadorService {
	//Metodos del CRUD
		public List<Investigador> listarInvestigadores(); //Listar All 
		
		public Investigador guardarInvestigador(Investigador investigador);	//Guarda un investigador CREATE
		
		public Investigador investigadorXID(String id); //Leer datos de un investigador READ
		
		public Investigador actualizarInvestigador(Investigador investigador); //Actualiza datos del investigador UPDATE
		
		public void eliminarInvestigador(String id);// Elimina el investigador DELETE
}
