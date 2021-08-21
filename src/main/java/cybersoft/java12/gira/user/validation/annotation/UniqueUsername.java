package cybersoft.java12.gira.user.validation.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.java12.gira.user.validation.validator.UniqueUsernameValidator;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Retention(RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueUsername {
	String message() default " User name has been used";
	
	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
}
