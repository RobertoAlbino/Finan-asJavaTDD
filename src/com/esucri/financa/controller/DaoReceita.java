package com.esucri.financa.controller;

import java.util.List;
import java.util.LinkedList;
import java.sql.ResultSet;

import com.esucri.financa.model.Receita;
import com.esucri.financa.enums.EModoPagamento;
import com.esucri.financa.controller.DaoUsuario;
import com.esucri.financa.controller.DaoTipoReceita;
import com.esucri.financa.controller.base.DaoReflection;

public class DaoReceita extends DaoReflection<Receita> {
    private String SQL;
    
    public int insert(Receita receita) throws Exception {
        SQL = "INSERT INTO RECEITA " +
                           "(DESCRICAO, ID_USUARIO)" +
                           "VALUES (?,?)";
        return super.executeUpdate(SQL);        
    }
    
    public List<Receita> getAll() throws Exception {
        SQL = "SELECT * FROM RECEITA ORDER BY ID";
        ResultSet registros = super.executeQuery(SQL);
        LinkedList<Receita> receita = new LinkedList();
        while (registros.next()) {
            receita.add(populateTipoReceita(registros));
        }
        return receita;
    }
    
    public List<Receita> getAllWithFilter(String filter) throws Exception {
        SQL = "SELECT * FROM RECEITA AS R INNER JOIN TIPO_RECEITA AS TR "
                + "ON R.ID_TIPO_RECEITA = TR.ID"
                + "WHERE TR.DESCRICAO LIKE '%"+ filter +"%' ORDER BY R.ID";
        ResultSet registros = super.executeQuery(SQL);
        LinkedList<Receita> listaReceitas = new LinkedList();
        while (registros.next()) {
            listaReceitas.add(populateTipoReceita(registros));
        }
        return listaTiposReceita;
    }
    
    public Receita populateReceita(ResultSet rs) throws Exception {
        return new Receita(rs.getInt("ID"),
                           rs.getDate("DATA_RECEITA"),
                           rs.getDouble("VALOR"),
                           EModoPagamento.valueOf(rs.getString("MODO_PAGAMENTO")),
                           new DaoUsuario().getById(rs.getInt("ID_USUARIO")),
                           new DaoUsuario().getById(rs.getInt("ID_USUARIO")));
    } 
    
}
