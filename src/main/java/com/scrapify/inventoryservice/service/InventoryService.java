package com.scrapify.inventoryservice.service;

import com.scrapify.inventoryservice.entity.Inventory;

import java.util.List;

public interface InventoryService {

    Inventory save(Inventory inventory);

    Inventory findByUserIdAndProductIdAndUserAddressId(String productId, String addressId);

    List<Inventory> findByProductId(String productId);
}
