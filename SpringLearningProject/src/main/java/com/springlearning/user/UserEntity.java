/**
 * 
 */
package com.springlearning.user;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springlearning.address.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * @author 504703
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class UserEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private int userid;
	
	@NotEmpty(message = "Username shouldn't be empty")
	@Getter @Setter private String username;
	
	@NotEmpty(message = "Password shouldn't be empty")
	@Getter @Setter private String password;
	
	@NotEmpty(message = "Firstname shouldn't be empty")
	@Getter @Setter private String firstname;
	
	@NotEmpty(message = "Lastname shouldn't be empty")
	@Getter @Setter private String lastname;
	
	@NotEmpty(message = "Email ID shouldn't be empty")
	@Email(message = "Email should be a valid email")
	@Getter @Setter private String emailId;
	
	@NotEmpty(message = "Date of Birth shouldnt be empty")
	@Past(message = "Date of Birth should be past date")
	@Getter @Setter private Date dateOfBirth;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Getter @Setter private List<Address> addresses;
	 
}
