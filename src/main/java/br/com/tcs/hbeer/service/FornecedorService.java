package br.com.tcs.hbeer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.hbeer.model.Fornecedor;
import br.com.tcs.hbeer.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
	public List<Fornecedor> pesquisarPorId(Long id, boolean ativo){
		return repository.pesquisarPorId(id, ativo);
	}

	
	public List<Fornecedor> loadAll() {
		return repository.findAll();
	}
	
	public Optional<Fornecedor> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public Fornecedor salvar(Fornecedor produto) {
		return repository.save(produto);
	}

}
