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

import oms.UD27.dto.Investigador;
import oms.UD27.services.InvestigadorServiceImpl;

@RestController
@RequestMapping("/investigadores")
public class InvestigadorController {
	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/all")
	public List<Investigador> listarMaquinas_registradoras(){
		return investigadorServiceImpl.listarInvestigadores();
	}
	
	
	@PostMapping("/add")
	public Investigador salvarInvestigador(@RequestBody Investigador investigador) {
		
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}
	
	
	@GetMapping("/{dni}")
	public Investigador InvestigadorXID(@PathVariable(name="dni") String id) {
		
		Investigador Investigador_xid= new Investigador();
		
		Investigador_xid=investigadorServiceImpl.investigadorXID(id);
		
		System.out.println("Investigador XID: "+Investigador_xid);
		
		return Investigador_xid;
	}
	
	@PutMapping("/{dni}")
	public Investigador actualizarInvestigador(@PathVariable(name="dni")String id,@RequestBody Investigador Investigador) {
		
		Investigador Investigador_seleccionado= new Investigador();
		Investigador Investigador_actualizado= new Investigador();
		
		Investigador_seleccionado= investigadorServiceImpl.investigadorXID(id);
		
		Investigador_seleccionado.setDni(Investigador.getDni());
		Investigador_seleccionado.setNombre_completo(Investigador.getNombre_completo());
		Investigador_seleccionado.setFacultad(Investigador.getFacultad());
		
		Investigador_actualizado = investigadorServiceImpl.actualizarInvestigador(Investigador_seleccionado);
		
		System.out.println("La investigador actualizada es: "+ Investigador_actualizado);
		
		return Investigador_actualizado;
	}
	
	@DeleteMapping("/{dni}")
	public void eliminarInvestigador(@PathVariable(name="dni")String id) {
		investigadorServiceImpl.eliminarInvestigador(id);
	}
}
