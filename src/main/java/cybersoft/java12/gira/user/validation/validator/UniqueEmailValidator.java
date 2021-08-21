package cybersoft.java12.gira.user.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.java12.gira.common.util.ValidatorUtils;
import cybersoft.java12.gira.user.service.itf.UserService;
import cybersoft.java12.gira.user.validation.annotation.UniqueEmail;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	private String message;
	private UserService service;
	
	public void initialize(UniqueEmail constraintAnnotation) {
		message=constraintAnnotation.message();
	}
	
	public UniqueEmailValidator(UserService userService) {
		service =userService;
	}
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if(email==null)
			return false;
		
		boolean isTaken=service.isTakenEmail(email);
		
		if(isTaken) {
			ValidatorUtils.addError(context, message);
			return false;
		}
		
		return true;
	}

}
