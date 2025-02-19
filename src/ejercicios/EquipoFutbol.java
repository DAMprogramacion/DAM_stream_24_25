package ejercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
                map(Fultbolista::getNombreFutbolista). //esto es un Stream<String>
                sorted(). //se ordenan String
                collect(Collectors.toUnmodifiableList());
    }
    public List<Fultbolista> getFultbolistasSub21 () {
        return fultbolistas.stream().
                filter(fultbolista -> fultbolista.calcularEdad() <= 21).
                sorted(Comparator.comparing(Fultbolista::getNombreFutbolista)). //ordena por nombre (String)
                collect(Collectors.toUnmodifiableList());
    }
    public List<Fultbolista> getFultbolistasPorPuesto (Puesto puesto) {
        return fultbolistas.stream().
                filter(fultbolista -> fultbolista.getPuesto().equals(puesto)).
                collect(Collectors.toUnmodifiableList());
    }
    public double getEdadMediaFutbolistas () {
        return fultbolistas.stream().
                mapToInt(Fultbolista::calcularEdad).   //Stream<Integer>
                average().orElse(0);  //si no hay jugadores, devuelve 0, se puede hacer con OptionalDouble
    }
    public Fultbolista getFutbolistaMayorEdad () {
        return fultbolistas.stream().
                max(Comparator.comparing(Fultbolista::calcularEdad)).orElse(null); //nos permite NO trabajar con OptionalDouble,
                                                                                        //usando un valor por defecto en el caso de que la lista esté vacía
    }
    //en este metodo en vez de devolver Futbolista, devuelve Optional, otra forma de hacerlo
    public Optional<Fultbolista> getFutbolistaMenorEdad() {
        return fultbolistas.stream().
                min(Comparator.comparing(Fultbolista::calcularEdad));
    }


}






