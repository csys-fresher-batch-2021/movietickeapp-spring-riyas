package in.riyasahamed.controller;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.riyasahamed.exceptions.ServiceException;
import in.riyasahamed.model.User;
import in.riyasahamed.service.UserService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userServiceMock;
	
	@InjectMocks
	UserController userController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	  	void testLogin() throws Exception {
		User userObj = new User();
		userObj.setUserName("riyas21052");
		userObj.setPassword("Riiyas@12");
		when(userServiceMock.userLogin(any(String.class),any(String.class))).thenReturn(true);
		
		String userJson = new ObjectMapper().writeValueAsString(userObj);
		mockMvc.perform(post("/userLogin").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk()).andExpect(jsonPath("$.infoMessage").value("Successfully Logged In"));
	}
	
	@Test
  	void testLoginWithInvalidCredentials() throws Exception {
	User userObj = new User();
	userObj.setUserName("riyas21054");
	userObj.setPassword("Riiyas@12");
	when(userServiceMock.userLogin(any(String.class),any(String.class))).thenThrow(new ServiceException("Invalid Login Credentials"));
	
	String userJson = new ObjectMapper().writeValueAsString(userObj);
	mockMvc.perform(post("/userLogin").contentType(MediaType.APPLICATION_JSON).content(userJson))
			.andExpect(status().isBadRequest()).andExpect(jsonPath("$.errorMessage").value("Invalid Login Credentials"));
}

	
	
	

}
