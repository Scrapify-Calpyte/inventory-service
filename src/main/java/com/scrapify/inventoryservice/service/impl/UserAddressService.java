package com.scrapify.inventoryservice.service.impl;

import com.scrapify.inventoryservice.dto.AddressDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserAddressService {
    private final WebClient webClient;

    public UserAddressService(WebClient webClient) {
        this.webClient = webClient;
    }

    public AddressDTO findById(String id){
        return webClient
                .get()
                .uri( "http://localhost:8001/user/user-address/by-id?id="+id)
                .retrieve()
                .bodyToMono(AddressDTO.class).block();
    }
}
