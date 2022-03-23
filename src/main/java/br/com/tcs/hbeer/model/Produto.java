package br.com.tcs.hbeer.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.tcs.hbeer.model.commons.CategoriaProdutoEnum;
import br.com.tcs.hbeer.model.commons.VolumeEnum;

/**
 * Class <code>Produto</code></br>
 * Define a entidade produto
 * @version 1.0.0
 * @author ronaldoar
 * 
 *
 */

@Entity
@Table(name="TB_PRODUTO", uniqueConstraints={@UniqueConstraint(columnNames={"NOME_PRODUTO"})})
public class Produto {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_PRODUTO", nullable=false)
	private Long id;
		
	@Column(name="NOME_PRODUTO", length=100, nullable=false)
	private String nome;

	@Column(name="DESC_PRODUTO", length=120, nullable=true, unique=true)
	private String descricao;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CD_FORNECEDOR", nullable=false)
	private Fornecedor fornecedor;

	@Enumerated(EnumType.STRING)
	@Column(name="CATEGORIA", nullable=false, unique=true)
	private CategoriaProdutoEnum categoria;
	
	@Enumerated(EnumType.STRING)
	@Column(name="VOLUME", nullable=false, unique=true)
	private VolumeEnum volume;
			
	@Column(name="DT_CADASTRO", nullable=false)
	private LocalDateTime dtCadastro;

	@Column(name="DT_ULT_ALT", nullable=false)
	private LocalDateTime dtUltAlt;
		
	@Column(name="ATIVO", length=100, nullable=false)
	private boolean ativo;
	
	@Column(name="USUARIO_ID", length=120, nullable=true, unique=true)
	private String String;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaProdutoEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProdutoEnum categoria) {
		this.categoria = categoria;
	}

	public VolumeEnum getVolume() {
		return volume;
	}

	public void setVolume(VolumeEnum volume) {
		this.volume = volume;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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

	public String getString() {
		return String;
	}

	public void setString(String string) {
		String = string;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", email=" + descricao + ", categoria=" + categoria
				+ ", dtCadastro=" + dtCadastro + ", dtUltAlt=" + dtUltAlt + ", ativo=" + ativo + "]";
	}
	
	
}
