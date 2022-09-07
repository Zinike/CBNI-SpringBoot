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

import com.cbnegociosinmobiliarios.propiedades.model.PropiedadesModel;
import com.cbnegociosinmobiliarios.propiedades.service.PropiedadesService;

@RestController
@RequestMapping("/api/Propiedades")
public class PropiedadesController {
    

    private final PropiedadesService PropiedadesService;

    public PropiedadesController(PropiedadesService PropiedadesService) {
        this.PropiedadesService = PropiedadesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PropiedadesModel>> obtenerPropiedades() {
        List<PropiedadesModel> Propiedades = PropiedadesService.buscarPropiedades();
        return new ResponseEntity<>(Propiedades, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PropiedadesModel> agregarPropiedades(@RequestBody PropiedadesModel Propiedades) {
        PropiedadesModel addPropiedades = PropiedadesService.agregarPropiedades(Propiedades);
        return new ResponseEntity<PropiedadesModel>(addPropiedades, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PropiedadesModel> editarPropiedades(@RequestBody PropiedadesModel Propiedades) {
        PropiedadesModel updatedPropiedades = PropiedadesService.editarPropiedades(Propiedades);
        return new ResponseEntity<>(updatedPropiedades, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarPropiedades(@PathVariable("id") Long id) {
        PropiedadesService.borrarPropiedades(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
