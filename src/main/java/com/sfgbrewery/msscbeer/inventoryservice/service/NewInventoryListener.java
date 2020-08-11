package com.sfgbrewery.msscbeer.inventoryservice.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.sfgbrewery.model.events.NewInventoryEvent;
import com.sfgbrewery.msscbeer.inventoryservice.config.JmsConfig;
import com.sfgbrewery.msscbeer.inventoryservice.domain.BeerInventory;
import com.sfgbrewery.msscbeer.inventoryservice.repository.BeerInventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class NewInventoryListener {
	
	private final BeerInventoryRepository beerInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event){

        log.debug("Got Inventory: " + event.toString());

        beerInventoryRepository.save(BeerInventory.builder()
                .beerId(event.getBeerDto().getId())
                .upc(event.getBeerDto().getUpc())
                .quantityOnHand(event.getBeerDto().getQuantityOnHand())
                .build());
    }

}
