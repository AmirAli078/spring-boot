package com.demo.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message="User name must contain 4 letters")
	private String name;
	@Email(message="Eamil address is not valid!!")
	@NotNull
	private String email;
	
	@NotNull
	@NotBlank
	@Size(min = 3,max = 10, message="Password must have min 3 char and max 10 character")
	private String password;
	
	@NotNull
	@NotBlank
	private String about;
	

	
}
