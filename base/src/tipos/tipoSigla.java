
package tipos;

public enum tipoSigla {
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    PR("Paraná"),
    SP("São Paulo"),
    RJ("Rio de Janeiro"),
    ES("Espírito Santo"),
    MG("Minas Gerais"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    TO("Tocantins"),
    DF("Distrito Federal"),
    BA("Bahia"),
    SE("Sergipe"),
    AL("Alagoas"),
    MA("Maranhão"),
    CE("Ceará"),
    AM("Amazonas"),
    PB("Paraíba"),
    RO("Rondônia"),
    RR("Roraima"),
    AC("Acre"),
    PE("Pernambuco"),
    PI("Piauí"),
    GO("Goiás"),
    RN("Rio Grande do Norte"),
    PA("Pará"),
    AP("Amapá");
    
    private String descricao;

    private tipoSigla(String descricao) {
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
