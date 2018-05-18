package Model;

import java.util.Date;

public class Cliente implements java.io.Serializable{
    @SwingColumn(description = "Código",colorOfBackgound = "")
    private int id;
    @SwingColumn(description = "Nome",colorOfBackgound = "")
    private String nome;
    private String endereco;
    @SwingColumn(description = "CPF",colorOfBackgound = "")
    private String cpf;
    private Date nascimento;
    @SwingColumn(description = "Cidade",colorOfBackgound = "")
    private Cidade cidade;

    public Cliente() {
    }

    public Cliente(int id, String nome, String endereco, String cpf, Date nascimento, Cidade cidade) {
        this.id = id;
        this.setNome(nome);
        this.setEndereco(endereco);
        this.cpf = cpf;
        this.setNascimento(nascimento);
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"PADRÃO":nome.toUpperCase();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty()?"PADRÃO":endereco.toUpperCase();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento==null?new Date():nascimento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
