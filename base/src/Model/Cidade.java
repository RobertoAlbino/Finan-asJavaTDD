
package Model;

import tipos.tipoSigla;


public class Cidade implements java.io.Serializable{
    private int id;
    private String nome;
    private tipoSigla sigla;

    public Cidade() {
    }

    public Cidade(int id, String nome, tipoSigla sigla) {
        this.id = id;
        this.setNome(nome);
        this.sigla = sigla;
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
        this.nome = nome.trim().isEmpty() ? "PADRÃO" : nome.toUpperCase();
    }

    public tipoSigla getSigla() {
        return sigla;
    }

    public void setSigla(tipoSigla sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final Cidade other = (Cidade) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
