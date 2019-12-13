package com.cognizant.iiht.userservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.iiht.userservice.model.User;
import com.cognizant.iiht.userservice.repository.UserRepository;


@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userrepository;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User u=userrepository.findByUsername(name);
		if(u== null){
			throw new UsernameNotFoundException("no user");
		}
		else	
		AppUser au= new AppUser(u);
		return au;
	}
	public AppUserDetailsService(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}
	
	public boolean signup(User newuser){
		User u=userrepository.findByUsername(newuser.getUsername());
		if(u==null)
		{
			String password=newuser.getPassword();
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			String newpassword=encoder.encode(password);
			newuser.setPassword(newpassword);
			userrepository.save(newuser);
			return true;
		}
		else
			return false;
	}
	
	

}

