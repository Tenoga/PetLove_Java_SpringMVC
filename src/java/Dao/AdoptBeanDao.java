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
public class AdoptBeanDao {

    JdbcTemplate jdbcTemplate;
    ConectarDB con = new ConectarDB();

    public List ConsultarAdopcion() {
        List adopt = new ArrayList();
        this.jdbcTemplate = new JdbcTemplate(con.conDB());
        String sql = "select adopt_id, adopt.adopt_date, usuario.nombre, pet.petNombre from usuario, pet, adopt where pet.id= adopt.pet_id and usuario.id= adopt.user_id;";
        adopt = this.jdbcTemplate.queryForList(sql);
        return adopt;
    }

    public int consultarIdAdopcion() {
        int adopt_id = 1;
        this.jdbcTemplate = new JdbcTemplate(con.conDB());
        String sql = "select max(adopt_id)+1 as adopt_id from adopt";
        adopt_id = this.jdbcTemplate.queryForObject(sql, Integer.class);
        return adopt_id;
    }
    
    
}
