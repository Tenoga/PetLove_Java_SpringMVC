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
public class UsuarioBeanValidation implements Validator{
    @Override
    public boolean supports(Class<?> type){
        return UsuarioBean.class.isAssignableFrom(type);
    }
    
    @Override
    public void validate (Object o, Errors errors){
        UsuarioBean usuario = (UsuarioBean) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",  "required.nombre", "El campo nombre es OBLIGATORIO");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo", "required.correo", "El campo correo es OBLIGATORIO");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "edad", "required.edad", "El campo edad es OBLIGATORIO");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required.telefono", "El campo telefono es OBLIGATORIO");
    }
}
