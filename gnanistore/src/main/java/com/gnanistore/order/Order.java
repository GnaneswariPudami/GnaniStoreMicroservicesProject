/**
 * 
 */
package com.gnanistore.order;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.gnanistore.orderitem.OrderItem;

/**
 * @author Gnaneswari.Pudami
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "storeorder")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer orderId;
	@Getter @Setter private String paymentMethod;
	@Getter @Setter private Double orderTotal;
	@Getter @Setter private String orderStatus;
	@Getter @Setter private Integer addressId;
	@Getter @Setter private Integer userid;
	
	@OneToMany(mappedBy = "order")
	@Getter @Setter private List<OrderItem> orderItems;
}
