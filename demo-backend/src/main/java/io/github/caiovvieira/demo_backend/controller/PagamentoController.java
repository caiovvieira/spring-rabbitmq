package io.github.caiovvieira.demo_backend.controller;


import io.github.caiovvieira.demo_backend.dto.PagamentoDto;
import io.github.caiovvieira.demo_backend.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public String processar (@RequestBody PagamentoDto request) {
        return pagamentoService.solicitarPagamento(request);
    }
}
