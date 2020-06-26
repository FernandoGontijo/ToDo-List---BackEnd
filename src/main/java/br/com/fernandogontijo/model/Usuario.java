package br.com.fernandogontijo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String login;
    private String senha;
    private String email;

}


/*

Script para criar tabelo Usuário

CREATE TABLE `TODOLIST`.`TB.USUARIO` (
 `id` INT NOT NULL,
 `nome` VARCHAR(255) NULL,
 `login` VARCHAR(20) NULL,
 `senha` VARCHAR(30) NULL,
 `email` VARCHAR(50) NULL,
 PRIMARY KEY (`id`));

 ALTER TABLE `TODOLIST`.`TB.USUARIO`
 CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ,
 ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC);
 */