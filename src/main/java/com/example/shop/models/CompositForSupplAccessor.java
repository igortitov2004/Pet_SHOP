package com.example.shop.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
@Embeddable
@RequiredArgsConstructor
@EqualsAndHashCode
public class CompositForSupplAccessor implements Serializable {
    private SuppliesModel supply;
    private AccessoriesModel accessor;
    public CompositForSupplAccessor(SuppliesModel supply, AccessoriesModel accessor){
        this.supply=supply;
        this.accessor=accessor;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public SuppliesModel getSupply(){
        return supply;
    }
    public void setSupply(SuppliesModel supply){
        this.supply=supply;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public AccessoriesModel getAccessor(){
        return accessor;
    }
    public void setAccessor(AccessoriesModel accessor){
        this.accessor=accessor;
    }
}
