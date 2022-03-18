package br.com.tcs.hbeer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.hbeer.model.Produto;
import br.com.tcs.hbeer.model.commons.CategoriaProdutoEnum;
import br.com.tcs.hbeer.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> pesquisarPorId(Long id, boolean ativo){
		return repository.pesquisarPorId(id, ativo);
	}

	public Optional<Produto> pesquisarPorCategoria(CategoriaProdutoEnum categoria, boolean ativo){
		return repository.pesquisarPorCategoria(categoria, ativo);
	}
	
	public List<Produto> loadAll() {
		return repository.findAll();
	}
	
	public Optional<Produto> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public Produto salvar(Produto produto) {
		return repository.save(produto);
	}

}
