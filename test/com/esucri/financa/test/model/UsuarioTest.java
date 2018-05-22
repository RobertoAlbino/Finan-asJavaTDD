package com.esucri.financa.test.model;

import org.junit.Test;
import org.junit.Before;
import junit.framework.Assert;

import com.esucri.financa.model.Usuario;

public class UsuarioTest {
    private Usuario usuario;
    
    @Before
    public void inicializar() throws Exception {
        this.usuario = new Usuario();
        this.usuario.setId(1);
        this.usuario.setLogin("Roberto");
        this.usuario.setEmail("junior_wash@Hotmail.com");
        this.usuario.setSenha("password");
    }
    
    @Test
    public void testarInicializacaoObjeto() {
        Assert.assertFalse(this.usuario.getId() == 0);
        Assert.assertFalse(this.usuario.getLogin() == "");
        Assert.assertFalse(this.usuario.getEmail() == "");
        Assert.assertFalse(this.usuario.getSenha() == "");
    }
    
    @Test
    public void garantirToStringRetornaNomeClasseUsuario() {
        Assert.assertEquals("Usuario", usuario.toString());
    }
}
