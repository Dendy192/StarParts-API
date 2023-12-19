package com.robot.service;

import java.util.List;

import com.robot.dao.OrderDAO;
import com.robot.db.model.Order;
import com.robot.dto.OrderDTO;
import com.robot.dto.OrderDetailDTO;
import com.robot.dto.OrderLastDTO;

public interface OrderService {
	OrderDTO insertOrder(OrderDAO od);
	OrderDTO deleteOrder(String id);
	OrderLastDTO getLastOrder(String id);
	List<Order> getOrdersByCustomerIdAndStatus(String customerId, String status);
	List<OrderDetailDTO> getOrdersAndDetails(String customerId, String status);
}
