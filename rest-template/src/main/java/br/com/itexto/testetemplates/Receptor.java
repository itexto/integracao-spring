package br.com.itexto.testetemplates;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Receptor implements MessageListener {
	
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage text = (TextMessage) message;
			String conteudo = text.getText();
			System.out.println("Recebi " + conteudo);
			Categoria categoria = mapper.readValue(conteudo.getBytes(), Categoria.class);
			RestTemplate template = new RestTemplate();
			Categoria request = new Categoria();
			request.setNome("Teste");
			ResponseEntity<Categoria> result = template.postForEntity("http://localhost:3000/categoria", request, Categoria.class);
		} catch (Throwable e) { // nunca façam isto, amiguinhos. :)
			
			e.printStackTrace();
		}
		
	}
	
}
