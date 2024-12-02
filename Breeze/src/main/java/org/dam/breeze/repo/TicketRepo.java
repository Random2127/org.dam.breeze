package org.dam.breeze.repo;

import org.dam.breeze.modelos.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {

}
