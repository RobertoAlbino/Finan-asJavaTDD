
package Controller;

import Model.Cliente;
import java.sql.SQLException;

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
}
