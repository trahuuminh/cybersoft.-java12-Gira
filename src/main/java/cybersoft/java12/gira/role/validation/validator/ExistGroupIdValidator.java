package cybersoft.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.java12.gira.common.util.ValidatorUtils;
import cybersoft.java12.gira.role.service.itf.GroupService;
import cybersoft.java12.gira.role.validation.annotation.ExistGroupId;

public class ExistGroupIdValidator implements ConstraintValidator<ExistGroupId, Long> {
	private String message;
	private GroupService service;
	
	public ExistGroupIdValidator(GroupService groupService) {
		service = groupService;
	}

	@Override
	public void initialize(ExistGroupId constraintAnnotation) {
		message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(Long groupId, ConstraintValidatorContext context) {
		boolean isExisted = service.isExisted(groupId);
		
		if(isExisted)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}
