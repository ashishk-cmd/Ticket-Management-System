package com.tms.aiims.grievance;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableScheduling
@EnableAspectJAutoProxy
@ComponentScan(basePackages ={"com.tms.* ","com.tms.utils"})
public class AiimsTmsAppApisApplication extends SpringBootServletInitializer {
	
//	@Autowired
//	private RoleRepo roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AiimsTmsAppApisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@Override
//	public void run(String... args) throws Exception {
//		try {
//			Role role = new Role();
//			role.setName(AppConstants.ADMIN_USER);
//			
//			Role role1 = new Role();
//			role1.setName(AppConstants.NORMAL_USER);
//			
//			List<Role> roles = List.of(role,role1);
//			this.roleRepo.saveAll(roles);
			
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new Exception("Default Role not added. Something error occured.");
//		}
//	}
	
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
	
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
      return builder.sources(AiimsTmsAppApisApplication.class);
  }
	
}
