package cybersoft.java12.gira.role.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.java12.gira.role.validation.validator.ExistProgramIdValidator;

@Constraint(validatedBy =ExistProgramIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface ExistProgramId {
	public String message() default "Program Id is not exist";
	
	
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
}
