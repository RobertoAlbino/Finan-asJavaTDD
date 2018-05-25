package com.esucri.financa.test.model.base;

import org.junit.Test;
import junit.framework.Assert;

import com.esucri.financa.model.base.Entity;

public class EntityTest extends Entity {
    
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {
        return;
    }

    @Override
    public String getTableName() {
        return "ENTITY_TEST";
    }
    
    @Test
    public void garantirToStringNaoRetornaNomeClasseEntity() {
        Assert.assertFalse("Entity".equals(toString()));
    }
    
    @Test
    public void garantirToStringRetornaNomeClasse() {
        Assert.assertEquals("EntityTest", toString());
    } 
}
