package ad.apiud6borja.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "puntuaciones")
public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_puntuacion;
    @Min(value = 0, message = "Como vas a poner puntuacion negativa manin? tienes manos?")
    private Long puntuacion;
    @NotBlank(message = "A ver mi pana, tendras que ponerle un jugador no?")
    private String jugador;
    @ManyToOne
    @JoinColumn(name = "id_juego")
    private Juego juego;

    public Puntuacion() {
    }

    public Puntuacion(Long puntuacion, String jugador, Juego juego) {
        this.puntuacion = puntuacion;
        this.jugador = jugador;
        this.juego = juego;
    }

    public Long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public void setId_puntuacion(Long idPuntuacion) {
        this.id_puntuacion = idPuntuacion;
    }

    public Long getId_puntuacion() {
        return id_puntuacion;
    }
}
