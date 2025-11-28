package com.asafeorneles.cadastro_pets_crud.entities;

import com.asafeorneles.cadastro_pets_crud.enums.Sexo;
import com.asafeorneles.cadastro_pets_crud.enums.Tipo;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "TB_PETS")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // De 1 ao infinito
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Tipo type;

    @Enumerated(EnumType.STRING) // O JPA controla como o valor é salvo, na tavela fica o ENUM de fato.
    private Sexo sexo;

    private String name;
    private String lastName;
    private BigDecimal age;
    private BigDecimal weight;
    private String race;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
}
