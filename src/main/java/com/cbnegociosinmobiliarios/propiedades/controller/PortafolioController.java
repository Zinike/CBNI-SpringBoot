package com.cbnegociosinmobiliarios.propiedades.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbnegociosinmobiliarios.propiedades.model.PortafolioModel;
import com.cbnegociosinmobiliarios.propiedades.service.PortafolioService;

@RestController
@RequestMapping("/api/portafolio")
public class PortafolioController {
    

    private final PortafolioService portafolioService;

    public PortafolioController(PortafolioService portafolioService) {
        this.portafolioService = portafolioService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PortafolioModel>> obtenerPortafolio() {
        List<PortafolioModel> portafolio = portafolioService.buscarPortafolio();
        return new ResponseEntity<>(portafolio, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PortafolioModel> agregarPortafolio(@RequestBody PortafolioModel portafolio) {
        PortafolioModel addPortafolio = portafolioService.agregarPortafolio(portafolio);
        return new ResponseEntity<PortafolioModel>(addPortafolio, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PortafolioModel> editarPortafolio(@RequestBody PortafolioModel portafolio) {
        PortafolioModel updatedPortafolio = portafolioService.editarPortafolio(portafolio);
        return new ResponseEntity<>(updatedPortafolio, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarPortafolio(@PathVariable("id") Long id) {
        portafolioService.borrarPortafolio(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
