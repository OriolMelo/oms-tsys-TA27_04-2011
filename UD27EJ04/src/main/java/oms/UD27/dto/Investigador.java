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
@Table(name="investigadores")
public class Investigador {
	@Id
	@Column(name = "dni")
	private String dni;
	@Column(name = "nom_Apels")
	private String nombre_completo;
	@ManyToOne
    @JoinColumn(name="facultad")
	private Facultad facultad;
	@OneToMany
	@JoinColumn(name = "dni")
	private List<Reserva> reserva;
	
	public Investigador() {
		
	}

	public Investigador(String dni, String nombre_completo, Facultad facultad, List<Reserva> reserva) {
		super();
		this.dni = dni;
		this.nombre_completo = nombre_completo;
		this.facultad = facultad;
		this.reserva = reserva;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
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
