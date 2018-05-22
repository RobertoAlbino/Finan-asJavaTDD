package com.esucri.financa.test.utils;

import org.junit.Assert;
import org.junit.Test;

import com.esucri.financa.utils.MD5Utils;

public class MD5UtilsTest {
    
    @Test
    public void garantirQueUmaStringSempreGeraMesmoMD5() throws Exception {
        Assert.assertEquals(MD5Utils.encriptarSenha("Teste"),MD5Utils.encriptarSenha("Teste"));
    }
}
