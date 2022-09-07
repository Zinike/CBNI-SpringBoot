package com.cbnegociosinmobiliarios.propiedades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbnegociosinmobiliarios.propiedades.model.PortafolioModel;

@Repository
public interface PortafolioRepository extends JpaRepository<PortafolioModel,Long>{
    
}
