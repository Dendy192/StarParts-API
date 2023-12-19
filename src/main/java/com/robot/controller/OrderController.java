package com.robot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robot.dao.OrderDAO;
import com.robot.db.model.Order;
import com.robot.dto.OrderDTO;
import com.robot.dto.OrderDetailDTO;
import com.robot.dto.OrderLastDTO;
import com.robot.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/api/lastOrder")
	public OrderLastDTO lastOrder(@RequestParam String id) {
		return orderService.getLastOrder(id);
	}
	
	@PostMapping("/api/orders")
	public OrderDTO saveOrder(@RequestBody OrderDAO od) {
		return orderService.insertOrder(od);
	}
	
	@DeleteMapping("/api/orders")
	public OrderDTO deleteOrder(@RequestParam String id) {
		return orderService.deleteOrder(id);
	}
	
	@GetMapping("/api/getOrder")
    public List<Order> getOrders(
            @RequestParam(required = false) String customerId,
            @RequestParam(required = false) String status) {
        return orderService.getOrdersByCustomerIdAndStatus(customerId, status);
    }
	
	@GetMapping("/api/getOrderDetail")
    public List<OrderDetailDTO> getOrdersDetail(
            @RequestParam(required = false) String customerId,
            @RequestParam(required = false) String status) {
        return orderService.getOrdersAndDetails(customerId, status);
    }
}
