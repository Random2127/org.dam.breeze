package org.dam.breeze.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Organizador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrganizador;
	@Column
	private String experiencia;
	@Column
	private String especialidad;
	@Column
	private String valoracion;

	public Long getIdOrganizador() {
		return idOrganizador;
	}

	public void setIdOrganizador(Long idOrganizador) {
		this.idOrganizador = idOrganizador;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

}
