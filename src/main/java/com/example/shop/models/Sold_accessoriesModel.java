package com.example.shop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="sold_accessories")
@AllArgsConstructor
@Data
@NoArgsConstructor
@AssociationOverrides({
        @AssociationOverride(name = "id.sale",joinColumns = @JoinColumn(name = "id_sales_for_accessor")),
        @AssociationOverride(name = "id.accessor",joinColumns = @JoinColumn(name = "accessor_id_for_sale"))
})
@EqualsAndHashCode
public class Sold_accessoriesModel {
    CompositForSoldAccessor id = new CompositForSoldAccessor();

    private int amount;
    @Column(name="id_sales_for_accessor")
    private SalesModel sale;

    @Column(name="accessor_id_for_sale")
    private  AccessoriesModel accessor;


    @EmbeddedId
    public CompositForSoldAccessor getId(){
        return id;
    }
    public void setId(CompositForSoldAccessor id){
        this.id=id;
    }


    @Column(name = "amount_of_sold_accessor")
    public int getAmount(){
        return amount;
    }
    @Column(name = "amount_of_sold_accessor")
    public void setAmount(int amount){
        this.amount=amount;
    }


    @Transient
    public SalesModel getSale(){
        return sale;
    }
    public void setSale(SalesModel sale){
        this.sale=sale;
    }
    @Transient
    public AccessoriesModel getAccessor(){
        return accessor;
    }
    public void setAccessor(AccessoriesModel accessor){
        this.accessor=accessor;
    }
}
