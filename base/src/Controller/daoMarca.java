package Controller;

import Model.Marca;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class daoMarca extends daoGenerico{
    public int addMarca(Marca marca) throws SQLException{
        String SQL="INSERT INTO MARCA (NOME) VALUES (?)";
        return super.executeUpdate(SQL, marca.getNome());
    }
    public int updateMarca(Marca marca) throws SQLException{
        String SQL="UPDATE MARCA SET NOME=? WHERE ID=?";
        return super.executeUpdate(SQL, marca.getNome(),
                                        marca.getId());
    }
    public int deleteMarca(Marca marca) throws SQLException{
        String SQL="DELETE FROM MARCA WHERE ID=?";
        return super.executeUpdate(SQL, marca.getId());
    }
    public Marca getMarca(int pk) throws SQLException{
        String SQL="SELECT * FROM MARCA WHERE ID=?";
        ResultSet rs = super.executeQuery(SQL, pk);        
        return (rs.next() ? populateMarca(rs) : null);        
        /* versão extendida
        Marca retorno = null;
        if (rs.next()){
            retorno=populateMarca(rs);
        }
        return retorno;
        */
    }  
    public LinkedList<Marca> getMarcaLista() throws SQLException{
        String SQL="SELECT * FROM MARCA ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL);
        LinkedList<Marca> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(populateMarca(rs));
        }
        return retorno;
    }
    public LinkedList<Marca> getMarcaLista(String filtro) throws SQLException{
        String SQL="SELECT * FROM MARCA WHERE NOME LIKE ? ORDER BY NOME";
        ResultSet rs = super.executeQuery(SQL,"%"+filtro.toUpperCase()+"%");
        LinkedList<Marca> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(populateMarca(rs));
        }
        return retorno;
    }
    
    public Marca populateMarca(ResultSet rs) throws SQLException{
        return new Marca(rs.getInt("ID"), 
                         rs.getString("NOME"));
    }    
}
