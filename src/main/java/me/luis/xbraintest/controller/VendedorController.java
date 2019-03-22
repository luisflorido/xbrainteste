package me.luis.xbraintest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import me.luis.xbraintest.model.Vendedor;
import me.luis.xbraintest.service.VendedorService;

@RestController
public class VendedorController {

	@Autowired
	private VendedorService service;

	@GetMapping("/vendedor/{id}")
	public ResponseEntity<Vendedor> getVendedor(@PathVariable int id) {
		System.out.println(id);
		return new ResponseEntity<Vendedor>(service.getVendedor((long) id), HttpStatus.OK);
	}

}
