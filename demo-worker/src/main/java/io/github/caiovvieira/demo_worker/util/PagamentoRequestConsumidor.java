package io.github.caiovvieira.demo_worker.util;

import io.github.caiovvieira.demo_worker.constante.RabbitMQConstantes;
import io.github.caiovvieira.demo_worker.util.produtor.PagamentoErroProdutor;
import io.github.caiovvieira.demo_worker.util.produtor.PagamentoSucessoProdutor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class PagamentoRequestConsumidor {

    @Autowired
    private PagamentoErroProdutor erroProdutor;

    @Autowired
    private PagamentoSucessoProdutor sucessoProdutor;

    @RabbitListener(queues = { RabbitMQConstantes.PAGAMENTO_REQUEST_QUEUE })
    public void receive(@Payload Message message) {
        System.out.println("Message " + message + "  " + LocalDateTime.now());

        if (new Random().nextBoolean()) {
            sucessoProdutor.gerarResposta("Recebido com SUCESSO: " + message.getPayload().toString());
        }
        else {
            erroProdutor.gerarResposta("Recebido com ERRO: " +  message.getPayload().toString());
        }
    }
}
