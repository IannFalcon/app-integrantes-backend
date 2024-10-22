package pe.edu.cibertec.integrantesappback.dto;

import pe.edu.cibertec.integrantesappback.entity.Integrante;

import java.util.List;

public record ListadoIntegrantesResponseDTO(String codigo, String mensaje, List<Integrante> integrantes) {
}
