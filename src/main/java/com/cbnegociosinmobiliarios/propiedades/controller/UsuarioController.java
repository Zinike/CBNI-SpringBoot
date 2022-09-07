package com.cbnegociosinmobiliarios.propiedades.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbnegociosinmobiliarios.propiedades.model.UsuarioModel;
import com.cbnegociosinmobiliarios.propiedades.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioModel> obtenerUsuario(@PathVariable("id") Long id) {
        UsuarioModel usuario = usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UsuarioModel> editarUsuario(@RequestBody UsuarioModel usuario){
        UsuarioModel updatedUsuario=usuarioService.editarUsuario(usuario);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }

}
