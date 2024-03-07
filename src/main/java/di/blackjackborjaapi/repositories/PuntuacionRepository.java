package ad.apiud6borja.repositories;

import ad.apiud6borja.models.Juego;
import ad.apiud6borja.models.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuntuacionRepository extends JpaRepository<Puntuacion,Long> {
    List<Puntuacion> findByJuegoIdOrderByPuntuacionDesc(Long juegoId);
}
