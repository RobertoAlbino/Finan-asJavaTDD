
package Controller;

import Model.Tecnico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class daoTecnico extends daoGenerico{
    public int addTecnico(Tecnico tecnico) throws SQLException{ 
        String SQL="INSERT INTO TECNICO (NOME,TELEFONE) VALUES (?,?)";
        return super.executeUpdate(SQL, tecnico.getNome(),
                tecnico.getTelefone());
    }
    public int updateTecnico(Tecnico tecnico) throws SQLException{
        String SQL="UPDATE TECNICO SET NOME=?, TELEFONE=? WHERE ID=?";
        return super.executeUpdate(SQL, tecnico.getNome(),
                tecnico.getTelefone(),
                tecnico.getId());
    }
    public int deleteTecnico(Tecnico tecnico) throws SQLException{
        String SQL="DELETE FROM TECNICO WHERE ID="+tecnico.getId();
        return super.executeUpdate(SQL);
    }
    public Tecnico getTecnico(int pk) throws SQLException{ 
        String SQL="SELECT * FROM TECNICO WHERE ID="+pk;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next()?populateTecnico(rs): null);
    }
    public List<Tecnico> getTecnicoList() throws SQLException{        
        String SQL = "SELECT * FROM TECNICO ORDER BY TECNICO.NOME";
        ResultSet rs = super.executeQuery(SQL);
        LinkedList<Tecnico> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(populateTecnico(rs));
        }
        return retorno;
    }
    public List<Tecnico> getTecnicoList(String filtro) throws SQLException{ 
        String SQL = "SELECT * FROM TECNICO WHERE NOME LIKE ? ORDER BY TECNICO.NOME";
        ResultSet rs = super.executeQuery(SQL, "%"+filtro.toUpperCase()+"%");
        LinkedList<Tecnico> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(populateTecnico(rs));
        }
        return retorno;
    }
    private Tecnico populateTecnico(ResultSet rs) throws SQLException{
        return new Tecnico(rs.getInt("ID"), 
                           rs.getString("nome"), 
                           rs.getString("telefone"));
    }
}
