package cybersoft.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.java12.gira.common.util.ValidatorUtils;
import cybersoft.java12.gira.role.service.itf.RoleService;
import cybersoft.java12.gira.role.validation.annotation.ExistRoleId;


public class ExistRoleIdValidator implements ConstraintValidator<ExistRoleId, Long>{
	private String message;
	private RoleService service;
	
	public ExistRoleIdValidator(RoleService roleService) {
		service=roleService;
	}
	
	@Override
	public void initialize(ExistRoleId constraintAnnotation) {
		this.message=constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(Long roleId, ConstraintValidatorContext context) {
		boolean isExisted= service.isExisted(roleId);
		
		if(isExisted)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}
	
}
