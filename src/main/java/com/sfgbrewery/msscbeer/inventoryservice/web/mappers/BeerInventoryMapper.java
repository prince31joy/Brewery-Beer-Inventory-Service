package com.sfgbrewery.msscbeer.inventoryservice.web.mappers;

import org.mapstruct.Mapper;

import com.sfgbrewery.model.BeerInventoryDto;
import com.sfgbrewery.msscbeer.inventoryservice.domain.BeerInventory;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

	BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

	BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
