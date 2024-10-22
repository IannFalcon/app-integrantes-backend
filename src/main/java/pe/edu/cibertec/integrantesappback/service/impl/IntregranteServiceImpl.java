package pe.edu.cibertec.integrantesappback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.integrantesappback.entity.Integrante;
import pe.edu.cibertec.integrantesappback.service.IntegranteService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IntregranteServiceImpl implements IntegranteService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public List<Integrante> listarIntegrantes() {

        List<Integrante> listaIntegrantes = new ArrayList<>();
        Resource resource = resourceLoader.getResource("classpath:datosIntegrantes.txt");

        try (BufferedReader br = new BufferedReader((new FileReader(resource.getFile())))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                String codigo = datos[0];
                String nombre = datos[2];
                String apellido = datos[3];

                listaIntegrantes.add(new Integrante(codigo, nombre, apellido));

            }

        } catch (IOException e) {

            listaIntegrantes = null;
            throw new RuntimeException(e);

        }

        return listaIntegrantes;

    }

}
