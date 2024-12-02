package org.dam.breeze.controller;

import java.util.List;

import org.dam.breeze.modelos.Proveedor;
import org.dam.breeze.repo.ProveedorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProveedorController {

	@Autowired
	private ProveedorRepo proveedorRepo;

	@GetMapping(value = "/proveedores")
	public List<Proveedor> getProveedores() {
		return proveedorRepo.findAll();
	}

	@PostMapping(value = "/proveedor")
	public String saveProveedor(@RequestBody Proveedor proveedor) {
		proveedorRepo.save(proveedor);
		return "Registro guardado correctamente";
	}

	@PutMapping(value = "/proveedor/{idProveedor}")
	public String updateProveedor(@PathVariable Long idProveedor, @RequestBody Proveedor proveedor) {
		Proveedor updateProveedor = proveedorRepo.findById(idProveedor)
				.orElseThrow(() -> new RuntimeException("Proveedor no encontrado: " + idProveedor));
		updateProveedor.setContacto(proveedor.getContacto());
		updateProveedor.setServicios(proveedor.getServicios());
		updateProveedor.setCosto(proveedor.getCosto());
		proveedorRepo.save(updateProveedor);
		return "Registro realizado correctamente";
	}

	@DeleteMapping(value = "/proveedor/{idProveedor}")
	public String deleteProveedor(@PathVariable Long idProveedor) {
		Proveedor deleteProveedor = proveedorRepo.findById(idProveedor)
				.orElseThrow(() -> new RuntimeException("Organizador no encontrado " + idProveedor));
		proveedorRepo.delete(deleteProveedor);
		return "Registro borrado correctamente.";
	}

}
