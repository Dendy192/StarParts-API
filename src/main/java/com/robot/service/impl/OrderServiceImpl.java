package com.robot.service.impl;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robot.dao.OrderDAO;
import com.robot.dao.OrderDetailDAO;
import com.robot.db.model.Order;
import com.robot.db.model.OrderDetail;
import com.robot.dto.OrderDTO;
import com.robot.repo.OrderDetailRepository;
import com.robot.repo.OrderRepository;
import com.robot.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Override
	public OrderDTO insertOrder(OrderDAO od) {
		// TODO Auto-generated method stub
		OrderDTO odt = new OrderDTO();
		Optional<OrderDAO> oodo = Optional.of(od);
		boolean status = false;
		String message = "Error";
		try {
			
			if(oodo.isPresent()) {
				List<OrderDetailDAO> orderDetailDao = od.getData();
				Order order = new Order();
				String date = changeDateFormat(od.getDate());
				String id = generateNumber(date);
				order.setId(id);
				order.setCustomerId(od.getCustomerId());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
				Date date1 = sdf.parse(od.getDate());
				order.setDate(java.sql.Date.valueOf(sdf.format(date1)));
				order.setTime(Time.valueOf(od.getTime()));
				order.setTotalPrice(od.getTotal());
				
				orderRepository.save(order);
//			order.setId();
				for(int i = 0; i < orderDetailDao.size(); i++) {
					OrderDetailDAO odao = orderDetailDao.get(i);
					OrderDetail odtl = new OrderDetail();
					odtl.setOrderDetailItem(odao.getItemName());
					odtl.setOrderId(id);
					odtl.setOrderDetailQty(odao.getQty());
					odtl.setOrderDetailPrice(odao.getItemHarga());
					odtl.setOrderDetailId(0);
					orderDetailRepository.save(odtl);
				}
				status = true;
				message = "success";
			}
		}catch (Exception e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		odt.setStatus(status);
		odt.setMessages(message);
		return odt;
	}
	
	public String generateNumber(String date) {
		Random randomID = new Random();
        StringBuilder sb = new StringBuilder();
        String result = "";
//        String id = "";
        do {
        	for (int i = 0; i < 4; i++) {
        		sb.append(randomID.nextInt(10));
        	}
        	result = "STPO-"+date+sb.toString();
        }while(!checkId(result));
        return result;
	}

	public String changeDateFormat(String date) {
		String result ="";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat sdf2 = new SimpleDateFormat("YYMM");
		try {
			Date date1 = sdf1.parse(date);
			result = sdf2.format(date1);
			
		}catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
		}
	    return result;
	}
	public boolean checkId(String id) {
		// TODO Auto-generated method stub
		boolean result = false;
		if(orderRepository.findById(id) !=null) {
			result = true;
		}
		return result;
	}

	@Override
	public OrderDTO deleteOrder(String id) {
		// TODO Auto-generated method stub
		boolean status = false;
		String message = "Error";
		OrderDTO odt = new OrderDTO();
		try {
			orderRepository.deleteById(id);
			status = true;
			message = "Success";
			
		}catch (Exception e) {
			// TODO: handle exception
			message = e.getMessage();
		}
		odt.setStatus(status);
		odt.setMessages(message);
		return odt;
	}

}
