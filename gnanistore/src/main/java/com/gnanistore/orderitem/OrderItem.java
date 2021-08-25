/**
 * 
 */
package com.gnanistore.orderitem;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gnanistore.order.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gnaneswari.Pudami
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer orderItemId;
	
	@Getter @Setter private String partNumber;
	@Getter @Setter private String sku;
	@Getter @Setter private String shortDescription;
	@Getter @Setter private String longDescription;
	@Getter @Setter private String imageUrl;
	@Getter @Setter private Double price;
	@Getter @Setter private Integer quantity;
	@Getter @Setter private Double orderItemTotal;
	@Getter @Setter private String orderItemStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Getter @Setter private Order order;
}
