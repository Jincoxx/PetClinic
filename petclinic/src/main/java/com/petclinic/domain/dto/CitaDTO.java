package com.petclinic.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CitaDTO {

    private Integer id;
    private Integer mascotaId;
    private Integer veterinarioId;
    private LocalDateTime fechaHora;
    private String motivo;

    // Constructor
    public CitaDTO(Integer id, Integer mascotaId, Integer veterinarioId, LocalDateTime fechaHora, String motivo) {
        this.id = id;
        this.mascotaId = mascotaId;
        this.veterinarioId = veterinarioId;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }
}
