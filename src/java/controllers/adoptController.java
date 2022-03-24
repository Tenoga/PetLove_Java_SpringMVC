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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.AdoptBean;
import models.AdoptBeanValidation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
    public ModelAndView formAdopt(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        AdoptBean adopt = new AdoptBean();
        mav.addObject("adopt", adopt);
        List user = userDao.ConsultarUsuario() ;
        mav.addObject("user", user);
        List pet = petDao.getAvailablePet();
        int code = adoptDao.consultarIdAdopcion();
        String getPet_id = request.getParameter("id");
        mav.addObject("getPet_id", getPet_id);
        mav.addObject("code", code);
        mav.addObject("pet", pet);
        mav.setViewName("views/formAdopcion");
        return mav;
    }
    //======================Actualizar cliente==================//
    @RequestMapping(value = "updateAdopcion.htm", method = RequestMethod.GET)
    public ModelAndView actualizarAdopcion(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        AdoptBean ab = getAdoptById(id);
        mav.addObject("adopt", ab);
        mav.setViewName("views/updateAdopcion");
        return mav;
    }
    
    
    //===Convierte la lista de Result set  en una clase  Clientebean=====//
    public AdoptBean getAdoptById(int id) {
        AdoptBean ab = new AdoptBean();
        String sql = "select * from adopt where adopt_id = " + id;
        return (AdoptBean) jdbcTemplate.query(
                sql, new ResultSetExtractor<AdoptBean>() {
                    @Override
                    public AdoptBean extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next()) {
                            ab.setAdopt_id(rs.getInt("adopt_id"));
                            ab.setUser_id(rs.getInt("user_id"));
                            ab.setPet_id(rs.getInt("pet_id"));
                            ab.setAdopt_date(rs.getString("adopt_date"));
                        }
                        return ab;
                    }
                }
        );
    }   
    //===================Insertar Adopcion============================//
    @RequestMapping(value = "formAdopcion.htm", method = RequestMethod.POST)
    public ModelAndView postAdoptForm(
            @ModelAttribute("adopt") AdoptBean ab,
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
//          
//            String sql2 = "";
            System.out.println("Pruebaaaaa"  + ab.getUser_id() + ab.getPet_id() + ab.getAdopt_date());
            jdbcTemplate.update(sql, ab.getUser_id(), ab.getPet_id(), ab.getAdopt_date());
            
            mav.setViewName("redirect:/listAdopcion.htm");
        }
        return mav;
    }
    
        //===================Borrar Adopcion============================//
    
     @RequestMapping(value = "deleteadoption.htm", method = RequestMethod.GET)
    public ModelAndView deleteAdoption(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        this.adoptDao.deleteAdoption(id);
        mav.setViewName("redirect:/listadoptions.htm");
        return mav;
    }
}
