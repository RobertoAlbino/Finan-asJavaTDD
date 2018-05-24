package com.esucri.financa.controller;

import com.esucri.financa.model.TipoReceita;
import com.esucri.financa.controller.DaoUsuario;
import com.esucri.financa.controller.DaoTipoReceita;
import com.esucri.financa.controller.base.DaoReflection;
import java.sql.ResultSet;

public class DaoTipoReceita extends DaoReflection<TipoReceita> {
    private String SQL;
    
    public int insert(TipoReceita tipoReceita) throws Exception {
        SQL = "INSERT INTO TIPO_RECEITA " +
                           "(DESCRICAO, ID_USUARIO)" +
                           "VALUES (?,?)";
        return super.executeUpdate(SQL, tipoReceita.getDescricao(), tipoReceita.getUsuario().getId());        
    }
    
    public TipoReceita populateTipoReceita(ResultSet rs) throws Exception {
        return new TipoReceita(rs.getInt("ID"),
                               rs.getString("DESCRICAO"),
                               new DaoUsuario().getById(rs.getInt("ID_USUARIO")));
    } 
    
}
