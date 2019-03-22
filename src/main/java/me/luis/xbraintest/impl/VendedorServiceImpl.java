package me.luis.xbraintest.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.luis.xbraintest.model.RetornoVendas;
import me.luis.xbraintest.model.Venda;
import me.luis.xbraintest.model.Vendedor;
import me.luis.xbraintest.repository.VendaRepository;
import me.luis.xbraintest.repository.VendedorRepository;
import me.luis.xbraintest.service.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {

	private @Autowired VendedorRepository repository;
	private @Autowired VendaRepository vendaRepository;

	@Override
	public Vendedor createVendedor(String nome) {
		Vendedor v = new Vendedor(nome);
		try {
			repository.save(v);
		}catch(Exception e) {
			return null;
		}
		return v;
	}

	@Override
	public Vendedor getVendedor(Long id) {
		Vendedor v = null;
		try {
			v = repository.getOne(id);
			//Por algum motivo o erro só é tratado ao tentar alguma interação com o objeto retornado, portanto, forcei-o usando o toString.
			v.toString();
		}catch(EntityNotFoundException e) {
			return null;
		}
		return v;
	}

	@Override
	public int getTotalVendas(Long idVendedor, LocalDate inicio, LocalDate fim) {
		return (int) getVendas(idVendedor, inicio, fim).stream().count();
	}

	@Override
	public double getValorVendas(Long idVendedor, LocalDate inicio, LocalDate fim) {
		double[] vendas = { 0 };
		getVendas(idVendedor, inicio, fim).forEach((v) -> {
			vendas[0] += v.getValor() * 100;
		});
		return vendas[0] / 100;

	}

	@Override
	public double getMediaDiariaVendas(Long idVendedor, LocalDate inicio, LocalDate fim) {

		return (getValorVendas(idVendedor, inicio, fim) / (inicio.until(fim.plusDays(1), ChronoUnit.DAYS)));
	}

	@Override
	public List<Venda> getVendas(Long idVendedor, LocalDate inicio, LocalDate fim) {
		return vendaRepository.findAll().stream().filter((v) -> v.getVendedor().getId() == idVendedor
				&& v.getDataVenda().after(Date.from(inicio.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))
				&& v.getDataVenda()
						.before(Date.from(fim.plusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())))
				.collect(Collectors.toList());
	}

	@Override
	public List<Vendedor> getVendedores() {
		return repository.findAll();
	}

	@Override
	public List<RetornoVendas> getVendas(LocalDate inicio, LocalDate fim) {
		List<RetornoVendas> rv = new ArrayList<>();
		for (Vendedor v : getVendedores()) {
			rv.add(new RetornoVendas(v.getNome(), getTotalVendas(v.getId(), inicio, fim),
					getMediaDiariaVendas(v.getId(), inicio, fim)));
		}
		return rv;
	}

}
