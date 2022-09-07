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

import com.cbnegociosinmobiliarios.propiedades.model.CapacidadesModel;
import com.cbnegociosinmobiliarios.propiedades.service.CapacidadesService;

@RestController
@RequestMapping("/api/capacidades")
public class CapacidadesController {

    private final CapacidadesService capacidadesService;

    public CapacidadesController(CapacidadesService capacidadesService) {
        this.capacidadesService = capacidadesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CapacidadesModel>> obtenerCapacidades() {
        List<CapacidadesModel> capacidades = capacidadesService.buscarCapacidades();
        return new ResponseEntity<>(capacidades, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CapacidadesModel> agregarCapacidades(@RequestBody CapacidadesModel capacidades) {
        CapacidadesModel addCapacidades = capacidadesService.agregarCapacidades(capacidades);
        return new ResponseEntity<CapacidadesModel>(addCapacidades, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CapacidadesModel> editarCapacidades(@RequestBody CapacidadesModel capacidades) {
        CapacidadesModel updatedCapacidades = capacidadesService.editarCapacidades(capacidades);
        return new ResponseEntity<>(updatedCapacidades, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarCapacidades(@PathVariable("id") Long id) {
        capacidadesService.borrarCapacidades(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
