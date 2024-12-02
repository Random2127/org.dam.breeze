package org.dam.breeze.repo;

import org.dam.breeze.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Esta interfaz se encarga del CRUD
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

}
