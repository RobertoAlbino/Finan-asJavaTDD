package com.esucri.financa.test.controller;

import org.junit.Assert;
import org.junit.Test;

import com.esucri.financa.controller.DaoUsuario;

public class DaoUsuarioTest {
    
    @Test
    public void testarComparacaoSenha() {
        Assert.assertTrue(DaoUsuario.validarSenha("Teste", "Teste"));
        Assert.assertFalse(DaoUsuario.validarSenha("Teste1", "Teste2"));
    }
}
