package com.esucri.financa.enums;

public enum EModoPagamento {
    DINHEIRO(1), CREDITO(2), DEBITO(3), CHEQUE(4);
    
    private String descricao;

    private tipoEquipamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
