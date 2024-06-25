package com.tms.aiims.grievance.models;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String fullName;
	@Column(nullable=false,unique = true)
	private String employeeId;
	@Column(nullable=false,unique = true)
	private String contactNo;
	private String email;
	@Transient
	private Lob profile;
	@Transient
	private Lob idCard;
	@Column(nullable=false)
	private String status;
	private Boolean enabled;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private Date registeredOn;
	private Date otpSentOn; 
	private int otp;
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="user_role",
				joinColumns = @JoinColumn(name="user",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="role",referencedColumnName = "id")
			)
	private Set<Role> roles = new HashSet<>();

	@OneToOne
	private Department department;
	
	
	// a class that implements the UserDetails interface as required by Spring Security.
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authories = this.roles.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return authories;
	}

	@Override
	public String getUsername() {
		return this.employeeId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
