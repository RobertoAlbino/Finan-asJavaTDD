package Model;

public class Tecnico implements java.io.Serializable{
    @SwingColumn(description = "Código",colorOfBackgound = "")
    private int id;
    @SwingColumn(description = "Nome",colorOfBackgound = "")
    private String nome;
    @SwingColumn(description = "Telefone",colorOfBackgound = "")
    private String telefone;

    public Tecnico() {
    }

    public Tecnico(int id, String nome, String telefone) {
        this.id = id;
        this.setNome(nome);
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
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
        final Tecnico other = (Tecnico) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
