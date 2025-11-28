package com.asafeorneles.cadastro_pets_crud.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.text.Normalizer;

@Getter
public enum Tipo {
    GATO ("Gato"), CACHORRO("Cachorro");

    private final String TIPO;

    Tipo(String tipo){
        this.TIPO = tipo;
    }

    @JsonCreator
    public static Tipo fromValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("O tipo do pet não pode ser nulo");
        }

        // Normaliza tirando acentos
        String normalized = Normalizer
                .normalize(value, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "") // remove acentos
                .trim()
                .toUpperCase();

        return switch (normalized) {
            case "GATO" -> Tipo.GATO;
            case "CACHORRO" -> Tipo.CACHORRO;
            default -> throw new IllegalArgumentException(
                    "Tipo inválido. Use apenas: GATO ou CACHORRO."
            );
        };
    }

}
