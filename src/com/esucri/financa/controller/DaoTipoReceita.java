package com.esucri.financa.controller;

import com.esucri.financa.model.TipoReceita;
import com.esucri.financa.controller.base.DaoReflection;

import java.util.List;
import java.util.LinkedList;

import java.sql.ResultSet;

public class DaoTipoReceita extends DaoReflection<TipoReceita> {
    private String SQL;
    
    public int insert(TipoReceita tipoReceita) throws Exception {
        SQL = "INSERT INTO TIPO_RECEITA " +
                           "(DESCRICAO, ID_USUARIO)" +
                           "VALUES (?,?)";
        return super.executeUpdate(SQL, tipoReceita.getDescricao(), tipoReceita.getUsuario().getId());        
    }
    
    public TipoReceita getById(int id) throws Exception {
        SQL = "SELECT * FROM TIPO_RECEITA WHERE ID = ?";
        ResultSet rs = super.executeQuery(SQL, id);
        return rs.next() ? populateTipoReceita(rs) : new TipoReceita();
    }
    
    public List<TipoReceita> getAll() throws Exception {
        SQL = "SELECT * FROM TIPO_RECEITA ORDER BY ID";
        ResultSet registros = super.executeQuery(SQL);
        LinkedList<TipoReceita> listaTiposReceita = new LinkedList();
        while (registros.next()) {
            listaTiposReceita.add(populateTipoReceita(registros));
        }
        return listaTiposReceita;
    }
    
    public List<TipoReceita> getAllWithFilter(String filter) throws Exception {
        SQL = "SELECT * FROM TIPO_RECEITA WHERE DESCRICAO LIKE '%"+ filter +"%' ORDER BY ID";
        ResultSet registros = super.executeQuery(SQL);
        LinkedList<TipoReceita> listaTiposReceita = new LinkedList();
        while (registros.next()) {
            listaTiposReceita.add(populateTipoReceita(registros));
        }
        return listaTiposReceita;
    }
    
    public TipoReceita populateTipoReceita(ResultSet rs) throws Exception {
        return new TipoReceita(rs.getInt("ID"),
                               rs.getString("DESCRICAO"),
                               new DaoUsuario().getById(rs.getInt("ID_USUARIO")));
    } 
    
}
