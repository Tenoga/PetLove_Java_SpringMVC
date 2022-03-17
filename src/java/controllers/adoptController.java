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
import javax.servlet.http.HttpServletRequest;
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
    private final AdoptBeanDao adoptDao;
    private final UsuarioDao userDao;
    private final PetDao petDao;
    
    
    public adoptController() {
        this.adoptvalidar = new AdoptBeanValidation();
        ConectarDB con = new ConectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
        adoptDao = new AdoptBeanDao();
        userDao = new UsuarioDao();
        petDao = new PetDao();
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
        mav.addObject("adopt", adopt);
        List user = userDao.ConsultarUsuario() ;
        System.out.println("Lista usuario yonoseque"+ user);
        mav.addObject("user", user);
        List pet = petDao.consultarPet();
        System.out.println("Lista usuario yonoseque"+ pet);
        int code = adoptDao.consultarIdAdopcion();
        mav.addObject("code", code);
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
    
        //===================Borrar Adopcion============================//
    @RequestMapping(value = "deleteAdopcion.htm")
    public ModelAndView borrarUsuario(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from adopt where id = ?";
        jdbcTemplate.update(sql, id);
        mav.setViewName("redirect:/listAdopcion.htm");
        return mav;
    }
}
