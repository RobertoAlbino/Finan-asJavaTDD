package com.esucri.financa.model.base;

public abstract class Entity {
    
    public abstract int getId();
    public abstract void setId(int id);
    public abstract String getTableName();
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
