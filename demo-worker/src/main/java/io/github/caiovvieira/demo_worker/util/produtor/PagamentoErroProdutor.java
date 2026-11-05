package io.github.caiovvieira.demo_worker.util.produtor;

import io.github.caiovvieira.demo_worker.constante.RabbitMQConstantes;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoErroProdutor {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void gerarResposta(String mensagem){
        amqpTemplate.convertAndSend(
                RabbitMQConstantes.PAGAMENTO_RESPONSE_ERRO_EXCHANGE,
                RabbitMQConstantes.PAGAMENTO_RESPONSE_ERRO_ROUTING_KEY,
                mensagem);
    }
}
