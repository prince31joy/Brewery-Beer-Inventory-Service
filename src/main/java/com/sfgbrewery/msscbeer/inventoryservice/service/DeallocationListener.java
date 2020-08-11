package com.sfgbrewery.msscbeer.inventoryservice.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sfgbrewery.model.events.AllocateOrderRequest;
import com.sfgbrewery.msscbeer.inventoryservice.config.JmsConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class DeallocationListener {

	private final AllocationService allocationService;
	
	@JmsListener(destination = JmsConfig.DEALLOCATE_ORDER_QUEUE)
	public void listen(AllocateOrderRequest request) {
		allocationService.deallocateOrder(request.getBeerOrderDto());
	}
}
