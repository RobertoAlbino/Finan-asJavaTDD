package com.esucri.financa.controller.base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import com.esucri.financa.infrastructure.DatabaseContext;
import com.esucri.financa.model.base.Entity;

public abstract class DaoReflection<T extends Entity> {
    
    public Statement getStatement() throws SQLException{
        return DatabaseContext.getContext().createStatement();
    }
    
    public PreparedStatement getStatement(String SQL) throws SQLException{
        return DatabaseContext.getContext().prepareStatement(SQL);
    }
    
    public int executeUpdate(String SQL,Object... args) throws SQLException{
        PreparedStatement pst = getStatement(SQL);
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i+1), args[i]);
        }
        return pst.executeUpdate();
    }
    
    public ResultSet executeQuery(String SQL,Object... args) throws SQLException{
        PreparedStatement pst = getStatement(SQL);
        for (int i=0; i< args.length; i++){
            pst.setObject((i+1), args[i]);
        }
        return pst.executeQuery();
    }
    
    public int deleteEntity(T entity) throws SQLException{
        final String SQL = "DELETE FROM "+ entity.getClass().getSimpleName() +" WHERE ID=" + entity.getId();
        return executeUpdate(SQL);
    }
    
    public T populateEntity(T entity, ResultSet rs) throws SQLException, InstantiationException, IllegalAccessException {
        Object entidadeGenericaInstance = entity.getClass().newInstance();
        Field[] propriedadesInstancia = entidadeGenericaInstance.getClass().getDeclaredFields();
        for (Field propriedadeInstancia : propriedadesInstancia) {
            if (propriedadeInstancia.getGenericType().getTypeName().equals(String.class.getName())) {
                Type tipoConcreto = propriedadeInstancia.getGenericType();
                propriedadeInstancia.set(entity, rs.getString(propriedadeInstancia.getName()));
            }
            else if (propriedadeInstancia.getGenericType().getTypeName().equals(int.class.getName())) {
                Type tipoConcreto = propriedadeInstancia.getGenericType();
                propriedadeInstancia.set(entity, rs.getString(propriedadeInstancia.getName()));
            }
            else if (propriedadeInstancia.getType().getTypeName().equals(Date.class.getName())) {
                Type tipoConcreto = propriedadeInstancia.getGenericType();
                propriedadeInstancia.set(entity, rs.getDate(propriedadeInstancia.getName()));
            }
        }
        return (T)entidadeGenericaInstance;
    }
}
