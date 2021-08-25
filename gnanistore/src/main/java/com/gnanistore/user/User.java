/**
 * 
 */
package com.gnanistore.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.gnanistore.address.Address;

/**
 * @author Gnaneswari Pudami
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private int userid;
	
	@Getter @Setter private String username;
	@Getter @Setter private String password;
	@Getter @Setter private String firstname;
	@Getter @Setter private String lastname;
	@Getter @Setter private Long phonenumber;
	
	@OneToMany(mappedBy = "user")
	@Getter @Setter private List<Address> addresses;
	
}
