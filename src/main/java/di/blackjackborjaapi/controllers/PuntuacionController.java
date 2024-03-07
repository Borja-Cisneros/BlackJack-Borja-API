package di.blackjackborjaapi.controllers;

import di.blackjackborjaapi.models.Puntuacion;
import di.blackjackborjaapi.repositories.PuntuacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/puntuacion")
public class PuntuacionController {
    @Autowired
    private PuntuacionRepository puntuacionRepository;

    // Todos los puntuacions
    @GetMapping
    private List<Puntuacion> obtenerPuntuacions() {
        return puntuacionRepository.findAll();
    }
    @GetMapping("/ordenadas")
    private List<Puntuacion> obtenerPuntuacionsOrdenadas() {
        return puntuacionRepository.findAllByOrderByPuntuacionDesc();
    }

    //Alta puntuacion
    @PostMapping("/engadir")
    public Puntuacion crearPuntuacion(@RequestBody Puntuacion puntuacion) {
        return puntuacionRepository.save(puntuacion);
    }

    //Borrar Puntuacion
    @DeleteMapping("/{id}")
    public void eliminarPuntuacion(@PathVariable Long id) {
        puntuacionRepository.deleteById(id);
    }
}
