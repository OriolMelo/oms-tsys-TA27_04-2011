package oms.UD27.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipo {

	@Id
	@Column(name = "num_Serie")
	private String num_serie;
	@Column(name = "nombre")
	private String nombre;
	@ManyToOne
    @JoinColumn(name="facultad")
	private Facultad facultad;
	@OneToMany
	@JoinColumn(name = "dni")
	private List<Reserva> reserva;
	
	public Equipo() {
		
	}

	public Equipo(String num_serie, String nombre, Facultad facultad, List<Reserva> reserva) {
		super();
		this.num_serie = num_serie;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reserva = reserva;
	}

	public String getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}
	
}
