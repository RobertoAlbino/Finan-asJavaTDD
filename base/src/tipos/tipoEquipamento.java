package tipos;

public enum tipoEquipamento {
    IMP("Impressora"),
    NOT("NoteBook"),
    DES("DeskTop"),
    MON("Monitor"),
    SER("Servidor");
    
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
