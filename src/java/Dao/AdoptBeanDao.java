/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.AdoptBean;
import org.springframework.dao.DataAccessException;
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

    public AdoptBean getAdoptionById(int id) {
        AdoptBean ab = new AdoptBean();
        String sql = "select * from adopt where id = " + id;
        return (AdoptBean) this.jdbcTemplate.query(
                sql, (ResultSet rs) -> {
                    if (rs.next()) {
                        ab.setAdopt_id(rs.getInt("id"));
                        ab.setAdopt_date(rs.getString("date"));
                        ab.setUser_id(Integer.parseInt(rs.getString("user_id")));
                        ab.setPet_id(Integer.parseInt(rs.getString("pet_id")));
                    }
                    return ab;
        });
    }
     public void deleteAdoption(int id) {
        try {
            AdoptBean adoption = this.getAdoptionById(id);
            
            String sqlAdopt = "delete from `adopt` where `adopt`.`id` = ?";
            this.jdbcTemplate.update(sqlAdopt, id);
            
            //Setting as available the old pet
            //String sql2 = "update `pets` set `is_adopted` = '0' WHERE `pets`.`id` = (?);";
            //this.jdbcTemplate.update(sql2, adoption.getPet_id());
            
            
        } catch (DataAccessException e) {
            System.err.print(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.print(e.getMessage());
        }
    }
    
}
