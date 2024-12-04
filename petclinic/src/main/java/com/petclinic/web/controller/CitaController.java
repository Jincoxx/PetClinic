package com.petclinic.web.controller;

import com.petclinic.domain.dto.CitaDTO;
import com.petclinic.domain.service.CitaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Operation(summary = "Obtener todas las citas", description = "Retorna una lista de todas las citas registradas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de citas obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<CitaDTO>> getAllCitas() {
        return new ResponseEntity<>(citaService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener cita por ID", description = "Retorna la cita correspondiente al ID proporcionado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cita encontrada"),
            @ApiResponse(responseCode = "404", description = "Cita no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> getCitaById(@PathVariable Integer id) {
        Optional<CitaDTO> cita = citaService.findById(id);
        return cita.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Guardar nueva cita", description = "Guarda una nueva cita en el sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cita creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear la cita")
    })
    @PostMapping("/save")
    public ResponseEntity<CitaDTO> createCita(@RequestBody CitaDTO citaDTO) {
        return new ResponseEntity<>(citaService.save(citaDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar cita", description = "Actualiza los datos de una cita existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cita actualizada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Cita no encontrada")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<CitaDTO> updateCita(@PathVariable Integer id, @RequestBody CitaDTO citaDTO) {
        citaDTO.setId(id);
        return ResponseEntity.ok(citaService.update(citaDTO));
    }

    @Operation(summary = "Eliminar cita", description = "Elimina la cita correspondiente al ID proporcionado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cita eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Cita no encontrada")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCita(@PathVariable Integer id) {
        citaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
