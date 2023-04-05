package com.scrapify.inventoryservice.service;

import com.scrapify.inventoryservice.entity.Inventory;

public interface InventoryService {

    Inventory save(Inventory inventory);

    Inventory findByUserIdAndProductIdAndUserAddressId(String productId, String addressId);
}
