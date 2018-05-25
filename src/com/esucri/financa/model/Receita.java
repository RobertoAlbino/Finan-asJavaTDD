package com.esucri.financa.model;

import java.io.Serializable;
import java.util.Date;

import com.esucri.financa.model.base.Entity;
import com.esucri.financa.enums.EModoPagamento;

public class Receita extends Entity implements Serializable {
    
    private int id;
    private Date dataReceita;
    private Double valor;
    private EModoPagamento modoPagamento;
    private Usuario usuario;
    private TipoReceita tipoReceita;
    
    public Receita() {}
    
    public Receita(int id, Date dataReceita, Double valor, EModoPagamento modoPagamento, Usuario usuario, TipoReceita tipoReceita) {
        this.id = id;
        this.dataReceita = dataReceita;
        this.valor = valor;
        this.modoPagamento = modoPagamento;
        this.usuario = usuario;
        this.tipoReceita = tipoReceita;
    }
    
    @Override
    public int getId() {
        return this.id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Date getDataReceita() {
        return dataReceita;
    }

    public void setDataReceita(Date dataReceita) {
        this.dataReceita = dataReceita;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public EModoPagamento getModoPagamento() {
        return modoPagamento;
    }

    public void setModoPagamento(EModoPagamento modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }
    
    @Override
    public String getTableName() {
        return "RECEITA";
    }
}
