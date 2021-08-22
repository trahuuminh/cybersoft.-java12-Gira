package cybersoft.java12.gira.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import cybersoft.java12.gira.user.validation.annotation.UniqueEmail;
import cybersoft.java12.gira.user.validation.annotation.UniqueUsername;

public class CreateUserDto {
	
	@NotBlank(message = "{user.username.not-blank}")
	@UniqueUsername(message = "{user.username.unique}")
	private String username;
	
	@NotBlank(message = "{user.password.not-blank}")
	private String password;
	
	@NotBlank(message = "{user.confirm-password.not-blank}")
	private String confirmPassword;
	
	
	@NotBlank(message = "{user.email.not-blank}")
	@Email(message = "{user.email.valid}")
	@UniqueEmail(message = "{user.email.unique}")
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
