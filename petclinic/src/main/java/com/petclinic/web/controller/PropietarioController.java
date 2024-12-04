package com.petclinic.web.controller;

import com.petclinic.domain.dto.PropietarioDTO;
import com.petclinic.domain.service.PropietarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/propietarios")
@CrossOrigin(origins = "http://localhost:4200") // Permitir solicitudes solo desde localhost:4200
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    // Consultar todos los registros
    @Operation(summary = "Obtener todos los propietarios", description = "Consulta todos los propietarios registrados")
    @ApiResponse(responseCode = "200", description = "Propietarios encontrados")
    @GetMapping("/all")
    public Iterable<PropietarioDTO> getAll() {
        return propietarioService.findAll();
    }

    // Consultar por ID
    @Operation(summary = "Obtener un propietario por ID", description = "Consulta un propietario específico por su ID")
    @ApiResponse(responseCode = "200", description = "Propietario encontrado")
    @ApiResponse(responseCode = "404", description = "Propietario no encontrado")
    @GetMapping("/{id}")
    public PropietarioDTO getById(@PathVariable Long id) {
        return propietarioService.findById(id);
    }

    // Guardar un nuevo propietario
    @Operation(summary = "Crear un nuevo propietario", description = "Crea un nuevo propietario")
    @ApiResponse(responseCode = "201", description = "Propietario creado")
    @PostMapping("/save")
    public PropietarioDTO create(@RequestBody PropietarioDTO propietarioDTO) {
        return propietarioService.save(propietarioDTO);
    }

    // Actualizar un propietario existente
    @Operation(summary = "Actualizar un propietario", description = "Actualiza un propietario existente")
    @ApiResponse(responseCode = "200", description = "Propietario actualizado")
    @ApiResponse(responseCode = "404", description = "Propietario no encontrado")
    @PutMapping("/update/{id}")
    public PropietarioDTO update(@PathVariable Long id, @RequestBody PropietarioDTO propietarioDTO) {
        propietarioDTO.setId(id);
        return propietarioService.update(propietarioDTO);
    }

    // Eliminar un propietario por ID
    @Operation(summary = "Eliminar un propietario", description = "Elimina un propietario existente por ID")
    @ApiResponse(responseCode = "200", description = "Propietario eliminado")
    @ApiResponse(responseCode = "404", description = "Propietario no encontrado")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        propietarioService.delete(id);
    }

    // Contar el número total de propietarios
    @Operation(summary = "Contar propietario", description = "Retorna el número total de propietarios registrados")
    @ApiResponse(responseCode = "200", description = "Número total de propietarios")
    @GetMapping("/count")
    public ResponseEntity<Long> countPropietarios() {
        long count = propietarioService.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
