package di.blackjackborjaapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "puntuaciones")
public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 0, message = "Como vas a guardar un 0 manin? juega anda.")
    private Long puntuacion;
    @NotBlank(message = "A ver mi pana, tendras que ponerte un nombre no?")
    private String nombre;

    public Puntuacion() {
    }

    public Puntuacion(Long puntuacion, String jugador) {
        this.puntuacion = puntuacion;
        this.nombre = jugador;
    }

    public Long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String jugador) {
        this.nombre = jugador;
    }

    public void setId(Long idPuntuacion) {
        this.id = idPuntuacion;
    }

    public Long getId() {
        return id;
    }
}
