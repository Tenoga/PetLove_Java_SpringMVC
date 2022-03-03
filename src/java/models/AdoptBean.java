/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import javax.ejb.Stateless;

/**
 *
 * @author Pipe
 */
@Stateless
public class AdoptBean {
    
    private int adopt_id;
    private int user_id;
    private int pet_id;
    private String adopt_date;

    public AdoptBean() {
    }

    public AdoptBean(int adopt_id, int user_id, int pet_id, String adopt_date) {
        this.adopt_id = adopt_id;
        this.user_id = user_id;
        this.pet_id = pet_id;
        this.adopt_date = adopt_date;
    }

    public int getAdopt_id() {
        return adopt_id;
    }

    public void setAdopt_id(int adopt_id) {
        this.adopt_id = adopt_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }

    public String getAdopt_date() {
        return adopt_date;
    }

    public void setAdopt_date(String adopt_date) {
        this.adopt_date = adopt_date;
    }
}
