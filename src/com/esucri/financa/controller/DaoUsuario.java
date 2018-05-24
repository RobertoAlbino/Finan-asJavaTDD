package com.esucri.financa.controller;

import java.sql.ResultSet;

import com.esucri.financa.model.Usuario;
import com.esucri.financa.utils.MD5Utils;
import com.esucri.financa.controller.base.DaoReflection;

public class DaoUsuario extends DaoReflection<Usuario> {
    private String SQL;
    
    public int insert(Usuario usuario) throws Exception {
        SQL = "INSERT INTO USUARIO " +
                           "(LOGIN, EMAIL, SENHA)" +
                           "VALUES (?,?,?)";
        return super.executeUpdate(SQL, usuario.getLogin(),
                                        usuario.getEmail(),
                                        usuario.getSenha());        
    }
    
    public Usuario getById(int id) throws Exception {
        SQL = "SELECT * FROM USUARIO WHERE ID = ?";
        ResultSet rs = super.executeQuery(SQL, id);
        return rs.next() ? populateUsuario(rs) : new Usuario();
    }
    
    public Usuario findByLoginSenha(String login, String senha) throws Exception {
        SQL = "SELECT * FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";
        ResultSet rs = super.executeQuery(SQL, login, senha);
        return rs.next() ? populateUsuario(rs) : new Usuario();
    }
    
    public Boolean loginValido(String login, String senha) throws Exception {
        Usuario usuarioLogin = findByLoginSenha(login, MD5Utils.encriptarSenha(senha));
        return usuarioLogin.getId() != 0;
    }
    
    public static Boolean validarSenha(String senha, String confirmacaoSenha) {
        return senha.equals(confirmacaoSenha);
    }
    
    public Usuario populateUsuario(ResultSet rs) throws Exception {
        return new Usuario(rs.getInt("ID"),
                           rs.getString("LOGIN"),
                           rs.getString("EMAIL"),
                           rs.getString("SENHA"));
    } 
}
