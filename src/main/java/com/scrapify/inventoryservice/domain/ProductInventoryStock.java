package com.scrapify.inventoryservice.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "product_inventory_stock")
public class ProductInventoryStock extends AuditableBase{
    @Column(name = "user_address_id")
    private String userAddressId;
    private String productId;
    private Double stock;
    private Double price;
}
