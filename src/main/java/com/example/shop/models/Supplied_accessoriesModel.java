package com.example.shop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="supplied_accessories")
@AllArgsConstructor
@Data
@NoArgsConstructor
@AssociationOverrides({
        @AssociationOverride(name = "id.supply",joinColumns = @JoinColumn(name = "id_supply_for_accessories")),
        @AssociationOverride(name = "id.accessor",joinColumns = @JoinColumn(name = "accessor_id_for_supplies"))
})
public class Supplied_accessoriesModel {
    CompositForSupplAccessor id = new CompositForSupplAccessor();
    private int amount;
    @Column(name="id_supply_for_accessories")
    private SuppliesModel supply;
    @Column(name="accessor_id_for_supplies")
    private  AccessoriesModel accessor;
    @EmbeddedId
    public CompositForSupplAccessor getId(){
        return id;
    }
    public void setId(CompositForSupplAccessor id){
        this.id=id;
    }
    @Column(name = "amount_of_supplied_accessor")
    public int getAmount(){
        return amount;
    }
    @Column(name = "amount_of_supplied_accessor")
    public void setAmount(int amount){
        this.amount=amount;
    }
    @Transient
    public SuppliesModel getSupply(){
        return supply;
    }
    public void setSupply(SuppliesModel supply){
        this.supply=supply;
    }
    @Transient
    public AccessoriesModel getAccessor(){
        return accessor;
    }
    public void setAccessor(AccessoriesModel accessor){
        this.accessor=accessor;
    }
}
