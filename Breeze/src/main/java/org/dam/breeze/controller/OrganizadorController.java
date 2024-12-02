package org.dam.breeze.controller;

import java.util.List;

import org.dam.breeze.modelos.Organizador;
import org.dam.breeze.repo.OrganizadorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizadorController {

	@Autowired
	private OrganizadorRepo organizadorRepo;

	@GetMapping(value = "/organizadores")
	public List<Organizador> getOrganizadores() {
		return organizadorRepo.findAll();
	}

	@PostMapping(value = "/organizador")
	public String saveOrganizador(@RequestBody Organizador organizador) {
		organizadorRepo.save(organizador);
		return "Registro guardado correctamente";

	}

	@PutMapping(value = "organizador/{idOrganizador}")
	public String updateOrganizador(@PathVariable Long idOrganizador, @RequestBody Organizador organizador) {
		Organizador updateOrganizador = organizadorRepo.findById(idOrganizador)
				.orElseThrow(() -> new RuntimeException("Organizador no encontrado: " + idOrganizador));
		updateOrganizador.setExperiencia(organizador.getExperiencia());
		updateOrganizador.setEspecialidad(organizador.getEspecialidad());
		updateOrganizador.setValoracion(organizador.getValoracion());
		organizadorRepo.save(updateOrganizador);
		return "Registro actualizado correctamente";
	}

	@DeleteMapping(value = "/organizador/{idOrganizador}")
	public String deleteOrganizador(@PathVariable Long idOrganizador) {
		Organizador deleteOrganizador = organizadorRepo.findById(idOrganizador)
				.orElseThrow(() -> new RuntimeException("Organizador no encontrado: " + idOrganizador));
		organizadorRepo.delete(deleteOrganizador);
		return "Organizador eliminado correctamenete" + idOrganizador;
	}
}
