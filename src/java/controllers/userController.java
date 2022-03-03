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
import models.UsuarioBean;
import models.UsuarioBeanValidation;
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
public class userController {

    private final UsuarioBeanValidation usuariovalidar;
    private final JdbcTemplate jdbcTemplate;

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
    ) 
    
    {
        ModelAndView mav = new ModelAndView();
        this.usuariovalidar.validate(ub, result);
        if (result.hasErrors()) {
            mav.addObject("ub", new UsuarioBean());
            mav.setViewName("views/formUsuario");
        } else {
            String sql = "insert into usuario(nombre, correo, edad, telefono) values(?,?,?,?)";
            jdbcTemplate.update(sql, ub.getNombre(), ub.getCorreo(), ub.getEdad(), ub.getTelefono());
            mav.setViewName("redirect:/listUsuario.htm");
        }
        return mav;
    }
    
    //======Trae la lista entera de la base de datos por medio del select *======//
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
    
    //===================Borrar usuario============================//
    @RequestMapping(value = "deleteUsuario.htm")
    public ModelAndView borrarUsuario(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from usuario where id = ?";
        jdbcTemplate.update(sql, id);
        mav.setViewName("redirect:/listUsuario.htm");
        return mav;
    }
    
//======================Actualizar cliente==================//
    @RequestMapping(value = "updateCliente.htm", method = RequestMethod.GET)
    public ModelAndView actualizarCliente(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        UsuarioBean ub = getUserById(id);
        mav.addObject("usuario", ub);
        mav.setViewName("views/updateCliente");
        return mav;
    }
    
    //===Convierte la lista de Result set  en una clase  Clientebean=====//

    public UsuarioBean getUserById(int id) {
        UsuarioBean ub = new UsuarioBean();
        String sql = "select * from usuario where id = " + id;
        return (UsuarioBean) jdbcTemplate.query(
                sql, new ResultSetExtractor<UsuarioBean>() {
                    @Override
                    public UsuarioBean extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next()) {
                            ub.setId(rs.getInt("id"));
                            ub.setNombre(rs.getString("nombre"));
                            ub.setCorreo(rs.getString("correo"));
                            ub.setEdad(rs.getString("edad"));
                            ub.setTelefono(rs.getString("telefono"));
                        }
                        return ub;
                    }
                }
        );
    }
    
//     //=========metodo POST para enviar los datos a la base de atos======================//
//    //actCliente= Actualizar cliente
    @RequestMapping(value = "updateCliente.htm", method = RequestMethod.POST)
    public ModelAndView actCliente(UsuarioBean ub) {
        ModelAndView mav = new ModelAndView();
        String sql = "update usuario set nombre = ?, correo = ?, edad = ?,"
                + "telefono = ? where id = " + ub.getId();
        jdbcTemplate.update(sql, ub.getNombre(), ub.getCorreo(), ub.getEdad(), ub.getTelefono());
        mav.setViewName("redirect:/listUsuario.htm");
        return mav;
    }

}
