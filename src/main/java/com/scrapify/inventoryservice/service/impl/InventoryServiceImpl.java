package com.scrapify.inventoryservice.service.impl;

import com.scrapify.inventoryservice.dto.AddressDTO;
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

    @Autowired
    private UserAddressService userAddressService;

    @Override
//    @Transactional(isolation = Isolation.DEFAULT)
    public Inventory save(Inventory inventory) {
        AddressDTO addressDTO = userAddressService.findById(inventory.getUserAddressId());
        //MobileUserDTO mobileUser = userService.findById(addressDTO.getUser().getId());
        Inventory inventoryExist = inventoryRepository.findByProductIdAndUserAddressId(inventory.getProductId(),inventory.getUserAddressId());
        if(!ObjectUtils.isEmpty(inventoryExist)){
            inventoryExist.setStock(inventory.getStock());
            inventoryExist.setPrice(inventory.getPrice());
            inventoryExist.setUpdatedAt(new Date());
            //inventory.setUpdatedBy("admin");
            if(!ObjectUtils.isEmpty(addressDTO)){
                inventoryExist.setUpdatedBy(addressDTO.getUser().getEmail());
            }
            inventoryRepository.save(inventoryExist);
        }
        else{
            inventory.setCreatedAt(new Date());
            inventory.setUpdatedAt(new Date());
            if(!ObjectUtils.isEmpty(addressDTO)){
                inventory.setCreatedBy(addressDTO.getUser().getEmail());
                inventory.setUpdatedBy(addressDTO.getUser().getEmail());
            }
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

    @Override
    public List<Inventory> findByAddressId(String id) {
        return inventoryRepository.findByUserAddressId(id);
    }
}
