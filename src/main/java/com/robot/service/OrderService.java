package com.robot.service;

import com.robot.dao.OrderDAO;
import com.robot.dto.OrderDTO;

public interface OrderService {
	OrderDTO insertOrder(OrderDAO od);
	OrderDTO deleteOrder(String id);

}
