package io.github.caiovvieira.demo_backend.util;

import io.github.caiovvieira.demo_backend.config.RabbitMQConfig;
import io.github.caiovvieira.demo_backend.dto.PagamentoDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class PagamentoRequestProdutor {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void integrarPagamento(PagamentoDto pagamento) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String mensagem = objectMapper.writeValueAsString(pagamento);

        amqpTemplate.convertAndSend(
                RabbitMQConfig.PAGAMENTO_REQUEST_EXCHANGE,
                RabbitMQConfig.PAGAMENTO_REQUEST_ROUTING_KEY,
                mensagem
        );
    }
}
