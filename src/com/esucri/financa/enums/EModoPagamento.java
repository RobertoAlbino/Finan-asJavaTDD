package com.esucri.financa.enums;

public enum EModoPagamento {
    
    DINHEIRO("Dinheiro"), 
    CREDITO("Crédito"), 
    DEBITO("Débito"), 
    CHEQUE("Cheque");
    
    private final String descricao;
    
    EModoPagamento(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
}
