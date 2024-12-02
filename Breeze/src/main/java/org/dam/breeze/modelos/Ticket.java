package org.dam.breeze.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTicket;
	@Column
	private String idUsuario;
	@Column
	private String idEvento;
	@Column
	private long fechaInscripcion;

	public Long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

	public long getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(long fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

}
