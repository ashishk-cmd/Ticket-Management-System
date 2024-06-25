package com.tms.aiims.grievance.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tms.aiims.grievance.config.AppConstants;
import com.tms.aiims.grievance.exceptions.ApiException;
import com.tms.aiims.grievance.exceptions.ResourceNotFoundException;
import com.tms.aiims.grievance.models.User;
import com.tms.aiims.grievance.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loading user form database by user name
//		System.out.println("line 24 "+ username);
		User user = this.userRepo.findByEmployeeId(username).orElseThrow(()-> new ResourceNotFoundException("User", "Employee Id : ", username));
//		System.out.println("line 26 " + user.getEmployeeId() + " " + user.getId() + " "+ user.getEmail());
		if(user.getStatus().equalsIgnoreCase("NEW")) {
			user.setStatus(AppConstants.ACTIVE_USER_STATUS);
			this.userRepo.save(user);
		}
		if(user.getEnabled().equals(true)) {
			return user;			
		}else {
			throw new ApiException("Invalid username or password. Contact to your Admin!!");
		}
		
	}
}
