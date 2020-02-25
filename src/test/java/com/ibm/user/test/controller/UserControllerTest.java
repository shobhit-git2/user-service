package com.ibm.user.test.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.user.controller.UserController;
import com.ibm.user.exception.UserAlreadyExistsException;
import com.ibm.user.model.User;
import com.ibm.user.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private User user;
	@MockBean
	UserService userService;
	@InjectMocks
	UserController userController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		user = new User();
		user.setId("JohnS2");
		user.setFirstName("John");
		user.setLastName("Simon");
		user.setUserName("Simon");
		user.setContactNumber("9898989898");
		user.setPassword("123456");
		user.setCreatedDate(new Date());
	}

	@Test
	public void registerUserSuccess() throws Exception {

		when(userService.registerUser(any())).thenReturn("success");
		mockMvc.perform(
				post("/api/v1/user/register").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

	}

	@Test
	public void registerUserFailure() throws Exception {

		when(userService.registerUser(any())).thenThrow(UserAlreadyExistsException.class);
		mockMvc.perform(
				post("/api/v1/user/register").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());

	}

	//@Test
	public void authenticateUserSuccess() throws Exception {

		when(userService.authenticateUser(user.getUserName(), user.getPassword())).thenReturn(user);
		mockMvc.perform(
				post("/api/v1/user/authenticate").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

	}

	//@Test
	public void authenticateUserFailure() throws Exception {

		when(userService.authenticateUser(user.getUserName(), user.getPassword())).thenReturn(null);
		mockMvc.perform(
				post("/api/v1/user/authenticate").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isUnauthorized()).andDo(MockMvcResultHandlers.print());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
