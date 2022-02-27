/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpServletRequest;
import models.PetBean;
import models.PetBeanValidation;
import models.UsuarioBean;
import models.UsuarioBeanValidation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homeController {

    private PetBeanValidation petValidar;
    private UsuarioBeanValidation usuariovalidar;

    public homeController() {
        this.petValidar = new PetBeanValidation();
        this.usuariovalidar = new UsuarioBeanValidation();
    }

    @RequestMapping(value = "formUsuario.htm", method = RequestMethod.GET)
    public ModelAndView usuario() {
        UsuarioBean usuario = new UsuarioBean();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/formUsuario");
        mav.addObject("usuario", usuario);
        return mav;
    }
         @RequestMapping(value = "formUsuario.htm", method = RequestMethod.POST)
    public ModelAndView valpostUserForm(
            @ModelAttribute("usuario") UsuarioBean ub, 
            BindingResult result,
            SessionStatus status
            ){
        ModelAndView mav = new ModelAndView();
        this.usuariovalidar.validate(ub, result);
        if(result.hasErrors()){
            mav.addObject("ub", new UsuarioBean());
            mav.setViewName("views/formUsuario");
        }else{
            mav.addObject("ub", ub);
            mav.setViewName("views/viewUsuario");
        }
        return mav;
    }

//    @RequestMapping(value = "formUsuario.htm", method = RequestMethod.POST)
//    public ModelAndView viewusuario(@ModelAttribute("usuario") UsuarioBean user,
//            BindingResult result,
//            SessionStatus status
//    ) {
//        this.usuariovalidar.validate(user, result);
//        if (result.hasErrors()) {
//            ModelAndView mov = new ModelAndView();
//            mov.addObject("usuario", new UsuarioBean());
//            mov.setViewName("views/formUsuario");
//            return mov;
//        } else {
//            ModelAndView mav = new ModelAndView();
//            mav.setViewName("views/viewUsuario");
//            mav.addObject("nombre", user.getNombre());
//            mav.addObject("correo", user.getCorreo());
//            mav.addObject("edad", user.getEdad());
//            mav.addObject("telefono", user.getTelefono());
//            return mav;
//
//        }
//    }

    @RequestMapping(value = "formPet.htm", method = RequestMethod.GET)
    public ModelAndView pet() {
        PetBean pet = new PetBean();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/formPet");
        mav.addObject("pet", pet);
        return mav;
    }

    @RequestMapping(value = "formPet.htm", method = RequestMethod.POST)
    public ModelAndView vistaPet(@ModelAttribute("pet") PetBean mas,
            BindingResult result,
            SessionStatus status
    ) {
        this.petValidar.validate(mas, result);
        if (result.hasErrors()) {
            ModelAndView mov = new ModelAndView();
            mov.addObject("pet", new PetBean());
            mov.setViewName("views/formPet");
            return mov;
        } else {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("views/viewPet");
            mav.addObject("petTipo", mas.getPetTipo());
            mav.addObject("petNombre", mas.getPetNombre());
            mav.addObject("petNacimiento", mas.getPetNacimiento());
            mav.addObject("petRaza", mas.getPetRaza());
            mav.addObject("petColor", mas.getPetColor());

            return mav;
        }
    }

}
