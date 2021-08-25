/**
 * 
 */
package com.gnanistore.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gnaneswari.Pudami
 *
 */
@Service
@Transactional
public class OrderService {
	@Autowired
	OrderRepository orderRepo;
	
	public List<Order> findAllOrdersByUserId(Integer userId){
		return null;
	}
	
	public Order findByOrderId(Integer orderId) {
		return orderRepo.getById(orderId);
	}
	
	public void saveOrder(Order order) {
		orderRepo.save(order);
	}
	
	public void deleteOrder(Integer orderId) {
		orderRepo.deleteById(orderId);
	}
}
