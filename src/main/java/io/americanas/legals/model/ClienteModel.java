package io.americanas.legals.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_clientes")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;


    public ClienteModel() {;
    }

    public ClienteModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }
}
