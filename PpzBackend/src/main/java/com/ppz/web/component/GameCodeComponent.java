package com.ppz.web.component;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ppz.web.repository.UserRepository;

@Component
public class GameCodeComponent {
	
	@Autowired
	UserRepository userRepository;
	
	public String generateUniqueGameCode() {
		while (true) {
	        String str = new String("nopgdkmraghfsijcbevwxtyzu");
	        StringBuilder sb = new StringBuilder();
	     	SecureRandom r = new SecureRandom();
	     	int randomInt = 0;
	     	for(int i = 0; i < 8; i++) {
	     		randomInt = r.nextInt(str.length());
	     		sb.append(str.charAt(randomInt));
	     	}	
	     	String generatedGameCode = sb.toString();
			
			if (userRepository.loadUserByCode(generatedGameCode) == null) {
				return generatedGameCode;
			}
		}
	}

}
