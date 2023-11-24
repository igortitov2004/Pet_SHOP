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
public class CompositForSoldAccessor implements Serializable {

    private SalesModel sale;
    private AccessoriesModel accessor;
    public CompositForSoldAccessor(SalesModel sale, AccessoriesModel accessor){
        this.sale=sale;
        this.accessor=accessor;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public SalesModel getSale(){
        return sale;
    }
    public void setSale(SalesModel sale){
        this.sale=sale;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public AccessoriesModel getAccessor(){
        return accessor;
    }
    public void setAccessor(AccessoriesModel accessor){
        this.accessor=accessor;
    }
}
