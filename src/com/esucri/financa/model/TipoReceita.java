package com.esucri.financa.model;

import java.io.Serializable;

import com.esucri.financa.model.Usuario;
import com.esucri.financa.model.base.Entity;

public class TipoReceita extends Entity implements Serializable {
    
    private int id;
    private String descricao;
    private Usuario usuario;
    
    public TipoReceita() {}
    
    public TipoReceita(String descricao) {
        this.descricao = descricao;   
    }
    
    public TipoReceita(String descricao, Usuario usuario) {
        this.descricao = descricao; 
        this.usuario = usuario;
    }
    
    public TipoReceita(int id, String descricao, Usuario usuario) {
        this.id = id;
        this.descricao = descricao; 
        this.usuario = usuario;
    }
    
    @Override
    public int getId() {
        return this.id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
