package me.luis.xbraintest.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import me.luis.xbraintest.model.Venda;
import me.luis.xbraintest.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {

	@Override
	public void criarVenda(Venda venda) {

	}

	@Override
	public List<Venda> getVendedoresVendas(LocalDate inicio, LocalDate fim) {
		return null;
	}

}