package org.dam.breeze.controller;

import java.util.List;

import org.dam.breeze.modelos.Ticket;
import org.dam.breeze.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

	@Autowired
	private TicketRepo ticketRepo;

	@GetMapping
	public List<Ticket> getTickets() {
		return ticketRepo.findAll();
	}

	@PostMapping
	public String saveTicket(@RequestBody Ticket ticket) {
		ticketRepo.save(ticket);
		return "Registro guardado correctamente";
	}

	@PutMapping
	public String updateTicket(@PathVariable Long idTicket, @RequestBody Ticket ticket) {
		Ticket updateTicket = ticketRepo.findById(idTicket)
				.orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
		updateTicket.setIdUsuario(ticket.getIdUsuario());
		updateTicket.setIdEvento(ticket.getIdEvento());
		updateTicket.setFechaInscripcion(ticket.getFechaInscripcion());
		return "Registro modificaco corectamente";
	}

	@DeleteMapping
	public String deleteTicket(@PathVariable Long idTicket) {
		Ticket deleteTicket = ticketRepo.findById(idTicket)
				.orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
		ticketRepo.delete(deleteTicket);
		return "Registro borrado correctamenete";
	}
}
