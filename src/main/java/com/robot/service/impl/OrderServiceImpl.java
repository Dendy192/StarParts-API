package com.robot.service.impl;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robot.dao.DiscountsDetailDAO;
import com.robot.dao.OrderDAO;
import com.robot.dao.OrderDetailDAO;
import com.robot.db.model.Discount;
import com.robot.db.model.Items;
import com.robot.db.model.Order;
import com.robot.db.model.OrderDetail;
import com.robot.db.model.OrderDiscounts;
import com.robot.dto.OrderDTO;
import com.robot.dto.OrderLastDTO;
import com.robot.dto.OrderLastDTOData;
import com.robot.repo.DiscountsDetailRepository;
import com.robot.repo.DiscountsRepository;
import com.robot.repo.ItemsRepository;
import com.robot.repo.OrderDetailRepository;
import com.robot.repo.OrderDiscountsRepository;
import com.robot.repo.OrderRepository;
import com.robot.service.OrderService;

import id.git.utils.SQLData;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	DiscountsRepository discountsRepository;
	
	@Autowired
	OrderDiscountsRepository orderDiscountsRepository;
	
	@Autowired
	ItemsRepository itemsRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public OrderDTO insertOrder(OrderDAO od) {
		// TODO Auto-generated method stub
		OrderDTO odt = new OrderDTO();
		Optional<OrderDAO> oodo = Optional.ofNullable(od);
		boolean status = false;
		String message = "Error";
		System.out.println(od.toString());
		System.out.println(oodo.isPresent());
		try {
			System.out.println(oodo.isPresent());
			if(oodo.isPresent()) {
				List<OrderDetailDAO> orderDetailDao = od.getData();
				if (!isStockAvailable(orderDetailDao)) {
	                message = "Out of Stock";
	                throw new RuntimeException("Out of Stock");// ini trigger rollback
	            } else {
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
				order.setStatus("Pending");
				List<DiscountsDetailDAO> oddao = od.getDiscount();
				orderRepository.save(order);
				for(DiscountsDetailDAO da : oddao) {
					String dcName = da.getName();
					System.out.println("Discount insert "+dcName);
					if(dcName.equals("Retail") || dcName.equals("Semi Grossir") || dcName.equals("Grossir")) {
//						OrderDiscounts od = new
						System.out.println("masuk dcname");
						OrderDiscounts ods = new OrderDiscounts();
						ods.setDiscountId("Outlet");
						ods.setDiscountName(dcName);
						ods.setOrderId(id);
//						ods.setId(1);
						orderDiscountsRepository.save(ods);
						
					}else {
						Discount dsc = discountsRepository.findBydiscountName(dcName);		
						OrderDiscounts ods = new OrderDiscounts();
						ods.setDiscountId(dsc.getDiscountId());
						ods.setDiscountName(dcName);
						ods.setOrderId(id);
//						ods.setId(2);
						orderDiscountsRepository.save(ods);
					}
				}
				
//			order.setId();
				System.out.println("ke sini");
				for(int i = 0; i < orderDetailDao.size(); i++) {
					OrderDetailDAO odao = orderDetailDao.get(i);
					OrderDetail odtl = new OrderDetail();
					System.out.println("Order detauk "+odao.getItemId());
					odtl.setOrderDetailItem(odao.getItemId());
					odtl.setOrderId(id);
					odtl.setOrderDetailQty(odao.getQty());
					odtl.setOrderDetailPrice(odao.getItemHarga());
//					odtl.setOrderDetailId(0);
					orderDetailRepository.save(odtl);
				}
				System.out.println("ke sini");
				status = true;
				message = "success";
	            }
			}
		}catch (Exception e) { //ini juga jadi trigger rollback
			// TODO: handle exception
			message = e.getMessage();
			e.printStackTrace();
		}
		System.out.println("Ending "+status);
		odt.setStatus(status);
		odt.setMessages(message);
		return odt;
	}
		
	private boolean isStockAvailable(List<OrderDetailDAO> orderDetails) {
		 for (OrderDetailDAO odao : orderDetails) {
		     if (!isItemStockAvailable(odao.getItemId(), odao.getQty())) {
		         return false;
		    }
		}
		return true;
	}
	
	private boolean isItemStockAvailable(String itemId, int qty) {
	    try {
	        Items item = itemsRepository.findById(itemId)
	        		.orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));

	        synchronized (item) {
	            if (item.getItemStock() >= qty) {
	                item.setItemStock(item.getItemStock() - qty);
	                itemsRepository.save(item);
	                return true;
	            } else {
	                return false;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
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
	    System.out.println("dari change date format "+date);
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

	@Override
	public OrderLastDTO getLastOrder(String id) {
		String idOrder = SQLData.getOrderId(id);
		List<OrderLastDTOData> oldtp = new ArrayList<>();
		OrderLastDTO oldt = new OrderLastDTO(); 
		boolean result = false;
		if(idOrder.equals("false")) {
			oldt.setStatus(result);
		}else {
			result = true;
			List<String[]> getItem = SQLData.getLastOrder(idOrder);
			for(int i =0; i< getItem.size(); i++) {
				OrderLastDTOData old = new OrderLastDTOData();
				String[] items = getItem.get(i);
				if(items[1].equals("FDR")) {
					old.setItemCategory(items[3]);
				}else {
					old.setItemCategory(items[2]);
				}
				old.setItemId(items[0]);
				old.setItemQty(items[4]);
				oldtp.add(old);
			}
			oldt.setStatus(result);
			oldt.setData(oldtp);
		}
		return oldt;
	}
	
	

}
