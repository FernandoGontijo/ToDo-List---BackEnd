package br.com.fernandogontijo.dto;

import br.com.fernandogontijo.model.Usuario;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;


    public UsuarioDTO(){

    }

    public UsuarioDTO(Usuario usuario){
        id = usuario.getId();
        nome = usuario.getNome();
        login = usuario.getNome();
        senha = usuario.getSenha();
        email = usuario.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
