package com.example.oms1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService service;

	@PostMapping
	void saveUser(@RequestBody Order order) {
		System.out.println(order.getItem());
		System.out.println(order.getPrice());

		service.saveOrder(order);
	}

	@GetMapping
	List<Order> fetchOrder() {
		return service.getOrders();
	}
}
