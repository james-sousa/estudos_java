package com.farmacia_api.james.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia_api.james.remedio.DadosCadastroRemedio;
import com.farmacia_api.james.remedio.DadosListagemRemedio;
import com.farmacia_api.james.remedio.Remedio;
import com.farmacia_api.james.remedio.RemedioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedios")
public class RemedioController {
    @Autowired
    private RemedioRepository remedioRepository;
    
    @PostMapping
    @Transactional
    public void adicionarRemedio(@RequestBody @Valid DadosCadastroRemedio dados) {
        remedioRepository.save(new Remedio(dados));
    }

    @GetMapping
    public List<DadosListagemRemedio> listarRemedios() {
        return remedioRepository.findAll().stream().map(DadosListagemRemedio::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarRemedio dados){
        var remedio = remedioRepository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        remedioRepository.deleteById(id);
    }
}
