package com.developpez.validators;


import com.developpez.dao.DeveloppeurModel;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class PseudoValidator extends FieldValidatorSupport{


	public void validate(Object obj) throws ValidationException
	{
		System.out.println("dans la méthode validate de PseudoValidator.....");
		String champ = this.getFieldName();
		String valChamp = (String) this.getFieldValue(champ, obj);

		String regex = "^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])[a-zA-Z0-9]{6,24}$";
		
		if(!valChamp.matches(regex) || isExist(valChamp)){
			addFieldError(champ, obj);
		}

	}

	private boolean isExist(String pseudo)
	{   
		DeveloppeurModel  developpeurModel = new DeveloppeurModel();
		return developpeurModel.isDeveloppeurExist(pseudo);	
	}

}
