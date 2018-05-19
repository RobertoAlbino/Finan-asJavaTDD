package com.esucri.financa.model.base;

public abstract class Entity {
    public int id;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
