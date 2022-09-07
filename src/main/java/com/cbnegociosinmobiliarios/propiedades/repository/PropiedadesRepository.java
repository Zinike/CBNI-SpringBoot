package com.cbnegociosinmobiliarios.propiedades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbnegociosinmobiliarios.propiedades.model.PropiedadesModel;

@Repository
public interface PropiedadesRepository extends JpaRepository<PropiedadesModel,Long>{
    
}
