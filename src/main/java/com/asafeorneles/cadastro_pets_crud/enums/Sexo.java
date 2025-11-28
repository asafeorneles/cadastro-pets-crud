package com.asafeorneles.cadastro_pets_crud.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.text.Normalizer;

@Getter
public enum Sexo {
    FEMININO("Fêmea"), MASCULINO("Macho");

    private final String SEXO;

    Sexo(String sexo){
        this.SEXO = sexo;
    }

    @JsonCreator
    public static Sexo fromValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("O sexo do pet não pode ser nulo");
        }

        // Normaliza tirando acentos
        String normalized = Normalizer
                .normalize(value, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "") // remove acentos
                .trim()
                .toUpperCase();

        return switch (normalized) {
            case "FEMEA" -> Sexo.FEMININO;
            case "MACHO" -> Sexo.MASCULINO;
            default -> throw new IllegalArgumentException(
                    "Tipo inválido. Use apenas: FEMEA ou MACHO."
            );
        };
    }
}
