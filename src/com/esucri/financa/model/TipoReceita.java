package com.esucri.financa.model;

import java.io.Serializable;

import com.esucri.financa.model.base.Entity;

public class TipoReceita extends Entity implements Serializable {
    
    private int id;
    private String descricao;
    
    public TipoReceita() {}
    
    public TipoReceita(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;   
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
}
