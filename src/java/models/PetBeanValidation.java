
package models;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class PetBeanValidation implements Validator{

    @Override
    public boolean supports(Class<?> type) {
       return PetBean.class.isAssignableFrom(type);  
    }

    @Override
    public void validate(Object o, Errors errors) {
        PetBean pet = (PetBean) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"petTipo", "requiered.petTipo", "El campo Tipo es OBLIGATORIO");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"petNombre", "requiered.petNombre", "El campo Nombre es OBLIGATORIO");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"petNacimiento", "requiered.petNacimiento", "El campo Nacimiento es OBLIGATORIO");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"petRaza", "requiered.petRaza", "El campo Raza es OBLIGATORIO");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"petColor", "requiered.petColor", "El campo Color es OBLIGATORIO");
        
        
    
    }
    
    
}
