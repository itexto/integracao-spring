package br.com.itexto.testetemplates;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@EnableJms
@Configuration
public class MOMConfiguration {

	@Autowired
	private Receptor receptor;
	
	@Bean
	public ConnectionFactory getConnectionFactory() {
		ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
		cf.setBrokerURL("tcp://localhost:32768");
        cf.setUserName("admin");
        cf.setPassword("admin");
		return cf;
        
	}
	
	
	@Bean(name="listenerParecerAnalise")
    public DefaultMessageListenerContainer listenerParecerAnalise(@Autowired ConnectionFactory connectionFactory) {
        DefaultMessageListenerContainer factory = new DefaultMessageListenerContainer();
        
        factory.setAutoStartup(true);
        factory.setPubSubDomain(false);
        factory.setClientId("itexto Listener");
        factory.setSubscriptionDurable(false);
        
        factory.setConnectionFactory(connectionFactory);
        factory.setReceiveTimeout(1000l);
        
        factory.setupMessageListener(receptor);
        factory.setDestinationName("itextoProducts");
        factory.start();
        return factory;
    }
	
	
	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);
	    converter.setTypeIdPropertyName("_type");
	    return converter;
	}
	

	
}
