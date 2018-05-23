package Controller;

import Model.Equipamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import tipos.tipoEquipamento;

public class daoEquipamento extends daoGenerico {
    //add
    public int addEquipamento(Equipamento equipamento) throws SQLException{
        String SQL="INSERT INTO EQUIPAMENTO(TIPO,DESCRICAO,AQUISICAO,"
                + "ID_CLIENTE,ID_MARCA) VALUES (?,?,?,?,?)";
        return (super.executeUpdate(SQL, 
                equipamento.getTipo().name(),
                equipamento.getDescricao(),
                equipamento.getAquisicao(),
                equipamento.getCliente().getId(),
                equipamento.getMarca().getId()));        
    }
    //update
    public int updateEquipamento(Equipamento equipamento) throws SQLException{
        String SQL="UPDATE EQUIPAMENTO SET "
                + "TIPO=?, DESCRICAO=?, AQUISICAO=?, ID_CLIENTE=?,"
                + "ID_MARCA=? WHERE ID=?";
        return (super.executeUpdate(SQL, 
                equipamento.getTipo().name(),
                equipamento.getDescricao(),
                equipamento.getAquisicao(),
                equipamento.getCliente().getId(),
                equipamento.getMarca().getId(),
                equipamento.getId()
                ));
    }
    //delete
    public int deleteEquipamento(Equipamento equipamento) throws SQLException{
        String SQL="DELETE FROM EQUIPAMENTO WHERE ID=?";
        return (super.executeUpdate(SQL, equipamento.getId()));
    }
    //get pela pk
    public Equipamento getEquipamento(int pk) throws SQLException{
        String SQL="SELECT * FROM EQUIPAMENTO WHERE ID=?";
        ResultSet rs = super.executeQuery(SQL, pk);
        return (rs.next()?populateEquipamento(rs):null);
    }
    //lista todos
    public List<Equipamento> getEquipamentoList() throws SQLException{
        String SQL="SELECT * FROM EQUIPAMENTO ORDER BY DESCRICAO";
        ResultSet rs = super.executeQuery(SQL);
        List<Equipamento> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(populateEquipamento(rs));
        }
        return retorno;
    }
    //lista filtro
    public List<Equipamento> getEquipamentoList(String filtro) throws SQLException{
        String SQL="SELECT * FROM EQUIPAMENTO WHERE DESCRICAO LIKE ? ORDER BY DESCRICAO";
        ResultSet rs = super.executeQuery(SQL,"%"+filtro.toUpperCase()+"%");
        List<Equipamento> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(populateEquipamento(rs));
        }
        return retorno;
    }
    //populate    
    private Equipamento populateEquipamento(ResultSet rs) throws SQLException{
        return new Equipamento(
                rs.getInt("ID"), 
                tipoEquipamento.valueOf(rs.getString("TIPO")), 
                rs.getString("descricao"), 
                rs.getDate("aquisicao"), 
                new daoCliente().getCliente(rs.getInt("id_cliente")), 
                new daoMarca().getMarca(rs.getInt("id_marca"))
        );
    }
}
