package oms.UD27.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oms.UD27.dto.Equipo;
import oms.UD27.services.EquipoServiceImpl;

@RestController
@RequestMapping("/equipos")
public class EquipoController {
	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	
	@GetMapping("/all")
	public List<Equipo> listarEquipos(){
		return equipoServiceImpl.listarEquipos();
	}
	
	
	@PostMapping("/add")
	public Equipo salvarEquipo(@RequestBody Equipo equipo) {
		
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	
	
	@GetMapping("/{num_Serie}")
	public Equipo EquipoXID(@PathVariable(name="num_Serie") String id) {
		
		Equipo Equipo_xid= new Equipo();
		
		Equipo_xid=equipoServiceImpl.equipoXID(id);
		
		System.out.println("Equipo XID: "+Equipo_xid);
		
		return Equipo_xid;
	}
	
	@PutMapping("/{num_Serie}")
	public Equipo actualizarEquipo(@PathVariable(name="num_Serie")String id,@RequestBody Equipo Equipo) {
		
		Equipo Equipo_seleccionado= new Equipo();
		Equipo Equipo_actualizado= new Equipo();
		
		Equipo_seleccionado= equipoServiceImpl.equipoXID(id);

		Equipo_seleccionado.setNum_serie(Equipo.getNum_serie());
		Equipo_seleccionado.setNombre(Equipo.getNombre());
		Equipo_seleccionado.setFacultad(Equipo.getFacultad());
		
		Equipo_actualizado = equipoServiceImpl.actualizarEquipo(Equipo_seleccionado);
		
		System.out.println("El Equipo actualizado es: "+ Equipo_actualizado);
		
		return Equipo_actualizado;
	}
	
	@DeleteMapping("/{num_Serie}")
	public void eliminarEquipo(@PathVariable(name="num_Serie")String id) {
		equipoServiceImpl.eliminarEquipo(id);
	}
}
