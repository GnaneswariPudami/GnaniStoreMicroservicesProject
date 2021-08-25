/**
 * 
 */
package com.gnanistore.orderitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 504703
 *
 */
@Service
@Transactional
public class OrderItemService {
	@Autowired
	OrderItemRepository orderItemRepo;
	
	public List<OrderItem> findAllByOrderId(Integer orderId){
		return null;
	}
	
	public void saveOrderItem(OrderItem orderItem) {
		orderItemRepo.save(orderItem);
	}
	
	public void deleteOrderItem(Integer orderItemId) {
		orderItemRepo.deleteById(orderItemId);
	}
	
	public void updateOrderItem(OrderItem orderItem) {
		
	}
}
