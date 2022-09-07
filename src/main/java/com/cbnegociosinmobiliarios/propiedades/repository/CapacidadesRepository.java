package com.cbnegociosinmobiliarios.propiedades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbnegociosinmobiliarios.propiedades.model.CapacidadesModel;

@Repository
public interface CapacidadesRepository extends JpaRepository<CapacidadesModel,Long> {
    
}
