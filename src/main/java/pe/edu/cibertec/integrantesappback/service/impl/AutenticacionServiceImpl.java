package pe.edu.cibertec.integrantesappback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.integrantesappback.dto.LoginRequestDTO;
import pe.edu.cibertec.integrantesappback.service.AutenticacionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] iniciarSesion(LoginRequestDTO loginRequestDTO) throws IOException {

        String[] datosIntegrante = null;
        Resource resource = resourceLoader.getResource("classpath:datosIntegrantes.txt");

        try(BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                if (loginRequestDTO.codigoAlumno().equals(datos[0]) &&
                    loginRequestDTO.password().equals(datos[1])) {

                    datosIntegrante = new String[2];
                    datosIntegrante[0] = datos[2];
                    datosIntegrante[1] = datos[3];
                    break;

                }

            }

        } catch (IOException e) {
            datosIntegrante = null;
            throw new IOException(e);
        }

        return datosIntegrante;
    }

}
