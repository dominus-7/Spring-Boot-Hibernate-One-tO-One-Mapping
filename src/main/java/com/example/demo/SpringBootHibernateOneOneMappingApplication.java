package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Gender;
import com.example.demo.entity.User;
import com.example.demo.entity.UserProfile;
import com.example.demo.repositories.UserProfileRepository;
import com.example.demo.repositories.UserRepository;

@SpringBootApplication
public class SpringBootHibernateOneOneMappingApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateOneOneMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User();
		user.setName("Ahmad");
		user.setEmail("impact@gmail.com");
		
		UserProfile userProfile = new UserProfile();
		userProfile.setAdress("Bouskoura");
		userProfile.setDateOfBirth(LocalDate.of(1989, 10, 04));
		userProfile.setGender(Gender.MALE);
		userProfile.setPhoneNnumber("12343554");
		
		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		
		userRepository.save(user);
		
	}

}
