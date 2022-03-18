package br.com.tcs.hbeer.resource.dto;

import java.time.LocalDateTime;

import br.com.tcs.hbeer.model.Produto;
import br.com.tcs.hbeer.model.commons.CategoriaProdutoEnum;

public class ProdutoDto {

	private String nome;
	private String descricao;
	private Integer categoria;
	
	
	public static Produto parse(ProdutoDto dto) {
		Produto p = new Produto();
		CategoriaProdutoEnum cat = CategoriaProdutoEnum.DESTILADA.ordinal() == dto.getCategoria() ? CategoriaProdutoEnum.DESTILADA : CategoriaProdutoEnum.FERMENTADA;
		
		p.setAtivo(false);
		p.setCategoria(cat);
		p.setDescricao(dto.getDescricao());
		p.setDtCadastro(LocalDateTime.now());
		p.setDtUltAlt(LocalDateTime.now());
		p.setNome(dto.getNome());
		return p;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getCategoria() {
		return categoria;
	}
	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	
//	private CategoriaProdutoEnum categoria;
	
}
