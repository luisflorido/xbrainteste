package me.luis.xbraintest.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.luis.xbraintest.model.RetornoVendas;
import me.luis.xbraintest.model.Venda;
import me.luis.xbraintest.service.VendaService;
import me.luis.xbraintest.service.VendedorService;

@RestController
public class VendaController {

	private @Autowired VendaService service;
	private @Autowired VendedorService vendedorService;

	@PostMapping("/venda")
	public ResponseEntity<?> criarVenda(@RequestBody Venda venda) {
		Venda v = service.createVenda(venda);
		if (v != null)
			return new ResponseEntity<Object>(v.getId(), HttpStatus.CREATED);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/venda/{inicio}/{fim}")
	public ResponseEntity<List<RetornoVendas>> getVendas(@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate inicio,
			@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate fim) {
		List<RetornoVendas> rv = vendedorService.getVendas(inicio, fim);
		if (rv != null)
			return new ResponseEntity<>(vendedorService.getVendas(inicio, fim), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
