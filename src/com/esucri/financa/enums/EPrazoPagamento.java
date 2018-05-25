package com.esucri.financa.enums;

public enum EPrazoPagamento {
    
    AVISTA("À vista"), 
    PARCELADO("Parcelado");
    
    private final String descricao;
    
    EPrazoPagamento(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
}
