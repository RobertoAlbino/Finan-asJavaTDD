package Controller;

import Model.Cidade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import tipos.tipoSigla;

public class daoCidade extends daoGenerico{
    /*
    1-add
    2-update
    3-delete
    4-retorno pela pk
    5-lista todos
    6-lista filtro
    7-conversão registro/objeto
    */
    public int addCidade(Cidade cidade) throws SQLException{
        String SQL="INSERT INTO CIDADE (NOME, SIGLA) VALUES (?,?)";
        return super.executeUpdate(SQL, cidade.getNome(),
                cidade.getSigla().name());
    }
    public int updateCidade(Cidade cidade) throws SQLException{
        String SQL="UPDATE CIDADE SET NOME=?, SIGLA=? WHERE ID=?";
        return super.executeUpdate(SQL, cidade.getNome(),
                cidade.getSigla().name(),
                cidade.getId());
    }
    public int deleteCidade(Cidade cidade) throws SQLException{
        String SQL="DELETE FROM CIDADE WHERE ID="+cidade.getId();
        return super.executeUpdate(SQL);
    }
    public Cidade getCidade(int pk) throws SQLException{
        String SQL="SELECT * FROM CIDADE WHERE ID="+pk;
        ResultSet rs = super.executeQuery(SQL);
        return (rs.next()?populateCidade(rs) : null);
    }
    public List<Cidade> getCidadeList() throws SQLException{
        String SQL="SELECT * FROM CIDADE ORDER BY CIDADE.NOME";
        ResultSet rs = super.executeQuery(SQL);
        LinkedList<Cidade> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(populateCidade(rs));
        }
        return retorno;                
    }
    public List<Cidade> getCidadeList(String filtro) throws SQLException{
        String SQL="SELECT * FROM CIDADE WHERE NOME LIKE ? ORDER BY CIDADE.NOME";
        ResultSet rs = super.executeQuery(SQL, "%"+filtro.toUpperCase()+"%");
        LinkedList<Cidade> retorno = new LinkedList<>();
        while (rs.next()){
            retorno.add(populateCidade(rs));
        }
        return retorno;         
    }
    private Cidade populateCidade(ResultSet rs) throws SQLException{
        return (new Cidade(rs.getInt("ID"), 
                           rs.getString("NOME"), 
                           tipoSigla.valueOf(rs.getString("SIGLA"))));
    }
}
