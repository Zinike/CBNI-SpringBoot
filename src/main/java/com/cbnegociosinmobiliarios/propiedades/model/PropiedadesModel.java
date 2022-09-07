package com.cbnegociosinmobiliarios.propiedades.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PropiedadesModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false)
    private Long id;
    private String titulo;
    private String imagen;
    private String urlgit;
    private String urlpagina;


    PropiedadesModel(){}


    public PropiedadesModel(Long id, String titulo, String imagen, String urlgit, String urlpagina) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.urlgit = urlgit;
        this.urlpagina = urlpagina;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getImagen() {
        return imagen;
    }


    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public String getUrlgit() {
        return urlgit;
    }


    public void setUrlgit(String urlgit) {
        this.urlgit = urlgit;
    }


    public String getUrlpagina() {
        return urlpagina;
    }


    public void setUrlpagina(String urlpagina) {
        this.urlpagina = urlpagina;
    }

    
}