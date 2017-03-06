package com.example;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

import com.example.Services.UserService;
import com.example.controllers.UserController;
import com.example.domain.User;

public class UserControllerTest {
	
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	 private MockMvc mockMvc;
	 
	 
	 @Before
	 public void setup(){
	        MockitoAnnotations.initMocks(this);

	        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	 
	 
//	@Test
//	public void testList() throws Exception {
//	    List<User> users = new ArrayList<>();
//	    users.add(new User());
//	    users.add(new User());
//
//
//	    when(userService.findAll()).thenReturn((List) users);
//
//	    mockMvc.perform(get("/list"))
//	            .andExpect(status().isOk())
//	            .andExpect(view().name("Userlist"))
//	            .andExpect(model().attribute("users", hasSize(2)));
//	}	    
//	    
	
	

	
//	@Test
//	public void testSave() throws Exception {
//		
//		String pps = "1234ab";
//		String name = "David";
//		
//		Date dateOfBirth = new SimpleDateFormat( "ddMMyyyy" ).parse("1990-06-20");
//		String pattern = "dd-MM-yyyy";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		// 1990-06-20
//		simpleDateFormat.format(dateOfBirth);
//		
//		Date d = new Date();
//		String mobilePhoneNumber = "0871234567";
//				
//		User user = new User();
//		user.setPps(pps);
//		user.setName(name);
//		//user.setDateOfBirth(d);
//		user.setMobilePhoneNumber(mobilePhoneNumber);
//		
//		 when(userService.save(Matchers.<User>any())).thenReturn(user);
//		 when(userService.findByPps(Matchers.<String>any())).thenReturn(user);
//		 
//		 
//		 mockMvc.perform((RequestBuilder) ((ResultActions) post("/user")
//			        .param("pps", pps)
//			        .param("name", name)
//			       // .param("dateOfBirth", "20/06/1990")
//			        .param("mobilePhoneNumber", mobilePhoneNumber))
//			                .andExpect(status().is3xxRedirection())
//			                .andExpect(view().name("Index")));
//		 
//		 
//		 ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
//	        verify(userService).save(userCaptor.capture());
//
//	        User boundUser = userCaptor.getValue();
//
//	        assertEquals(pps, boundUser.getPps());
//	        assertEquals(name, boundUser.getName());
//	      //  assertEquals(dateOfBirth, boundUser.getDateOfBirth());
//	        assertEquals(mobilePhoneNumber, boundUser.getMobilePhoneNumber());
//	        
//	}
	    
	    
	    
	    
	    
	 
	 
}
