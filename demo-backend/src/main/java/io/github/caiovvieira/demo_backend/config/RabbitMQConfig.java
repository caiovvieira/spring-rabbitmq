package io.github.caiovvieira.demo_backend.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Queues
    public static final String PAGAMENTO_REQUEST_QUEUE = "pagamento-request-queue";
    public static final String PAGAMENTO_RESPONSE_SUCESSO_QUEUE = "pagamento-response-sucesso-queue";
    public static final String PAGAMENTO_RESPONSE_ERRO_QUEUE = "pagamento-response-erro-queue";

    // Exchanges
    public static final String PAGAMENTO_REQUEST_EXCHANGE = "pagamento-request-exchange";
    public static final String PAGAMENTO_RESPONSE_SUCESSO_EXCHANGE = "pagamento-response-sucesso-exchange";
    public static final String PAGAMENTO_RESPONSE_ERRO_EXCHANGE = "pagamento-response-erro-exchange";

    // Routing Keys
    public static final String PAGAMENTO_REQUEST_ROUTING_KEY = "pagamento.request";
    public static final String PAGAMENTO_RESPONSE_SUCESSO_ROUTING_KEY = "pagamento.response.sucesso";
    public static final String PAGAMENTO_RESPONSE_ERRO_ROUTING_KEY = "pagamento.response.erro";


    @Bean
    public Declarables pagamentoRabbitTopology() {

        DirectExchange requestExchange = new DirectExchange(PAGAMENTO_REQUEST_EXCHANGE);
        DirectExchange sucessoExchange = new DirectExchange(PAGAMENTO_RESPONSE_SUCESSO_EXCHANGE);
        DirectExchange erroExchange = new DirectExchange(PAGAMENTO_RESPONSE_ERRO_EXCHANGE);

        Queue requestQueue = new Queue(PAGAMENTO_REQUEST_QUEUE);
        Queue sucessoQueue = new Queue(PAGAMENTO_RESPONSE_SUCESSO_QUEUE);
        Queue erroQueue = new Queue(PAGAMENTO_RESPONSE_ERRO_QUEUE);


        return new Declarables(
                requestExchange,
                sucessoExchange,
                erroExchange,

                requestQueue,
                sucessoQueue,
                erroQueue,

                BindingBuilder
                        .bind(requestQueue)
                        .to(requestExchange)
                        .with(PAGAMENTO_REQUEST_ROUTING_KEY),

                BindingBuilder
                        .bind(sucessoQueue)
                        .to(sucessoExchange)
                        .with(PAGAMENTO_RESPONSE_SUCESSO_ROUTING_KEY),

                BindingBuilder
                        .bind(erroQueue)
                        .to(erroExchange)
                        .with(PAGAMENTO_RESPONSE_ERRO_ROUTING_KEY)
        );
    }
}
