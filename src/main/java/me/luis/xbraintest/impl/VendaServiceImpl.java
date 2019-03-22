package me.luis.xbraintest.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.luis.xbraintest.model.Venda;
import me.luis.xbraintest.repository.VendaRepository;
import me.luis.xbraintest.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository repository;

	@Override
	public void criarVenda(Venda venda) {
		repository.save(venda);
	}

	@Override
	public List<Venda> getVendedoresVendas(LocalDate inicio, LocalDate fim) {
		return repository.findAll().stream().filter((v) -> v.getDataVenda()
				.after(Date.from(inicio.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
				&& v.getDataVenda().before(Date.from(fim.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())))
				.collect(Collectors.toList());
	}

}
