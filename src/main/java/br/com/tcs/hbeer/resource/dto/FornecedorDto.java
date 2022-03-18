package br.com.tcs.hbeer.resource.dto;

import java.time.LocalDateTime;

import br.com.tcs.hbeer.model.Fornecedor;

public class FornecedorDto {
	
	private Long id;
	private String nome;
	private Long cnpj;
	private boolean ativo;
	
	public static Fornecedor parse(FornecedorDto dto) {
		Fornecedor f = new Fornecedor();
		f.setAtivo(true);
		f.setCnpj(dto.getCnpj());
		f.setDtCadastro(LocalDateTime.now());
		f.setDtUltAlt(LocalDateTime.now());
		f.setNome(dto.getNome());
		return f;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
