package io.github.caiovvieira.demo_worker.constante;

public class RabbitMQConstantes {

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

}
