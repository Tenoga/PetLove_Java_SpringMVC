/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.ConectarDB;
import java.util.List;
import models.UsuarioBean;
import models.UsuarioBeanValidation;
import org.springframework.dao.DataAccessException;
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
public class userController {
     private UsuarioBeanValidation usuariovalidar;
    private JdbcTemplate jdbcTemplate;
    
    
    public userController() {
        this.usuariovalidar = new UsuarioBeanValidation();
        ConectarDB con = new ConectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
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
    ) {
        ModelAndView mav = new ModelAndView();
        this.usuariovalidar.validate(ub, result);
        if (result.hasErrors()) {
            mav.addObject("ub", new UsuarioBean());
            mav.setViewName("views/formUsuario");
        } else {
            mav.addObject("ub", ub);
            mav.setViewName("views/viewUsuario");
        }
        return mav;
    }

    //Trae la vista de listUsuario
//    @RequestMapping(value = "listUsuario.htm", method = RequestMethod.GET)
//    public ModelAndView listUsuario() {
//        UsuarioBean vuser = new UsuarioBean();
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("views/listUsuario");
//        mav.addObject("vuser", vuser);
//        return mav;
//    }

    // Trae la lista entera de la base de datos por medio del select *
    @RequestMapping(value = "listUsuario.htm")
    public ModelAndView listarCliente() {
        ModelAndView mav = new ModelAndView();
        String sql = "select * from usuario";
        List datos = jdbcTemplate.queryForList(sql);
        System.out.println("Lista: " + datos);
        mav.addObject("user", datos);
        mav.setViewName("views/listUsuario");
        return mav;
    }
}
