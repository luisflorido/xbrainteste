package me.luis.xbraintest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class RetornoVendas {

	private @Getter @Setter String nome;
	private @Getter @Setter int totalVendas;
	private @Getter @Setter double mediaVendasDiaria;

}
