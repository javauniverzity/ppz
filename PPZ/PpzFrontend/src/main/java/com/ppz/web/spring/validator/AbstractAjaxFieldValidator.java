package com.ppz.web.spring.validator;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

/**
 * Abstraktni trida kontrolor poli
 * @author David
 *
 */
public abstract class AbstractAjaxFieldValidator {
	
	Logger logger = Logger.getLogger("logwebfile");
	
	/**
	 * Dej potvrzovaci zpravu pro jednotlivy vklad do pole modelu objektu.
	 * 
	 * @param modelObject
	 *            Nastaveni kontrolniho objektu.
	 * @param formInputId
	 *            Id atributu vstupniho pole formulare.
	 * @param formInputValue
	 *            Vstupni hodnota je zkontrolovana.
	 * @return Kontrolni zpravu.
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
	 * Dej kontrolni zpravu FieldError od MessageSource pro ziskani fieldName.
	 * 
	 * @param errors
	 *            Chyby kontroly.
	 * @param fieldName
	 *            fieldName pro nacteni chybove hlasky.
	 * @return Kontrolni zpravu nebo prazdny retezec.
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
