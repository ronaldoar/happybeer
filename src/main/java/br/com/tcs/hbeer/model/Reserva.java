package br.com.tcs.hbeer.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {
	
	private Long id;
	private Integer quantidade;
	private Produto produto;
	private LocalDate dataReserva;
	private LocalDateTime dtCadastro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public LocalDate getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}
	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
}
