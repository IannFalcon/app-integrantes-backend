package pe.edu.cibertec.integrantesappback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.integrantesappback.dto.ListadoIntegrantesResponseDTO;
import pe.edu.cibertec.integrantesappback.entity.Integrante;
import pe.edu.cibertec.integrantesappback.service.IntegranteService;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/integrante")
public class IntegranteController {

    @Autowired
    IntegranteService integranteService;

    @GetMapping("/listar")
    public ListadoIntegrantesResponseDTO listarIntegrantes(){

        try {

            Thread.sleep(Duration.ofSeconds(5));
            List<Integrante> integrantes = integranteService.listarIntegrantes();

            if(integrantes == null){

                return new ListadoIntegrantesResponseDTO("01", "Error: no se encontraron integrantes.", null);

            }

            return new ListadoIntegrantesResponseDTO("00", "", integrantes);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            return new ListadoIntegrantesResponseDTO("99", "Error: Ocurrió un problema", null);

        }

    }

}
