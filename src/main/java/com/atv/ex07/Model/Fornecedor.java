package com.atv.ex07.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_fornecedor")
@Getter
@Setter
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nomes")
    private String nomeFantasia;

    private String cnpj;

    @Column(name="contatos")
    private String contato;
}
