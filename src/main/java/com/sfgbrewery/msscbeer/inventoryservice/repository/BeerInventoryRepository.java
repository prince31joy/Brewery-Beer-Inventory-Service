package com.sfgbrewery.msscbeer.inventoryservice.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sfgbrewery.msscbeer.inventoryservice.domain.BeerInventory;

public interface BeerInventoryRepository extends JpaRepository<BeerInventory, UUID> {
	
	List<BeerInventory> findAllByBeerId(UUID beerId);

	List<BeerInventory> findAllByUpc(String upc);
}
