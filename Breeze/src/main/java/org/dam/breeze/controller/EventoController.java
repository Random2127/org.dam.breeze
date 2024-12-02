package org.dam.breeze.controller;

import java.util.List;

import org.dam.breeze.modelos.Evento;
import org.dam.breeze.repo.EventoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventoController {

	@Autowired
	private EventoRepo eventoRepo;

	@GetMapping(value = "/eventos")
	public List<Evento> getOrganizadores() {
		return eventoRepo.findAll();
	}

	@PostMapping(value = "/evento")
	public String saveEvento(@RequestBody Evento evento) {
		eventoRepo.save(evento);
		return "Registro guardado correctamente";
	}

	@PutMapping(value = "/evento/{idEvento}")
	public String updateEvento(@PathVariable Long idEveLong, @RequestBody Evento evento) {
		Evento updateEvento = eventoRepo.findById(idEveLong)
				.orElseThrow(() -> new RuntimeException("Evento no encontrado"));
		updateEvento.setNombreEvento(evento.getNombreEvento());
		updateEvento.setFecha(evento.getFecha());
		updateEvento.setUbicacion(evento.getUbicacion());
		eventoRepo.save(updateEvento);
		return "El evento ha sido modificado corretamente";
	}

	@DeleteMapping(value = "/evento/{idEvento}")
	public String deleteEvento(@PathVariable Long idEveLong) {
		Evento deleteEvento = eventoRepo.findById(idEveLong)
				.orElseThrow(() -> new RuntimeException("Evento  no encontrado"));
		eventoRepo.delete(deleteEvento);
		return "El evento ha sido eliminado correctamente";
	}
}
