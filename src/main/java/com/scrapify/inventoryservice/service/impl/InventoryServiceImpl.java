package com.scrapify.inventoryservice.service.impl;

import com.scrapify.inventoryservice.entity.Inventory;
import com.scrapify.inventoryservice.repository.InventoryRepository;
import com.scrapify.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;


@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

//    @Autowired
//    private MobileUserService mobileUserService;

    @Override
//    @Transactional(isolation = Isolation.DEFAULT)
    public Inventory save(Inventory inventory) {
        //MobileUserDTO mobileUser = mobileUserService.findByUserId(inventory.getUserId());
        Inventory inventoryExist = inventoryRepository.findByProductIdAndUserAddressId(inventory.getProductId(),inventory.getUserAddressId());
        if(!ObjectUtils.isEmpty(inventoryExist)){
            inventoryExist.setStock(inventory.getStock());
            inventoryExist.setPrice(inventory.getPrice());
            inventoryExist.setUpdatedAt(new Date());
            inventory.setUpdatedBy("admin");
//            if(!ObjectUtils.isEmpty(mobileUser)){
//                inventoryExist.setUpdatedBy(mobileUser.getEmail());
//            }
            inventoryRepository.save(inventoryExist);
        }
        else{
            inventory.setCreatedAt(new Date());
            inventory.setUpdatedAt(new Date());
            inventory.setCreatedBy("admin");
            inventory.setUpdatedBy("admin");
//            if(!ObjectUtils.isEmpty(mobileUser)){

//            }
            inventoryRepository.save(inventory);
        }
        return inventory;
    }

    @Override
    public Inventory findByUserIdAndProductIdAndUserAddressId(String productId, String addressId) {
        return inventoryRepository.findByProductIdAndUserAddressId(productId, addressId);
    }

    @Override
    public List<Inventory> findByProductId(String productId) {
        return inventoryRepository.findByProductId(productId);
    }
}
