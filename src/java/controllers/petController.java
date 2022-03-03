/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Dao.ConectarDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.PetBean;
import models.PetBeanValidation;
import models.UsuarioBean;
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
// ==============Vista pet e insercion de datos en BD=============================

    @RequestMapping(value = "formPet.htm", method = RequestMethod.POST)
    public ModelAndView vistaPet(
            @ModelAttribute("pet") PetBean pb,
            BindingResult result,
            SessionStatus status
    ) {
        ModelAndView mav = new ModelAndView();
        this.petValidar.validate(pb, result);
        if (result.hasErrors()) {
            mav.addObject("pb", new PetBean());
            mav.setViewName("views/formPet");
            return mav;
        } else {
            String sql = "insert into pet(petTipo, petNombre, petNacimiento, petRaza, petColor) values(?,?,?,?,?)";
            jdbcTemplate.update(sql, pb.getPetTipo(), pb.getPetNombre(), pb.getPetNacimiento(), pb.getPetRaza(), pb.getPetColor());
            mav.setViewName("redirect:/listPet.htm");

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
    //======================Actualizar mascota==================//
    @RequestMapping(value = "updatePet.htm", method = RequestMethod.GET)
    public ModelAndView actualizarPet(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        PetBean ub = getPetById(id);
        mav.addObject("pet", ub);
        mav.setViewName("views/updatePet");
        return mav;
    }
    
    //===Convierte la lista de Result set  en una clase  Clientebean=====//

    public PetBean getPetById(int id) {
        PetBean ub = new PetBean();
        String sql = "select * from pet where id = " + id;
        return (PetBean) jdbcTemplate.query(
                sql, new ResultSetExtractor<PetBean>() {
                    @Override
                    public PetBean extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next()) {
                            ub.setId(rs.getInt("id"));
                            ub.setPetTipo(rs.getString("petTipo"));
                            ub.setPetNombre(rs.getString("petNombre"));
                            ub.setPetNacimiento(rs.getInt("petNacimiento"));
                            ub.setPetRaza(rs.getString("petRaza"));
                            ub.setPetColor(rs.getString("petColor"));
                        }
                        return ub;
                    }
                }
        );
    }
    
//     //=========metodo POST para enviar los datos a la base de atos======================//
//    //actCliente= Actualizar cliente
    @RequestMapping(value = "updatePet.htm", method = RequestMethod.POST)
    public ModelAndView actPet(PetBean ub) {
        ModelAndView mav = new ModelAndView();
        String sql = "update pet set petTipo = ?, petNombre = ?, petNacimiento = ?,"
                + "petRaza = ?, petColor = ? where id = " + ub.getId();
        jdbcTemplate.update(sql, ub.getPetTipo(), ub.getPetNombre(), ub.getPetNacimiento(), ub.getPetRaza(), ub.getPetColor());
        mav.setViewName("redirect:/listPet.htm");
        return mav;
    }

    
}
