package test.com.esucri.financa.model.base;

import org.junit.Test;

import com.esucri.financa.model.base.Entity;

import junit.framework.Assert;

public class EntityTest extends Entity {
    
    @Test
    public void garantirToStringNaoRetornaNomeEntityBase() {
        Assert.assertFalse("Entity".equals(toString()));
    }
    
    @Test
    public void garantirToStringRetornaNomeClasse() {
        Assert.assertEquals("EntityTest", toString());
    } 
}
