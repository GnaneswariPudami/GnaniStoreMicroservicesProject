/**
 * 
 */
package com.gnanistore.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sun.net.httpserver.Authenticator.Success;

/**
 * @author 504703
 *
 */
@WebMvcTest
@RunWith(SpringRunner.class)
class UserAuthenticationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private User user;

	/**
	 * Test method for {@link com.gnanistore.user.UserAuthenticationController#usersList()}.
	 * @throws Exception 
	 */
	@Test
	void testUsersList() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/userslist")
													.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
								.andExpect(status().isOk())
								.andReturn();
		System.out.println("Result ::: "+result);
	}

	/**
	 * Test method for {@link com.gnanistore.user.UserAuthenticationController#registerUser(com.gnanistore.user.User)}.
	 */
	@Test
	void testRegisterUser() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.gnanistore.user.UserAuthenticationController#authenticate(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testAuthenticate() {
		//fail("Not yet implemented");
	}

}
