package com.esucri.financa.model;

import java.io.Serializable;

import com.esucri.financa.model.base.Entity;

public class Usuario extends Entity implements Serializable {
    
    private int id;
    private String login;
    private String email;
    private String senha;
    
    @Override
    public int getId() {
        return this.id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
