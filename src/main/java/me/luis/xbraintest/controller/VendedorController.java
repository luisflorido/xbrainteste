package me.luis.xbraintest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.luis.xbraintest.model.Vendedor;
import me.luis.xbraintest.service.VendedorService;

@RestController
public class VendedorController {

	@Autowired
	private VendedorService service;

	@GetMapping("/vendedor/{id}")
	public ResponseEntity<Vendedor> getVendedor(@PathVariable int id) {
		Vendedor v = service.getVendedor((long) id);
		if (v != null)
			return new ResponseEntity<Vendedor>(v, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/vendedor")
	public ResponseEntity<?> createVendedor(@RequestBody Map<String, ?> obj) {
		String nome = (String) obj.get("nome");
		Vendedor check = service.getVendedor(nome);
		if (check == null) {
			Vendedor v = service.createVendedor(nome);
			if (v != null)
				return new ResponseEntity<Object>(v.getId(), HttpStatus.CREATED);
			else
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Object>(HttpStatus.CONFLICT);
		}
	}
}
