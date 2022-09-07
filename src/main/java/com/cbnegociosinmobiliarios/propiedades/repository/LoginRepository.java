package com.cbnegociosinmobiliarios.propiedades.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbnegociosinmobiliarios.propiedades.model.LoginModel;

public interface LoginRepository extends JpaRepository<LoginModel, Integer> {
    Optional<LoginModel> findByEmail(String email);
}
