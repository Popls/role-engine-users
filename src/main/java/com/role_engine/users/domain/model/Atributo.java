package com.role_engine.users.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "atributos")
public class Atributo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "personaje_id", nullable = true)
    private Personaje personaje;

    @Column(name = "fuerza", nullable = false)
    private Integer fuerza;

    @Column(name = "destreza", nullable = false)
    private Integer destreza;

    @Column(name = "agilidad", nullable = false)
    private Integer agilidad;

    @Column(name = "constitucion", nullable = false)
    private Integer constitucion;

    @Column(name = "inteligencia", nullable = false)
    private Integer inteligencia;

    @Column(name = "percepcion", nullable = false)
    private Integer percepcion;

    @Column(name = "voluntad", nullable = false)
    private Integer voluntad;

    @Column(name = "poder", nullable = false)
    private Integer poder;
}
