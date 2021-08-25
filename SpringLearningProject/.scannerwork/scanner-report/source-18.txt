/**
 * 
 */
package com.springlearning.address;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springlearning.user.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 504703
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private int addressId;
	
	@NotEmpty(message="Address shouldn't be empty")
	@Getter @Setter private String address1;
	
	@Getter @Setter private String address2;
	
	@Getter @Setter private String city;
	
	@Getter @Setter private String state;
	
	@NotEmpty(message="Country shouldn't be empty")
	@Getter @Setter private String country;
	
	@NotEmpty(message="Phone number shouldn't be empty")
	@Getter @Setter private String phone_number;
	
	@NotEmpty(message="Zipcode shouldn't be empty")
	@Getter @Setter private String zipcode;
	
	@Value("SB")
	@Getter @Setter private String addressType;
	
	@JsonIgnore
	 @ManyToOne(fetch = FetchType.LAZY)
	 @Getter @Setter private UserEntity user;
	 
}
