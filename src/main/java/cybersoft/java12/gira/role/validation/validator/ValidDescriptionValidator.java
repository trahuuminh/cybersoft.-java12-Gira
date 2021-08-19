package cybersoft.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.java12.gira.common.util.ValidatorUtils;
import cybersoft.java12.gira.role.service.itf.RoleService;
import cybersoft.java12.gira.role.validation.annotation.ValidDescription;


public class ValidDescriptionValidator implements ConstraintValidator<ValidDescription, String> {

	
	private String message;
	
	public ValidDescriptionValidator(RoleService roleService) {
		
	}
	
	@Override
	public void initialize(ValidDescription constraintAnnotation) {
		this.message=constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(String description, ConstraintValidatorContext context) {
		
		
		if(description==null) {
			ValidatorUtils.addError(context,message);
			return false;
		}
		
		description=description.trim();
		
		if(description.length()< 10) {
			ValidatorUtils.addError(context, message);
			return false;
		}
			
		return true;
	}
	
}
