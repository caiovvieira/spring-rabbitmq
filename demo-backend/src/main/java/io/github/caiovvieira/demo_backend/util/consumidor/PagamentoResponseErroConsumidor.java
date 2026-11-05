package io.github.caiovvieira.demo_backend.util.consumidor;

import io.github.caiovvieira.demo_backend.config.RabbitMQConfig;
import io.github.caiovvieira.demo_backend.dto.PagamentoDto;
import io.github.caiovvieira.demo_backend.service.PagamentoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseErroConsumidor {

    @Autowired
    private PagamentoService pagamentoService;

    @RabbitListener(queues = {RabbitMQConfig.PAGAMENTO_RESPONSE_ERRO_QUEUE})
    public void receive(@Payload Message pagamento) {
        ObjectMapper objectMapper = new ObjectMapper();
        String mensagem = objectMapper.writeValueAsString(pagamento);
        pagamentoService.erroPagamento(mensagem);
    }
}
