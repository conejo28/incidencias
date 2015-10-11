package unitec;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by campitos on 30/07/15.
 */
@RestController
@RequestMapping("/")
public class ControladorProfesor {
    @Inject
    ServicioProfesor servicioProfesor;

    @RequestMapping(value = "/profesor/{nombre}/{paterno}/{email}/{cuenta}", method = RequestMethod.GET, headers = {"Accept=text/html"})
    @ResponseBody
    String guardar(@PathVariable String nombre,@PathVariable String paterno, @PathVariable String email, @PathVariable Integer cuenta)
            throws Exception {
        String mensaje = "nada :'(";
Profesor profesor=new Profesor();
        Incidencia incidencia=new Incidencia();
        incidencia.setFecha(new DateTime());
        incidencia.setObservaciones("El profesor Campos sale tarde como de costumbre");
        incidencia.setPc("PC061");
        incidencia.setSala("T-205");
        incidencia.setTipo("Sala desordenada");
        profesor.setClave(cuenta);
        profesor.setEmail(email);
        profesor.setNombre(nombre);
        profesor.setIncidencia(incidencia);
        profesor.setPaterno(paterno);
        servicioProfesor.agregarProfesor(profesor);
        mensaje="Profesor guardado con exito";
        return mensaje;

    }}