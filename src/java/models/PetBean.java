/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.ejb.Stateless;

/**
 *
 * @author SENA
 */
@Stateless
public class PetBean {

    private int id;
    private String petTipo;
    private String petNombre;
    private int petNacimiento;
    private String petRaza;
    private String petColor;
    private String petFoto;

    public PetBean() {
    }

    public PetBean(int id, String petTipo, String petNombre, int petNacimiento, String petRaza, String petColor, String petFoto) {
        this.id = id;
        this.petTipo = petTipo;
        this.petNombre = petNombre;
        this.petNacimiento = petNacimiento;
        this.petRaza = petRaza;
        this.petColor = petColor;
        this.petFoto = petFoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetTipo() {
        return petTipo;
    }

    public void setPetTipo(String petTipo) {
        this.petTipo = petTipo;
    }

    public String getPetNombre() {
        return petNombre;
    }

    public void setPetNombre(String petNombre) {
        this.petNombre = petNombre;
    }

    public int getPetNacimiento() {
        return petNacimiento;
    }

    public void setPetNacimiento(int petNacimiento) {
        this.petNacimiento = petNacimiento;
    }

    public String getPetRaza() {
        return petRaza;
    }

    public void setPetRaza(String petRaza) {
        this.petRaza = petRaza;
    }

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    public String getPetFoto() {
        return petFoto;
    }

    public void setPetFoto(String petFoto) {
        this.petFoto = petFoto;
    }

}
