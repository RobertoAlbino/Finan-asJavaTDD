package com.esucri.financa.controller;

import com.esucri.financa.model.Usuario;
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
    
    public static Boolean validarSenha(String senha, String confirmacaoSenha) {
        return senha.equals(confirmacaoSenha);
    }
    
    
}
