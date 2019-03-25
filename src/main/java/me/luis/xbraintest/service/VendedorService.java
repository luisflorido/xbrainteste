package me.luis.xbraintest.service;

import java.time.LocalDate;
import java.util.List;

import me.luis.xbraintest.model.RetornoVendas;
import me.luis.xbraintest.model.Venda;
import me.luis.xbraintest.model.Vendedor;

public interface VendedorService {

	public Vendedor createVendedor(String nome);

	public Vendedor getVendedor(String nome);
	
	public Vendedor getVendedor(Long id);
	
	public List<Vendedor> getVendedores();
	
	public List<Venda> getVendas(Long idVendedor, LocalDate inicio, LocalDate fim);
	
	public List<RetornoVendas> getVendas(LocalDate inicio, LocalDate fim);
	
	public int getTotalVendas(Long idVendedor, LocalDate inicio, LocalDate fim);
	
	public double getValorVendas(Long idVendedor, LocalDate inicio, LocalDate fim);
	
	public double getMediaDiariaVendas(Long idVendedor, LocalDate inicio, LocalDate fim);
	
}
