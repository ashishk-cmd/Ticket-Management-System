package com.tms.aiims.grievance.controllers;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.aiims.grievance.exceptions.ApiException;
import com.tms.aiims.grievance.models.Role;
import com.tms.aiims.grievance.models.User;
import com.tms.aiims.grievance.payload.requests.EmployeeRequest;
import com.tms.aiims.grievance.payload.requests.JwtAuthRequest;
import com.tms.aiims.grievance.payload.requests.OtpRequest;
import com.tms.aiims.grievance.payload.requests.PassKeyRequest;
import com.tms.aiims.grievance.payload.responses.JwtAuthResponse;
import com.tms.aiims.grievance.payload.responses.UserResponse;
import com.tms.aiims.grievance.repositories.UserRepo;
import com.tms.aiims.grievance.security.JwtTokenHelper;
import com.tms.aiims.grievance.services.AdminServices;
import com.tms.aiims.grievance.utils.CryptoUtil;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private AdminServices adminServices;
	@Autowired
	private UserRepo userRepository;
	 
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@Valid @RequestBody JwtAuthRequest request) throws Exception{
		String pass = CryptoUtil.decrypt(request.getPassword().trim());
		request.setPassword(pass.trim());
		this.authenticate(request.getUsername(),request.getPassword());
		
		UserDetails userDetails  = this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);
		
		JwtAuthResponse response = new JwtAuthResponse();
		User user = this.userRepository.findByEmployeeId(request.getUsername()).orElse(null);
		if(user != null) {
			Set<Role> role = this.adminServices.getRole(user);
			response.setEmpId(user.getEmployeeId());
			response.setUsername(user.getFullName());
			response.setToken(token);
			response.setRole(role);			
			return ResponseEntity.ok(response);
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }
	}

	private void authenticate(String username,String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken = new  UsernamePasswordAuthenticationToken(username,password);
		try {
			this.authenticationManager.authenticate(authenticationToken);
		} catch (BadCredentialsException e) {
			throw new ApiException("Invalid username or password !!");
		}
			
	}
	
	
	//register new user 
	@PostMapping("/forgetPassword")
	public ResponseEntity<Object> forgetUserPassword(@Valid @RequestBody EmployeeRequest user){
		try {
			UserResponse forgetUserPassword = this.adminServices.forgetUserPassword(user);
			return new ResponseEntity<Object>(forgetUserPassword,HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<Object>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/verifyOtp")
	public ResponseEntity<Object> VerifyOtp(@Valid @RequestBody OtpRequest user){
		try {
			UserResponse VerifyOtp = this.adminServices.VerifyOtp(user);
			return new ResponseEntity<Object>(VerifyOtp,HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<Object>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/updatePassword")
	public ResponseEntity<Object> updatePassword(@Valid @RequestBody PassKeyRequest user){
		try {
			UserResponse updatePassword = this.adminServices.updatePassword(user);
			return new ResponseEntity<Object>(updatePassword,HttpStatus.OK);				
		} catch (Exception e) {
			return new ResponseEntity<Object>(e,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
}
