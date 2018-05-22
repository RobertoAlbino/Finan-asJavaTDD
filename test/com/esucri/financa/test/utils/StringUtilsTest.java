package com.esucri.financa.test.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import com.esucri.financa.utils.StringUtils;

public class StringUtilsTest {
    
    @Test
    public void testarSeEncontraStringNula() {
        String[] stringList = { "", "Roberto", "s", "Teste", null };
        Assert.assertFalse(StringUtils.stringListIsValid(stringList));
    }
}
