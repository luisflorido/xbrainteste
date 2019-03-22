package me.luis.xbraintest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Table(name = "venda")
public class Venda {

	private @Getter @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_venda") Long id;
	private @Getter @Setter @Column(name = "dataVenda") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @NotNull Date dataVenda;
	private @Getter @Setter @Column(name = "valor") @NotNull double valor;
	private @JsonBackReference @Getter @Setter @ManyToOne @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor", foreignKey = @ForeignKey(name = "FK_vendedorId"), nullable = false) Vendedor vendedor;

}
