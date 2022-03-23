package br.com.tcs.hbeer.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_FORNECEDOR")
public class Fornecedor {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_FORNECEDOR", nullable=false)
	private Long id;
	
	@Column(name="NOME_FORNECEDOR", length=150, nullable=false, unique = true)
	private String nome;
	
	@Column(name="CNPJ", length=13, nullable=false, unique = true)
	private Long cnpj;
	
	@Column(name="DT_CADASTRO", nullable=false)
	private LocalDateTime dtCadastro;
	
	@Column(name="DT_ULT_ALT", nullable=false)
	private LocalDateTime dtUltAlt;
	
	@Column(name="ATIVO", nullable=false)
	private boolean ativo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public LocalDateTime getDtUltAlt() {
		return dtUltAlt;
	}
	public void setDtUltAlt(LocalDateTime dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(id, other.id);
	}
}
