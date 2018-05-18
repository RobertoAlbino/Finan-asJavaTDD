
package Controller;

import Model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class daoCliente extends daoGenerico {
    public int addCliente(Cliente cliente) throws SQLException{
        String SQL="INSERT INTO CLIENTE"
                + "(NOME,ENDERECO,CPF,NASCIMENTO,ID_CIDADE)"
                + " VALUES (?,?,?,?,?)";
        return super.executeUpdate(SQL,
                cliente.getNome(),
                cliente.getEndereco(),
                cliente.getCpf(),
                cliente.getNascimento(),
                cliente.getCidade().getId());
    }
    public int updateCliente(Cliente cliente) throws SQLException{
        String SQL="UPDATE CLIENTE SET NOME=?,"
                + "ENDERECO=?,"
                + "CPF=?,"
                + "NASCIMENTO=?,"
                + "ID_CIDADE=? WHERE ID=?";
        return super.executeUpdate(SQL, 
                cliente.getNome(),
                cliente.getEndereco(),
                cliente.getCpf(),
                cliente.getNascimento(),
                cliente.getCidade().getId(),
                cliente.getId());
    }
    public int deleteCliente(Cliente cliente) throws SQLException{
        String SQL="DELETE FROM CLIENTE WHERE ID="+
                cliente.getId();
        return super.executeUpdate(SQL);
    }
    public Cliente getCliente(int id) throws SQLException{
        String SQL="SELECT * FROM CLIENTE WHERE ID="+id;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next()?populateCliente(rs):null);
    }
    public List<Cliente> getClienteList() throws SQLException{
        String SQL="SELECT * FROM CLIENTE ORDER BY NOME";
        ResultSet rs=super.executeQuery(SQL);
        LinkedList<Cliente> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(populateCliente(rs));
        }
        return retorno;        
    }
    public List<Cliente> getClienteList(String filtro) throws SQLException{
        String SQL="SELECT * FROM CLIENTE "
                + "WHERE NOME LIKE ? ORDER BY NOME";
        ResultSet rs=super.executeQuery(SQL,"%"+filtro.toUpperCase()+"%");
        LinkedList<Cliente> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(populateCliente(rs));
        }
        return retorno;         
    }    
    public Cliente populateCliente(ResultSet rs) throws SQLException{
        return new Cliente(rs.getInt("ID"), 
                rs.getString("nome"), 
                rs.getString("endereco"), 
                rs.getString("cpf"), 
                rs.getDate("nascimento"), 
                new daoCidade().getCidade(rs.getInt("id_cidade")));
    }
}
