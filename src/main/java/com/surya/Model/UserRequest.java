package com.surya.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

	private int userId;
	@NotNull(message="username shouldnot be null")
	private String name;
	@Email(message="invalid email address")
	private String email;
	@NotNull
	@Pattern(regexp="^\\d{10}$",message="invalid mobile number entered")
	private String mobile;
	private String gender;
	@Min(18)
	@Max(60)
	private String age;
	@NotBlank
	private String nationality;

}
