
package Model;

import java.util.Date;
import tipos.tipoEquipamento;

public class Equipamento implements java.io.Serializable{
    @SwingColumn(description = "Código",colorOfBackgound = "")
    private int id;
    @SwingColumn(description = "Tipo",colorOfBackgound = "")
    private tipoEquipamento tipo;
    @SwingColumn(description = "Descrição",colorOfBackgound = "")
    private String descricao;
    private Date aquisicao;
    @SwingColumn(description = "Cliente",colorOfBackgound = "")
    private Cliente cliente;
    private Marca marca;

    public Equipamento() {
    }

    public Equipamento(int id, tipoEquipamento tipo, String descricao, Date aquisicao, Cliente cliente, Marca marca) {
        this.id = id;
        this.tipo = tipo;
        this.setDescricao(descricao);
        this.setAquisicao(aquisicao);
        this.cliente = cliente;
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public tipoEquipamento getTipo() {
        return tipo;
    }

    public void setTipo(tipoEquipamento tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public Date getAquisicao() {
        return aquisicao;
    }

    public void setAquisicao(Date aquisicao) {
        this.aquisicao = aquisicao==null?new Date():aquisicao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final Equipamento other = (Equipamento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
