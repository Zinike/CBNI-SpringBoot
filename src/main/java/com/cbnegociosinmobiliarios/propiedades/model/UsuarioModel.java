package com.cbnegociosinmobiliarios.propiedades.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsuarioModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false)
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private String fotoperfil;

    UsuarioModel(){}
    
    public UsuarioModel(Long id, String nombre, String email, String password, String fotoperfil) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fotoperfil = fotoperfil;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getFotoperfil() {
        return fotoperfil;
    }


    public void setFotoperfil(String fotoperfil) {
        this.fotoperfil = fotoperfil;
    }   

}
