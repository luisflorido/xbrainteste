package me.luis.xbraintest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(exclude= {"listaVendas"})
@Table(name = "vendedor")
public class Vendedor {

	private @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_vendedor") Long id;
	private @Getter @Setter @Column(name = "nome") String nome;
	private @JsonManagedReference @Getter @OneToMany(mappedBy = "vendedor") List<Venda> listaVendas;

}
