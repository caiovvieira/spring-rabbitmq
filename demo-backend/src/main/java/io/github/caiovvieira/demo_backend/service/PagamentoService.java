package io.github.caiovvieira.demo_backend.service;

import io.github.caiovvieira.demo_backend.dto.PagamentoDto;
import io.github.caiovvieira.demo_backend.util.PagamentoRequestProdutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRequestProdutor pagamentoRequestProdutor;
    
    public String solicitarPagamento (PagamentoDto pagamento) {
        try {
            pagamentoRequestProdutor.integrarPagamento(pagamento);
        }
        catch (Exception e) {
            return "Erro ao processar pagamento";
        }
        return "Seu pagamento está sendo processado...";
    }

    public void sucessoPagamento(String payload) {
        System.out.println("O pagamento foi confirmado: " + payload);
    }

    public void erroPagamento(String payload) {
        System.err.println("Erro ao processar pagamento " + payload);
    }
}
