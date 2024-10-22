package pe.edu.cibertec.integrantesappback.service;

import pe.edu.cibertec.integrantesappback.dto.LoginRequestDTO;

import java.io.IOException;

public interface AutenticacionService {

    String[] iniciarSesion(LoginRequestDTO loginRequestDTO) throws IOException;

}
