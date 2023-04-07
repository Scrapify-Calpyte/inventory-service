package com.scrapify.inventoryservice.repository;

import com.scrapify.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory,String> {

    Inventory findByProductIdAndUserAddressId(String productId, String addressId);

    List<Inventory> findByProductId(String productId);

    List<Inventory> findByUserAddressId(String id);
}
