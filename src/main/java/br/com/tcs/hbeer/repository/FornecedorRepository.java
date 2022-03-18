package br.com.tcs.hbeer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tcs.hbeer.model.Fornecedor;


public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
	
	@Query("SELECT p FROM Fornecedor p WHERE p.id = ?1 AND p.ativo = ?2")
	List<Fornecedor> pesquisarPorId(Long id, boolean ativo);

	
}

