package com.iktpreobuka.elektronski_dnevnik.dto;

import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class LoginDTO {
	
	private String username;
	private String token;

}
