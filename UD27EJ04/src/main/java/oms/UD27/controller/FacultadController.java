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

import oms.UD27.dto.Facultad;
import oms.UD27.services.FacultadServiceImpl;

@RestController
@RequestMapping("/facultades")
public class FacultadController {
	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	
	@GetMapping("/all")
	public List<Facultad> listarFacultades(){
		return facultadServiceImpl.listarFacultades();
	}
	
	
	@PostMapping("/add")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {
		
		return facultadServiceImpl.guardarFacultad(facultad);
	}
	
	
	@GetMapping("/{codigo}")
	public Facultad FacultadXID(@PathVariable(name="codigo") int id) {
		
		Facultad Facultad_xid= new Facultad();
		
		Facultad_xid=facultadServiceImpl.facultadXID(id);
		
		System.out.println("Facultad XID: "+Facultad_xid);
		
		return Facultad_xid;
	}
	
	@PutMapping("/{codigo}")
	public Facultad actualizarFacultad(@PathVariable(name="codigo")int id,@RequestBody Facultad Facultad) {
		
		Facultad Facultad_seleccionado= new Facultad();
		Facultad Facultad_actualizado= new Facultad();
		
		Facultad_seleccionado= facultadServiceImpl.facultadXID(id);
		
		Facultad_seleccionado.setNombre(Facultad.getNombre());
		
		Facultad_actualizado = facultadServiceImpl.actualizarFacultad(Facultad_seleccionado);
		
		System.out.println("El Facultad actualizado es: "+ Facultad_actualizado);
		
		return Facultad_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eliminarFacultad(@PathVariable(name="codigo")int id) {
		facultadServiceImpl.eliminarFacultad(id);
	}
}
