package com.petclinic.web.controller;

import com.petclinic.domain.dto.VeterinarioDTO;
import com.petclinic.domain.service.VeterinarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @Operation(summary = "Obtener todos los veterinarios", description = "Retorna una lista de todos los veterinarios registrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de veterinarios obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<Iterable<VeterinarioDTO>> getAllVeterinarios() {
        return new ResponseEntity<>(veterinarioService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener veterinario por ID", description = "Retorna el veterinario correspondiente al ID proporcionado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Veterinario encontrado"),
            @ApiResponse(responseCode = "404", description = "Veterinario no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioDTO> getVeterinarioById(@PathVariable Integer id) {
        Optional<VeterinarioDTO> veterinario = veterinarioService.findById(id);
        return veterinario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Guardar nuevo veterinario", description = "Guarda un nuevo veterinario en el sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Veterinario creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear el veterinario")
    })
    @PostMapping("/save")
    public ResponseEntity<VeterinarioDTO> createVeterinario(@RequestBody VeterinarioDTO veterinarioDTO) {
        return new ResponseEntity<>(veterinarioService.save(veterinarioDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar veterinario", description = "Actualiza los datos de un veterinario existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Veterinario actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Veterinario no encontrado")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<VeterinarioDTO> updateVeterinario(@PathVariable Integer id, @RequestBody VeterinarioDTO veterinarioDTO) {
        veterinarioDTO.setId(id);
        return ResponseEntity.ok(veterinarioService.update(veterinarioDTO));
    }

    @Operation(summary = "Eliminar veterinario", description = "Elimina el veterinario correspondiente al ID proporcionado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Veterinario eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Veterinario no encontrado")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVeterinario(@PathVariable Integer id) {
        veterinarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
