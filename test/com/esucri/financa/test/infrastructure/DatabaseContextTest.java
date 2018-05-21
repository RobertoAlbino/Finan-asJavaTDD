package com.esucri.financa.test.infrastructure;

import org.junit.Test;
import org.junit.Before;
import junit.framework.Assert;
import java.sql.SQLException;
import java.sql.Connection;

import com.esucri.financa.infrastructure.DatabaseContext;

public class DatabaseContextTest {
    private Connection context;
    
    @Before
    public void inicializar() throws SQLException{
        this.context = DatabaseContext.getContext();
    }
        
    @Test
    public void testarConexaoEstaSendoCriada() {
        Assert.assertFalse(this.context == null);
    }
}
