package br.com.tcs.hbeer.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcs.hbeer.model.Fornecedor;
import br.com.tcs.hbeer.resource.dto.FornecedorDto;
import br.com.tcs.hbeer.service.FornecedorService;

@RestController
@RequestMapping(value = "/v1") 
public class EstoqueResource {
private final Logger logger = LoggerFactory.getLogger(EstoqueResource.class);
	
	@Autowired
	private FornecedorService fornecedorService;

	@PostMapping(name = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cadastrar(@RequestBody FornecedorDto dto){
		
		try {
			Fornecedor fornecedor = FornecedorDto.parse(dto);
			fornecedorService.salvar(fornecedor);
			return new ResponseEntity<>(fornecedor, HttpStatus.CREATED);	
			
		}catch(Exception ex) {
			logger.error("[CADASTRAR-PRODUTO]", ex.fillInStackTrace());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
