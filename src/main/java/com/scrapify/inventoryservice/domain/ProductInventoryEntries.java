package com.scrapify.inventoryservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "product_inventory_entries")
public class ProductInventoryEntries extends AuditableBase{
    @Column(name = "user_address_id")
    private String userAddressId;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "price")
    private Double price;
}
