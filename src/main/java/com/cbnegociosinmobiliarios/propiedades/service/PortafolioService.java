package com.cbnegociosinmobiliarios.propiedades.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbnegociosinmobiliarios.propiedades.exceptions.PortafolioNotFoundException;
import com.cbnegociosinmobiliarios.propiedades.model.PortafolioModel;
import com.cbnegociosinmobiliarios.propiedades.repository.PortafolioRepository;

@Service
@Transactional
public class PortafolioService {
    
    private final PortafolioRepository portafolioRepository;

    @Autowired
    public PortafolioService(PortafolioRepository portafolioRepository) {
        this.portafolioRepository = portafolioRepository;
    }

    public PortafolioModel agregarPortafolio(PortafolioModel portafolioModel){
        return portafolioRepository.save(portafolioModel);
    }

    public List<PortafolioModel> buscarPortafolio(){
        return portafolioRepository.findAll();
    }

    public PortafolioModel buscarPortafolioPorId(Long id){
        return portafolioRepository.findById(id).orElseThrow(() ->new PortafolioNotFoundException("Portafolio no encontrada"));
    }
    
    public PortafolioModel editarPortafolio(PortafolioModel portafolioModel){
        return portafolioRepository.save(portafolioModel);
    }

    public void borrarPortafolio(Long id){
        portafolioRepository.deleteById(id);
    }




    
}
