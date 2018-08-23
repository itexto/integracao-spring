package br.com.itexto.jmsactivemqproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.itexto.jmsactivemqproducer.dto.Produto;

@RestController
public class ProdutoController {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	private final ObjectMapper mapper = new ObjectMapper();
	
	@PostMapping("/produto")
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
		
		try {
			jmsTemplate.convertAndSend("itextoProducts", mapper.writeValueAsString(produto.getCategoria()));
		} catch (JmsException | JsonProcessingException e) {
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity(produto, HttpStatus.CREATED);
	}
	
}
