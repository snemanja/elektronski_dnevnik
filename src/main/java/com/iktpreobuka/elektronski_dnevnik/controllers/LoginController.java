package com.iktpreobuka.elektronski_dnevnik.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.elektronski_dnevnik.dto.LoginDTO;
import com.iktpreobuka.elektronski_dnevnik.entities.UserEntity;
import com.iktpreobuka.elektronski_dnevnik.repositories.UserRepository;
import com.iktpreobuka.elektronski_dnevnik.validators.Encryption;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path = "/api/v1/login")
public class LoginController {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepo;
	@Value("${spring.security.secret-key}")
	private String secretKey;
	@Value("${spring.security.token-duration}")
	private Integer duration;
	
	@PostMapping
	public ResponseEntity<?> loging(@RequestParam String username, @RequestParam String password){
		List<UserEntity> users = (List<UserEntity>) userRepo.findAll();
		
		for(UserEntity user : users) {
			if(user.getUsername().equals(username) && Encryption.validatePassword(password, user.getPassword())){
				
				String token = getJWTToken(user);
				
				LoginDTO loginDto = new LoginDTO();
				loginDto.setUsername(username);
				loginDto.setToken(token);
				
				logger.info(loginDto.getUsername() + " : se ulogovao.");
				
				return new ResponseEntity<>(loginDto, HttpStatus.OK);
				
			}
		}
		return null;
	}

	private String getJWTToken(UserEntity user) {
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole().name());
		
		String token = Jwts.builder().setId("softtekJWT").setSubject(user.getUsername()).claim("authorities",
				grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
		logger.info(user.toString() + " : odobren token");
		return  "Bearer " + token;
	}
	

}
