/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.UsuarioBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

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
    public void deleteImg(String foto, String deletePath, int id) {
        final String DELETE_DIRECTORY = "..\\..\\web\\";
        this.jdbcTemplate = new JdbcTemplate(con.conDB());
        //Ubicación del archivo en el servidor
        String deleteFile = deletePath + DELETE_DIRECTORY + foto;
        File borrar = new File(deleteFile);
        if (borrar.delete()) {
            String sql = "delete from usuario where id = ?";
            jdbcTemplate.update(sql, id);
        } else {
            System.out.println("No se pudo eliminar la imagen");
        }
    }
    

    //=========Metodo POST para enviar los datos a la base de datos / UPDATE / ======================//
    private static final String UPLOAD_DIRECTORY = "..\\..\\web\\public\\img\\users";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; //3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; //40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; //50MB

    @RequestMapping(value = "updateCliente.htm", method = RequestMethod.POST)
    public ModelAndView actClienteConImg(
            UsuarioBean ub,
            HttpServletRequest request, 
            List<FileItem> items
    ) {
        ModelAndView mav = new ModelAndView();

        //Determina si el atributo de carga esta configurado en el formulario
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        //Variable tipo list para poder recorrer el vector 
        ArrayList<String> userlist = new ArrayList<>();
        if (isMultipart) {       
            //Instancia del archivo fileItem
            DiskFileItemFactory file = new DiskFileItemFactory();
            //Establece el valor maximo de carga de archivos
            file.setSizeThreshold(MEMORY_THRESHOLD);
            //Establece el valor maximo de solicitud
            file.setRepository(new File(System.getProperty("java.io.tmpdir")));
            //Transferencia del fileitem como parametro a la variable
            ServletFileUpload fileUpload = new ServletFileUpload(file);
            //Para establecer el valor maximo de carga de archivos
            fileUpload.setFileSizeMax(MAX_FILE_SIZE);
            //Para establecer el valor maximo de solicitud (incluidos los datos y formulario)
            fileUpload.setSizeMax(MAX_REQUEST_SIZE);
            //Construye una ruta temporal para almacenar archivos cargados
            String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
            //Ruta relativa al archivo actual de la imagen borrada
            String deletePath = request.getServletContext().getRealPath("") + File.separator;
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            
            for (FileItem fileItem: items) {
                //Aca se recorre todo el formulario
                System.out.println("Entro al for de los items");
                //Condicional para saber que variable es el archivo
                if (!fileItem.isFormField()) {
                    String fileName = new File(fileItem.getName()).getName();
                    String filePath = uploadPath + File.separator + userlist.get(0) + fileName;
                    File uploadFile = new File(filePath);
                    //Para obtener el nombre del archivo
                    String nameFile = ("public/img/users/" + userlist.get(0) + fileName);
                    System.out.println(nameFile);
                    try {
                        deleteImgAct(ub.getFotoOld(), deletePath);
                        //Almacena la secuencia de archivo en disco (directorio tomcat)
                        fileItem.write(uploadFile);
                        ub.setFoto(nameFile);
                        ub.setFotoOld(nameFile);
                    } catch (Exception e) {
                        System.out.print("Se ha escrito: " + uploadFile);
                    }
                } else {
                    userlist.add(fileItem.getString());
                }
            }
            ub.setNombre(userlist.get(0));
            ub.setCorreo(userlist.get(1));
            ub.setEdad(userlist.get(2));
            ub.setTelefono(userlist.get(3));
        }

        String sql = "update usuario set nombre = ?, correo = ?, edad = ?,"
                + "telefono = ?, foto = ? where id = " + ub.getId();
        jdbcTemplate.update(sql, ub.getNombre(), ub.getCorreo(), ub.getEdad(), ub.getTelefono(), ub.getFoto());
        mav.setViewName("redirect:/listUsuario.htm");
        return mav;
    }
        //====================Borrado de imagen Actualizada========================//
    public void deleteImgAct(String foto, String deletePath) {
        final String DELETE_DIRECTORY = "..\\..\\web\\";
        this.jdbcTemplate = new JdbcTemplate(con.conDB());
        //Ubicación del archivo en el servidor
        String deleteFile = deletePath + DELETE_DIRECTORY + foto;
        File borrar = new File(deleteFile);
        if (borrar.delete()) {
            System.out.println("La imagen se ha eliminado");
        } else {
            System.out.println("No se pudo eliminar la imagen ACT");
        }
    }


    public void actUsuarioSinImg(UsuarioBean ub, ArrayList<String> userlist){
        this.jdbcTemplate = new JdbcTemplate(con.conDB());
        
        ub.setNombre(userlist.get(0));
        ub.setCorreo(userlist.get(1));
        ub.setEdad(userlist.get(2));
        ub.setTelefono(userlist.get(3));
        
        //=======Sentancia SQL=========//
        String sql = "update usuario set nombre = ?, correo = ?, edad = ?, Telefono = ? where id = ?";
        jdbcTemplate.update(sql, ub.getNombre(), ub.getCorreo(), ub.getEdad(), ub.getTelefono(), ub.getId());
    }
}
