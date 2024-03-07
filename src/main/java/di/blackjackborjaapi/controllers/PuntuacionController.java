package ad.apiud6borja.controlers;

import ad.apiud6borja.models.Puntuacion;
import ad.apiud6borja.repositories.JuegoRepository;
import ad.apiud6borja.repositories.PuntuacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/puntuacion")
public class PuntuacionController {
    @Autowired
    private PuntuacionRepository puntuacionRepository;
    @Autowired
    private JuegoRepository juegoRepository;

    // Todos los puntuacions
    @GetMapping
    private List<Puntuacion> obtenerPuntuacions() {
        return puntuacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Puntuacion obtenerPuntuacionID(@PathVariable Long id) {
        return puntuacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Puntuacion no encontrado"));
    }

    @GetMapping("/juego/{idJuego}")
    public List<Puntuacion> getPuntuacionesPorJuego(@PathVariable Long idJuego) {
        return puntuacionRepository.findByJuegoIdOrderByPuntuacionDesc(idJuego);
    }

    //Alta puntuacion
    @PostMapping("/{id}")
    public Puntuacion crearPuntuacion(@PathVariable Long id, @RequestBody Puntuacion puntuacion) {
        Puntuacion rec = juegoRepository.findById(id).map(
                juego -> {
                    puntuacion.setJuego(juego);
                    return puntuacionRepository.save(puntuacion);
                }
        ).orElseThrow(() -> new RuntimeException("Categoria no encontrada manin"));
        return rec;
    }

    // Actualizar puntuacion

    @PutMapping("/{id}")
    public Puntuacion actualizarCategoria(@PathVariable Long id, @RequestBody Puntuacion puntuacion) {
        return puntuacionRepository.findById(id).map(puntuacionTmp -> {
            puntuacionTmp.setPuntuacion(puntuacion.getPuntuacion());
            puntuacionTmp.setJugador(puntuacion.getJugador());
            return puntuacionRepository.save(puntuacionTmp);
        }).orElseThrow(() -> new RuntimeException("Puntuacion no encontrada al actualizar, mano"));
    }

    // Borar recurwso
    @DeleteMapping("/{id}")
    public void eliminarPuntuacion(@PathVariable Long id) {
        puntuacionRepository.deleteById(id);
    }
}
