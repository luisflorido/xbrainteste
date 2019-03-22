package me.luis.xbraintest.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import me.luis.xbraintest.model.RetornoVendas;
import me.luis.xbraintest.model.Venda;
import me.luis.xbraintest.model.Vendedor;
import me.luis.xbraintest.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {

	@Override
	public Vendedor getVendedor(Long id) {
		return null;
	}

	@Override
	public List<Vendedor> getVendedores() {
		return null;
	}

	@Override
	public List<Venda> getVendas(Long idVendedor, LocalDate inicio, LocalDate fim) {
		return null;
	}

	@Override
	public List<RetornoVendas> getVendas(LocalDate inicio, LocalDate fim) {
		return null;
	}

	@Override
	public int getTotalVendas(Long idVendedor, LocalDate inicio, LocalDate fim) {
		return 0;
	}

	@Override
	public double getValorVendas(Long idVendedor, LocalDate inicio, LocalDate fim) {
		return 0;
	}

	@Override
	public double getMediaDiariaVendas(Long idVendedor, LocalDate inicio, LocalDate fim) {
		return 0;
	}

}
