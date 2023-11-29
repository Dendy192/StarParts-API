package com.robot.service;

import com.robot.dao.OrderDAO;
import com.robot.dto.OrderDTO;
import com.robot.dto.OrderLastDTO;

public interface OrderService {
	OrderDTO insertOrder(OrderDAO od);
	OrderDTO deleteOrder(String id);
	OrderLastDTO getLastOrder(String id);
}
