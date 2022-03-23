package br.com.tcs.hbeer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tcs.hbeer.model.Fornecedor;


public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
	
	@Query("SELECT f FROM Fornecedor f WHERE f.id = ?1 AND f.ativo = ?2")
	List<Fornecedor> pesquisarPorId(Long id, boolean ativo);

	@Query("SELECT f FROM Fornecedor f WHERE f.cnpj = ?1 OR f.nome = ?2")
	Fornecedor pesquisarPorCnpj(Long cnpj, String nome);

	
}

