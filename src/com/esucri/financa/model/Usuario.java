package com.esucri.financa.model;

import java.io.Serializable;

import com.esucri.financa.model.base.Entity;
import com.esucri.financa.utils.MD5Utils;

public class Usuario extends Entity implements Serializable {    
    private int id;
    private String login;
    private String email;
    private String senha;
    
    public Usuario() {}
    
    public Usuario(int id, String login, String email, String senha) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.senha = senha;        
    }
    
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

    public void setSenha(String senha) throws Exception {
        this.senha = MD5Utils.encriptarSenha(senha);
    }
    
    @Override
    public String getTableName() {
        return "USUARIO";
    }
}
