# Código fonte do segundo encontro do Meetup de Groovy, Grails e Spring

Neste reposiório vocês terão acesso ao código fonte que desenvolvemos ilustrando o uso de recursos do Spring para integraço com outros sistemas.

Foram abordadas as seguintes integrações:

* REST com RestClient
* JMS com JMSClient
* Também foi apresentado o código fonte do /dev/All, implementado em Apache Camel, que é outra aplicaço interessante do framework.

No repositório há três projetos:

* Mock - que simula a nossa API, escrita em Node.js, de cadastro de categorias.
* jms-activemq-producer - que contém um endpoint de cadastro de Produtos, que envia mensagens via JMS para serem consumidas assncronamente usando ActiveMQ.
* rest-template - que recebe mensagens via JMS usando ActiveMQ e as publica no endpoint de categorias disponibilizado no projeto mock usando o RestTemplate do Spring
