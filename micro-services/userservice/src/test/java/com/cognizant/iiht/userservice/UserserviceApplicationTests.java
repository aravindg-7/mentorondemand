package com.cognizant.iiht.userservice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.iiht.userservice.exception.UserAlreadyExistsException;
import com.cognizant.iiht.userservice.model.User;
import com.cognizant.iiht.userservice.security.AppUserDetailsService;

@SpringBootTest
class UserserviceApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private AppUserDetailsService userservice;
    @Test
    public void testUserSignup() throws UserAlreadyExistsException {
                    
    
                    User u =new User();
                    
                    u.setUsername("testUser");
                    u.setPassword("pwd");
                    u.setContactnumber(9100560867l);
                    u.setFirstname("asdasd");
                    u.setLastname("asd");
                    u.setRole("user");
        assertEquals(userservice.signup(u),true);
                    
    }
    

}
