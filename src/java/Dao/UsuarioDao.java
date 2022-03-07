/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author SENA
 */
public class UsuarioDao {

    JdbcTemplate jdbcTemplate;
    ConectarDB con = new ConectarDB();

    //-------------------Mostrar Listado de Usuarios-----------------//
    public List ConsultarUsuario() {
        List usuario = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(con.conDB());
        String sql = "select * from usuario";
        usuario = this.jdbcTemplate.queryForList(sql);
        return usuario;
    }
}
