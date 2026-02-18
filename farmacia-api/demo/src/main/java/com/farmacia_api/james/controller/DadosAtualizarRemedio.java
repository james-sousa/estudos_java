package com.farmacia_api.james.controller;

import com.farmacia_api.james.remedio.Laboratorio;
import com.farmacia_api.james.remedio.Via;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(
    @NotNull
    Long id,
    String nome,
    Via via,
    Laboratorio laboratorio
) {

}
