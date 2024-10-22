package pe.edu.cibertec.integrantesappback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.integrantesappback.dto.LoginRequestDTO;
import pe.edu.cibertec.integrantesappback.dto.LoginResponseDTO;
import pe.edu.cibertec.integrantesappback.service.AutenticacionService;

import java.io.IOException;
import java.time.Duration;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/iniciar-sesion")
    public LoginResponseDTO iniciarSesion(@RequestBody LoginRequestDTO loginRequestDTO){

        try {

            Thread.sleep(Duration.ofSeconds(5));
            String[] datosUsuario = autenticacionService.iniciarSesion((loginRequestDTO));

            if(datosUsuario == null){
                return new LoginResponseDTO("01", "Error: usuario no encontrado.", "", "");
            }

            return new LoginResponseDTO("00", "", datosUsuario[0], datosUsuario[1]);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
            return new LoginResponseDTO("99", "Error: Ocurrió un problema", "", "");

        }

    }

}
