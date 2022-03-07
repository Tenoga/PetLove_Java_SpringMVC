/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Dao.AdoptBeanDao;
import Dao.ConectarDB;
import Dao.PetDao;
import Dao.UsuarioDao;
import java.util.List;
import models.AdoptBean;
import models.AdoptBeanValidation;
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
 * @author SENA
 */
@Controller
public class adoptController {

    private final AdoptBeanValidation adoptvalidar;
    private final JdbcTemplate jdbcTemplate;

    public adoptController() {
        this.adoptvalidar = new AdoptBeanValidation();
        ConectarDB con = new ConectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
    }
    //===================Trae la Lista Adopcion============================//
    @RequestMapping(value = "listAdopcion.htm", method = RequestMethod.GET)
    public ModelAndView listAdopt() {
        ModelAndView mav = new ModelAndView();
        AdoptBean adopt = new AdoptBean();
        AdoptBeanDao adoptDao = new AdoptBeanDao();
        List datos = adoptDao.ConsultarAdopcion();
        mav.addObject("adopt", datos);
        mav.setViewName("views/listAdopcion");
        return mav;
    }
    //===================Trae el formulario Adopcion============================//
    @RequestMapping(value = "formAdopcion.htm", method = RequestMethod.GET)
    public ModelAndView formAdopt() {
        ModelAndView mav = new ModelAndView();
        AdoptBean adopt = new AdoptBean();
        AdoptBeanDao adoptDao = new AdoptBeanDao();
        UsuarioDao userDao = new UsuarioDao();
        PetDao petDao = new PetDao();
        int datos = adoptDao.consultarIdAdopcion();
        mav.addObject("adopt", datos);
        List user = userDao.ConsultarUsuario() ;
        mav.addObject("user", user);
        List pet = petDao.consultarAdoptPet();
        mav.addObject("pet", pet);
        mav.setViewName("views/formAdopcion");
        return mav;
    }
        //===================Insertar Adopcion============================//
    @RequestMapping(value = "formAdopcion.htm", method = RequestMethod.POST)
    public ModelAndView postAdoptForm(
            @ModelAttribute("adopcion") AdoptBean ab,
            BindingResult result,
            SessionStatus status
    ) {
        ModelAndView mav = new ModelAndView();
        this.adoptvalidar.validate(ab, result);
        if (result.hasErrors()) {
            mav.addObject("ab", new AdoptBean());
            mav.setViewName("views/formAdopcion");
        } else {
            String sql = "insert into adopt(user_id, pet_id, adopt_date) values(?,?,?)";
            jdbcTemplate.update(sql, ab.getUser_id(), ab.getPet_id(), ab.getAdopt_date());
            mav.setViewName("redirect:/listAdopcion.htm");
        }
        return mav;
    }
}
