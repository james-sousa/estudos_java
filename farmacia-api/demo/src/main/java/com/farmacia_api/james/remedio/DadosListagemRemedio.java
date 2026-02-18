package com.farmacia_api.james.remedio;

import java.time.LocalDate;

public record DadosListagemRemedio(String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {
    public DadosListagemRemedio(Remedio remedio) {
        this(remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getDataValidade());
    }
}
