package br.com.itexto.testetemplates;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteTemplatesApplicationTests {

	@Test
	public void contextLoads() {
		
		RestTemplate template = new RestTemplate();
		Categoria request = new Categoria();
		request.setNome("Teste");
		ResponseEntity<Categoria> result = template.postForEntity("http://localhost:3000/categoria", request, Categoria.class);
		assertNotNull(result.getBody());
		assertTrue(result.getBody().getId() > 0);
	}

}
