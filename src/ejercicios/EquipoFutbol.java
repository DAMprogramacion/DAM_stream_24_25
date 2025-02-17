package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EquipoFutbol {
    private final String nombreEquipoFutbol;
    private final List<Fultbolista> fultbolistas = new ArrayList<>();

    public EquipoFutbol(String nombreEquipoFutbol) {
        this.nombreEquipoFutbol = nombreEquipoFutbol;
    }
    public void addFutbolista (Fultbolista fultbolista) {
        fultbolistas.add(fultbolista);
    }
    public boolean darBajaFutbolista(String dni) {
        for (Fultbolista fultbolista : fultbolistas) {
            if (fultbolista.getDni().equalsIgnoreCase(dni)) {
                fultbolistas.remove(fultbolista);
                return true;
            }
        }
        return false;
    }
    public boolean actualizarPuestoJugador (Fultbolista jugador, Puesto newPuesto) {
        for (Fultbolista fultbolista : fultbolistas) {
            if (fultbolista.getDni().equalsIgnoreCase(jugador.getDni())) {
                fultbolista.setPuesto(newPuesto);
                return true;
            }
        }
        return false;
    }
    public List<String> getNombreJugadoresAlfabeticamente () {
        return fultbolistas.stream().
                map(Fultbolista::getNombreFutbolista).
                sorted().
                collect(Collectors.toUnmodifiableList());

    }

}





