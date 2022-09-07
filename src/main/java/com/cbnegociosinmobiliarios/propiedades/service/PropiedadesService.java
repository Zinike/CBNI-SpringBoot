package com.cbnegociosinmobiliarios.propiedades.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbnegociosinmobiliarios.propiedades.exceptions.PropiedadNotFoundException;
import com.cbnegociosinmobiliarios.propiedades.model.PropiedadesModel;
import com.cbnegociosinmobiliarios.propiedades.repository.PropiedadesRepository;

@Service
@Transactional
public class PropiedadesService {
    
    private final PropiedadesRepository PropiedadesRepository;

    @Autowired
    public PropiedadesService(PropiedadesRepository PropiedadesRepository) {
        this.PropiedadesRepository = PropiedadesRepository;
    }

    public PropiedadesModel agregarPropiedades(PropiedadesModel PropiedadesModel){
        return PropiedadesRepository.save(PropiedadesModel);
    }

    public List<PropiedadesModel> buscarPropiedades(){
        return PropiedadesRepository.findAll();
    }

    public PropiedadesModel buscarPropiedadesPorId(Long id){
        return PropiedadesRepository.findById(id).orElseThrow(() ->new PropiedadNotFoundException("Propiedades no encontrada"));
    }
    
    public PropiedadesModel editarPropiedades(PropiedadesModel PropiedadesModel){
        return PropiedadesRepository.save(PropiedadesModel);
    }

    public void borrarPropiedades(Long id){
        PropiedadesRepository.deleteById(id);
    }




    
}
