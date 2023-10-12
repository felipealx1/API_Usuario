package br.com.rocketseat.ApiRocketseat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
//@AllArgsConstructor //com essas duas anotações eun preciso criar os get e set e nem os construtores.
@Entity(name = "tb_users") //criando um nome para nossa tabela.
public class User {
    @Id // anotação do meu id na banco de dados
    @GeneratedValue(generator = "UUID") //gerenciador de valores pra meu id de forma automatica.
    private UUID id; //para criamos uma chame primaria para nossa tabela.

    private String name;
    //vamos validar o username para que não seja crianos usuarios iguais.
    @Column(unique = true)
    private  String username;
    private int password;

    //definir quando meu dado no meu banco de dados foi criado.
    @CreationTimestamp
    private LocalDateTime createdAt;
}
