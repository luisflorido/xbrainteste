package me.luis.xbraintest.service;

import java.time.LocalDate;
import java.util.List;

import me.luis.xbraintest.model.Venda;

public interface VendaService {

	public void criarVenda(Venda venda);
	public List<Venda> getVendedoresVendas(LocalDate inicio, LocalDate fim);

}
