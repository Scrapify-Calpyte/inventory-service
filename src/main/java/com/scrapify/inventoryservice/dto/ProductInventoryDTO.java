package com.scrapify.inventoryservice.dto;

import lombok.Data;

@Data
public class ProductInventoryDTO {
    private String id;
    private String userAddressId;
    private String productId;
    private Double stock;
    private Double price;
}
