package br.com.tcs.hbeer.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcs.hbeer.model.Produto;
import br.com.tcs.hbeer.resource.dto.ProdutoDto;
import br.com.tcs.hbeer.service.ProdutoService;

@RestController
@RequestMapping(value = "/v1") 
public class FornecedorResource {
private final Logger logger = LoggerFactory.getLogger(FornecedorResource.class);
	
	@Autowired
	private ProdutoService produtoService;

	
	@PostMapping(value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyAuthority('ROLE_GERENTE')")
	public ResponseEntity<?> cadastrar(@RequestBody ProdutoDto dto){
		
		try {
			Produto prod = ProdutoDto.parse(dto);
			produtoService.salvar(prod);
			return new ResponseEntity<>(prod, HttpStatus.CREATED);	
			
		}catch(Exception ex) {
			logger.error("[CADASTRAR-PRODUTO]", ex.fillInStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
