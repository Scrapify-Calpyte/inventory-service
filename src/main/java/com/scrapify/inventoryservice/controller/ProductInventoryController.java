package com.scrapify.inventoryservice.controller;

import com.scrapify.inventoryservice.dto.ProductInventoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class ProductInventoryController {

    @PostMapping("/")
    public ResponseEntity saveProductInventory(@RequestBody ProductInventoryDTO productInventoryDTO) {

        return ResponseEntity.ok().build();
    }

}
