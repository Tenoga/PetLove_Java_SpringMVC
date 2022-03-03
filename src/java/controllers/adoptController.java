/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import Dao.AdoptBeanDao;
import java.util.List;
import models.AdoptBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SENA
 */
public class adoptController {
    
    @RequestMapping(value="formAdopcion.htm", method = RequestMethod.GET)
    public ModelAndView formAdopt(){
        ModelAndView mav = new ModelAndView();
        AdoptBean adopt = new AdoptBean();
        AdoptBeanDao adoptDao = new AdoptBeanDao();
        List datos = adoptDao.ConsultarAdopcion();
        mav.addObject("adopt", datos);
        mav.setViewName("views/formAdopcion");
        return mav;
    }
    
    @RequestMapping(value="formAdopcion.htm", method = RequestMethod.GET)
    public ModelAndView agregarAdopcion(){
        ModelAndView mav = new ModelAndView();
        AdoptBean adopt = new AdoptBean();
        mav.addObject("adopt", "");
        mav.setViewName("views/formAdopcion");
        return mav;
    }
}
