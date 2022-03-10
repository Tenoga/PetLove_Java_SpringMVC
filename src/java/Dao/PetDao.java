/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author SENA
 */
public class PetDao {
    JdbcTemplate jdbcTemplate;
    ConectarDB con = new ConectarDB();
    
    //-------------------Mostrar Listado de Mascotas-----------------//
    public List consultarPet(){
        List datos;
        this.jdbcTemplate = new JdbcTemplate(con.conDB());
        String sql = "select * from pet";
        datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }
}
