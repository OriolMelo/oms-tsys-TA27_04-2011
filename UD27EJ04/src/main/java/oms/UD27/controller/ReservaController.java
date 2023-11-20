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

import oms.UD27.dto.Reserva;
import oms.UD27.services.ReservaServiceImpl;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/all")
	public List<Reserva> listarReserva(){
		return reservaServiceImpl.listarReservas();
	}
	
	
	@PostMapping("/add")
	public Reserva salvarReserva(@RequestBody Reserva reserva) {
		
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	
	@GetMapping("/{id}")
	public Reserva ReservaXID(@PathVariable(name="id") int id) {
		
		Reserva Reserva_xid= new Reserva();
		
		Reserva_xid=reservaServiceImpl.reservaXID(id);
		
		System.out.println("Reserva XID: "+Reserva_xid);
		
		return Reserva_xid;
	}
	
	@PutMapping("/{id}")
	public Reserva actualizarReserva(@PathVariable(name="id")int id,@RequestBody Reserva Reserva) {
		
		Reserva Reserva_seleccionado= new Reserva();
		Reserva Reserva_actualizado= new Reserva();
		
		Reserva_seleccionado= reservaServiceImpl.reservaXID(id);
		
		Reserva_seleccionado.setInvestigador(Reserva.getInvestigador());
		Reserva_seleccionado.setEquipo(Reserva.getEquipo());
		Reserva_seleccionado.setComienzo(Reserva.getComienzo());
		Reserva_seleccionado.setFin(Reserva.getFin());
		
		Reserva_actualizado = reservaServiceImpl.actualizarReserva(Reserva_seleccionado);
		
		System.out.println("El Reserva actualizado es: "+ Reserva_actualizado);
		
		return Reserva_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarReserva(@PathVariable(name="id")int id) {
		reservaServiceImpl.eliminarReserva(id);
	}
}
