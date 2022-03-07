/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author SENA
 */
public class AdoptBeanValidation implements Validator{
    @Override
    public boolean supports(Class<?> type){
        return AdoptBean.class.isAssignableFrom(type);
    }
    
    @Override
    public void validate (Object o, Errors errors){
        AdoptBean adopcion = (AdoptBean) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user_id",  "required.user_id", "El campo Usuario_ID es OBLIGATORIO");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pet_id", "required.pet_id", "El campo Mascota_ID es OBLIGATORIO");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adopt_date", "required.adopt_date", "El campo FechaAdopcion es OBLIGATORIO");
    }
}