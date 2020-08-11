package com.sfgbrewery.msscbeer.inventoryservice.service;

import com.sfgbrewery.model.BeerOrderDto;

public interface AllocationService {

	Boolean allocateOrder(BeerOrderDto beerOrderDto);

	void deallocateOrder(BeerOrderDto beerOrderDto);

}
