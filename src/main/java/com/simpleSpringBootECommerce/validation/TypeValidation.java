package com.simpleSpringBootECommerce.validation;

import com.simpleSpringBootECommerce.model.Product;
import com.simpleSpringBootECommerce.model.Type;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TypeValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Type.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "field.required");
	}

}
