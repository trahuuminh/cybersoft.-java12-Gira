package cybersoft.java12.gira.user.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.java12.gira.common.util.ValidatorUtils;
import cybersoft.java12.gira.user.service.itf.UserService;
import cybersoft.java12.gira.user.validation.annotation.UniqueUsername;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String > {
	private String message;
	private UserService service;
	
	public UniqueUsernameValidator(UserService userService) {
		service =userService;
	}
	
	public void initialize(UniqueUsername constraintAnnotation) {
		message=constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if(username== null) {
			return false;
		}
		
		
		boolean isTaken=service.isTakenUsername(username);
		
		if(isTaken) {
			ValidatorUtils.addError(context, message);
			return false;
		}
		
		return true;
	}
	
}
