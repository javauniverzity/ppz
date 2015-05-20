package com.ppz.web.spring.validator;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public abstract class AbstractAjaxFieldValidator {
	
	Logger logger = Logger.getLogger("logwebfile");
	
	/**
	 * Get the validation message for an individual input field of a model
	 * object.
	 * 
	 * @param modelObject
	 *            The object to validate against.
	 * @param formInputId
	 *            The id attribute of the form input field.
	 * @param formInputValue
	 *            The input value to be validated.
	 * @return The validation message.
	 */
	public String getFieldInputValidationMessage(String locale, String formInputId, String formInputValue, String username) {

		String validationMessage = "";

		try {
			Object formBackingObject = getCommandObject();
			Errors errors = new BindException(formBackingObject, "command");

			formInputId = formInputId.split("\\.")[0];
			String capitalizedFormInputId = StringUtils.capitalize(formInputId);

			String validationMethodName = "validate" + capitalizedFormInputId;
			@SuppressWarnings("rawtypes")
			Class validationArgs[] = new Class[] { String.class, String.class, Errors.class, String.class};
			Method validationMethod = getClass().getMethod(validationMethodName, validationArgs);
			validationMethod.invoke(this, new Object[] { locale, formInputValue, errors, username });

			validationMessage = getValidationMessage(errors, formInputId);
		} catch (Exception e) {
			logger.error("AbstractAjaxFieldValidator: Exception", e);
		}

		return validationMessage;
	}

	/**
	 * Get the FieldError validation message from the underlying MessageSource
	 * for the given fieldName.
	 * 
	 * @param errors
	 *            The validation errors.
	 * @param fieldName
	 *            The fieldName to retrieve the error message from.
	 * @return The validation message or an empty String.
	 */
	protected String getValidationMessage(Errors errors, String fieldName) {
		String message = "";

		FieldError fieldError = errors.getFieldError(fieldName);

		if (fieldError != null) {
			message = fieldError.getDefaultMessage();
		}

		return message;
	}
	
	public abstract Object getCommandObject();
	
}
