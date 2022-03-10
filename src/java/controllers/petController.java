/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Dao.ConectarDB;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.PetBean;
import models.PetBeanValidation;
import models.UsuarioBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
            SessionStatus status,
            HttpServletRequest request
    ) {
        ModelAndView mav = new ModelAndView();
//        this.petValidar.validate(pb, result);
//        if (result.hasErrors()) {
//            mav.addObject("pb", new PetBean());
//            mav.setViewName("views/formPet");
//            return mav;
//        } else {

        //Obtener la ruta de lectura del archivo
        String uploadFilePath = request.getSession().getServletContext().getRealPath("../../web/public/img/pets");
        //Determina si el atributo de carga esta configurado en el formulario
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        //Variable tipo list para poder recorrer el vector 
        ArrayList<String> petlist = new ArrayList<>();
        if (isMultipart) {
            //Creación del archivo file item
            FileItemFactory file = new DiskFileItemFactory();
            //Transferencia del fileitem como parametro a la variable
            ServletFileUpload fileUpload = new ServletFileUpload(file);
            //Lista para pasar los valores del formulario
            List<FileItem> items = null;
            try {
                items = fileUpload.parseRequest(request);
            } catch (FileUploadException ex) {
                System.out.print("Carga esto..." + ex.getMessage());
            }
            for (int i = 0; i < items.size(); i++) {
                //Aca se recorre todo el formulario
                FileItem fileItem = (FileItem) items.get(i);
                //Condicional para saber que variable es el archivo
                if (!fileItem.isFormField()) {
                    //Para obtener el nombre del archivo
                    File f = new File("public/img/pets/" + fileItem.getName());
                    //Esta es la secuencia del archivo
                    String nameFile = ("public/img/pets/" + f.getName());
                    System.out.print("Se ha cargado el archivo: " + uploadFilePath);
                    File uploadFile = new File(uploadFilePath, f.getName());
                    System.out.print("Se ha creado el archivo: " + uploadFile);

                    try {
                        //Almacena la secuencia de archivo en disco (directorio tomcat)
                        fileItem.write(uploadFile);
                    } catch (Exception e) {
                        System.out.print("Se ha escrito: " + uploadFile);
                    }
                    pb.setPetFoto(nameFile);
                } else {
                    petlist.add(fileItem.getString());
                }
            }
            pb.setPetTipo(petlist.get(0));
            pb.setPetNombre(petlist.get(1));
            pb.setPetNacimiento (Integer.parseInt(petlist.get(2)));
            pb.setPetRaza(petlist.get(3));
            pb.setPetColor(petlist.get(4));
        }
        String sql = "insert into pet(petTipo, petNombre, petNacimiento, petRaza, petColor, petFoto) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, pb.getPetTipo(), pb.getPetNombre(), pb.getPetNacimiento(), pb.getPetRaza(), pb.getPetColor(), pb.getPetFoto());
        mav.setViewName("redirect:/listPet.htm");

        return mav;
//        }
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
