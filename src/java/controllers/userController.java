/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Dao.ConectarDB;
import Dao.UsuarioDao;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.UsuarioBean;
import models.UsuarioBeanValidation;
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
 * @author SENA
 */
@Controller
public class userController {

    private final UsuarioBeanValidation usuariovalidar;
    private final JdbcTemplate jdbcTemplate;
    private final UsuarioDao uDao;

    public userController() {
        this.usuariovalidar = new UsuarioBeanValidation();
        ConectarDB con = new ConectarDB();
        jdbcTemplate = new JdbcTemplate(con.conDB());
        this.uDao = new UsuarioDao();
    }

    @RequestMapping(value = "formUsuario.htm", method = RequestMethod.GET)
    public ModelAndView usuario() {
        UsuarioBean usuario = new UsuarioBean();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/formUsuario");
        mav.addObject("usuario", usuario);
        return mav;
    }
     //===============POST FORMULARIO=================//
    private static final String UPLOAD_DIRECTORY = "..\\..\\web\\public\\img\\users";
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; //3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; //40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; //50MB

    @RequestMapping(value = "formUsuario.htm", method = RequestMethod.POST)
    public ModelAndView valpostUserForm(
            @ModelAttribute("usuario") UsuarioBean ub,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {
        ModelAndView mav = new ModelAndView();

        //=====================Validacion==================================//
//        this.usuariovalidar.validate(ub, result);
//        if (result.hasErrors()) {
//            mav.addObject("ub", new UsuarioBean());
//            mav.setViewName("views/formUsuario");
//        } else {
//            
        //======================================================================================================//

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
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
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
                    String fileName = new File(fileItem.getName()).getName();
                    String filePath = uploadPath + File.separator + userlist.get(0) + fileName;
                    File uploadFile = new File(filePath);
                    //Para obtener el nombre del archivo
                    String nameFile = ("public/img/users/" + userlist.get(0) + fileName);
                    try {
                        //Almacena la secuencia de archivo en disco (directorio tomcat)
                        fileItem.write(uploadFile);
                        ub.setFoto(nameFile);
                    } catch (Exception e) {
                        System.out.print("Se ha escrito: " + uploadFile);
                    }
                }else {
                    userlist.add(fileItem.getString());
                }
            }
            ub.setNombre(userlist.get(0));
            ub.setCorreo(userlist.get(1));
            ub.setEdad(userlist.get(2));
            ub.setTelefono(userlist.get(3));
        }
        String sql = "insert into usuario(nombre, correo, edad, telefono, foto) values(?,?,?,?,?)";
        jdbcTemplate.update(sql, ub.getNombre(), ub.getCorreo(), ub.getEdad(), ub.getTelefono(), ub.getFoto());
        mav.setViewName("redirect:/listUsuario.htm");
//        }
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
        UsuarioDao userDao = new UsuarioDao();
        int id = Integer.parseInt(req.getParameter("id"));
        //Captura la direccion del archivo
        String deletePath = req.getServletContext().getRealPath("") + File.separator;
        String foto = req.getParameter("foto");
        //Metodo que borra el cliente y la imagen
        userDao.deleteImg(foto, deletePath, id);
        mav.setViewName("redirect:/listUsuario.htm");
        return mav;
    }

//======================Actualizar cliente==================//
    @RequestMapping(value = "updateCliente.htm", method = RequestMethod.GET)
    public ModelAndView actualizarCliente(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(req.getParameter("id"));
        String fotoOld = req.getParameter("fotoOld");
        UsuarioBean ub = getUserById(id);
        ub.setFotoOld(fotoOld);
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
                            ub.setFoto(rs.getString("foto"));
                        }
                        return ub;
                    }
                }
        );
    }    
    //===============POST FORMULARIO UPDATE=================//
    @RequestMapping(value = "updateCliente.htm", method = RequestMethod.POST)
    public ModelAndView actCliente(
            UsuarioBean ub,
            HttpServletRequest request
    ) {
        ModelAndView mav = new ModelAndView();
        //Variable tipo list para poder recorrer el vector 
        ArrayList<String> userlist = new ArrayList<>();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        //Instancia del archivo fileItem
        DiskFileItemFactory file = new DiskFileItemFactory();
        //Transferencia del fileitem como parametro a la variable
        ServletFileUpload fileUpload = new ServletFileUpload(file);
        List<FileItem> items = null;
        try {
            items = fileUpload.parseRequest(request);
            System.out.println(items.size());
            for (int i = 0; i < items.size(); i++) {
                //Aca se recorre todo el formulario
                FileItem fileItem = (FileItem) items.get(i);
                userlist.add(fileItem.getString());
            }
        } catch (FileUploadException ex) {
            System.out.print("Error al cargar la imagen UPDATE_CLIENTE");
        }
        if (userlist.get(4).isEmpty() || userlist.get(4).equals("") || userlist.get(4) == null) {
            uDao.actUsuarioSinImg(ub, userlist);
        } else {
            uDao.actClienteConImg(ub, request, items);
        }
        mav.setViewName("redirect:/listUsuario.htm");
        return mav;
    }
}
