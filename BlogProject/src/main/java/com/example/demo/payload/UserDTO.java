package com.example.demo.payload;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class UserDTO {
	private int id;
	@NotEmpty
	@Size(min = 4,message = "username must be min of 4 characters")
  private String name;
	@Email(message = "email address is not valid")
  private String email;
	@NotEmpty
	@Size(min = 3,max = 10,message = "pasword must be 3 characters and ")
  private String password;
	@NotEmpty
  private String about;
}
