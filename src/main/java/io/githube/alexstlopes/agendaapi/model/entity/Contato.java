package io.githube.alexstlopes.agendaapi.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Sinaliza que é um campo auto incremento
    private Integer id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private Boolean favorito;//Evite tipo primitivos, wrapers podem possuir valores nulos

    @Column
    @Lob//notion sinaliza que é um array de bytes
    private byte[] foto;
}
