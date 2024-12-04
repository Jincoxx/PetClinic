package com.petclinic.web.controller;

import com.petclinic.domain.dto.MascotaDTO;
import com.petclinic.domain.service.MascotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    // Consultar todos los registros
    @Operation(summary = "Obtener todas las mascotas", description = "Retorna una lista de todas las mascotas registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de mascotas obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<MascotaDTO>> getAllMascotas() {
        Iterable<MascotaDTO> mascotas = mascotaService.findAll();
        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }

    // Consultar por ID
    @Operation(summary = "Obtener mascota por ID", description = "Retorna la mascota correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mascota encontrada"),
            @ApiResponse(responseCode = "404", description = "Mascota no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MascotaDTO> getMascotaById(@PathVariable Long id) {
        Optional<MascotaDTO> mascota = mascotaService.findById(id);
        return mascota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Guardar una nueva mascota
    @Operation(summary = "Guardar nueva mascota", description = "Guarda una nueva mascota en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mascota creada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear la mascota")
    })
    @PostMapping("/save")
    public ResponseEntity<MascotaDTO> createMascota(@RequestBody MascotaDTO mascotaDTO) {
        MascotaDTO savedMascota = mascotaService.save(mascotaDTO);
        return new ResponseEntity<>(savedMascota, HttpStatus.CREATED);
    }

    // Actualizar una mascota existente
    @Operation(summary = "Actualizar mascota", description = "Actualiza los datos de una mascota existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mascota actualizada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al actualizar la mascota"),
            @ApiResponse(responseCode = "404", description = "Mascota no encontrada")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<MascotaDTO> updateMascota(@PathVariable Long id, @RequestBody MascotaDTO mascotaDTO) {
        mascotaDTO.setId(id); // Asegurarse de que el ID es el correcto
        MascotaDTO updatedMascota = mascotaService.update(mascotaDTO);
        return ResponseEntity.ok(updatedMascota);
    }

    // Eliminar una mascota por ID
    @Operation(summary = "Eliminar mascota", description = "Elimina la mascota correspondiente al ID proporcionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mascota eliminada exitosamente"),
            @ApiResponse(responseCode = "404", description = "Mascota no encontrada")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMascota(@PathVariable Long id) {
        mascotaService.delete(id);
        return ResponseEntity.ok().build();
    }

    // Contar el número total de mascotas
    @Operation(summary = "Contar mascotas", description = "Retorna el número total de mascotas registradas")
    @ApiResponse(responseCode = "200", description = "Número total de mascotas")
    @GetMapping("/count")
    public ResponseEntity<Long> countMascotas() {
        long count = mascotaService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
