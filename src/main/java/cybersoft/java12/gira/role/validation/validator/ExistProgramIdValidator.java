package cybersoft.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.java12.gira.common.util.ValidatorUtils;
import cybersoft.java12.gira.role.service.itf.ProgramService;
import cybersoft.java12.gira.role.validation.annotation.ExistProgramId;


public class ExistProgramIdValidator implements ConstraintValidator<ExistProgramId, Long> {
	private String message;
	private ProgramService service;
	
	public ExistProgramIdValidator(ProgramService programService) {
		service=programService;
	}
	
	@Override
	public void initialize(ExistProgramId constraintAnnotation) {
		this.message=constraintAnnotation.message();
	}
	
	
	@Override
	public boolean isValid(Long programId, ConstraintValidatorContext context) {
		boolean isExist=service.isExist(programId);
		
		if(isExist)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}
