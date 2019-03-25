package me.luis.xbraintest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(exclude = { "listaVendas" })
@Table(name = "vendedor")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "listaVendas" })
public class Vendedor {

	private @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_vendedor") Long id;
	private @Getter @Setter @Column(name = "nome", unique = true) @NotNull String nome;
	private @JsonManagedReference @Getter @OneToMany(mappedBy = "vendedor") List<Venda> listaVendas;

	public Vendedor(String nome) {
		this.nome = nome;
	}

	public Vendedor() {
	}

}
