/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.File;
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
        List usuario;
        this.jdbcTemplate = new JdbcTemplate(con.conDB());
        String sql = "select * from usuario";
        usuario = this.jdbcTemplate.queryForList(sql);
        return usuario;
    }
    
    //====================Borrado de imagen========================//
    public void deleteImg(String foto, String deletePath, int id){
        final String DELETE_DIRECTORY = "..\\..\\web\\";
        this.jdbcTemplate = new JdbcTemplate(con.conDB());
        //Ubicación del archivo en el servidor
        String deleteFile = deletePath + DELETE_DIRECTORY + foto;
        File borrar = new File (deleteFile);
        if(borrar.delete()){
            String sql = "delete from usuario where id = ?";
            jdbcTemplate.update(sql, id);
        }else{
            System.out.println("No se pudo eliminar la imagen");
        }
    }
}
