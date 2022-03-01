/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.ConectarDB;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.PetBean;
import models.PetBeanValidation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pipe
 */
@Controller
public class petController {
    
    private PetBeanValidation petValidar;
    private JdbcTemplate jdbcTemplate;

    public petController() {
        this.petValidar = new PetBeanValidation();
        

        ConectarDB con = new ConectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
    }
    
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
    
     // Trae la lista entera de la base de datos por medio del select *
    @RequestMapping(value = "listPet.htm")
    public ModelAndView listarPet() {
        ModelAndView mav = new ModelAndView();
        String sql = "select * from pet";
        List datos = jdbcTemplate.queryForList(sql);
        System.out.println("Lista: " + datos);
        mav.addObject("pet", datos);
        mav.setViewName("views/listPet");
        return mav;
    }
    
    //===================Borrar usuario============================//
    @RequestMapping(value = "deletePet.htm")
    public ModelAndView borrarPet(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from pet where id = ?";
        jdbcTemplate.update(sql, id);
        mav.setViewName("redirect:/listPet.htm");
        return mav;
    }
}
