/**
 * 
 */
package com.gnanistore.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnanistore.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Gnaneswari.Pudami
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private int addressId;
	
	@Getter @Setter private String address1;
	@Getter @Setter private String address2;
	@Getter @Setter private String city;
	@Getter @Setter private String state;
	@Getter @Setter private String country;
	@Getter @Setter private String phone_number;
	@Getter @Setter private String zipcode;
	@Getter @Setter private String addressType;
	
	@Column(name = "userid")
	@Getter @Setter private Integer userid;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@Getter @Setter private User user;
}
