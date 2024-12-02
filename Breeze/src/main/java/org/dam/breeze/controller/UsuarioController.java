package org.dam.breeze.controller;

import java.util.List;

import org.dam.breeze.modelos.Usuario;
import org.dam.breeze.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepo usuarioRepo;

	@GetMapping(value = "/usuarios")
	public List<Usuario> getUsers() {
		return usuarioRepo.findAll();
	}

	@PostMapping(value = "/usuario")
	public String saveUser(@RequestBody Usuario usuario) {
		usuarioRepo.save(usuario);
		return "Registro guardado correctamente.";

	}

	@PutMapping(value = "usuario/{idUsuario}")
	public String updateUser(@PathVariable Long idUsuario, @RequestBody Usuario usuario) {
		Usuario updateUser = usuarioRepo.findById(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + idUsuario));

		updateUser.setNombre(usuario.getNombre());
		updateUser.setCorreo(usuario.getCorreo());
		updateUser.setContraseña(usuario.getContraseña());
		usuarioRepo.save(updateUser);
		return "Registro actualizado correctamente";
	}

	@DeleteMapping(value = "/usuario/{idUsuario}")
	public String deleteUser(@PathVariable Long idUsuario) {
		Usuario deleteUser = usuarioRepo.findById(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + idUsuario));
		usuarioRepo.delete(deleteUser);
		return "Usuario eliminado " + idUsuario;
	}

}
