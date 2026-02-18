package com.farmacia_api.james.remedio;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRemedio(
    @NotBlank
    String nome,
    @Enumerated
    Via via,
    @NotBlank
    String lote,

    int quantidade,
    @FutureOrPresent
    LocalDate dataValidade,
    @Enumerated
    Laboratorio laboratorio
) {

}
