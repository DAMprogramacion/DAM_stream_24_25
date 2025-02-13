package teroria.ejemplo4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Helper {
    //metodo: obtener una lista coches según kilómetros (menos km que)
    public static List<Vehiculo> getCochesMenosKmQue (List<Vehiculo> vehiculos, int km) {
        /*List<Vehiculo> vehiculosMenosKm = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos)
            if (vehiculo.kilometros() < km)
                vehiculosMenosKm.add(vehiculo);
        return vehiculosMenosKm;*/
        return  vehiculos.stream().
                filter(vehiculo -> vehiculo.kilometros() < km).
                toList();
    }
    //metodo: idem pero según modelo
    public static List<Vehiculo> getCochesSegunModelo (List<Vehiculo> vehiculos, Modelo modelo) {
       return  vehiculos.stream().
                filter(vehiculo -> vehiculo.modelo().equals(modelo)).
                toList();
    }
    //metodo: obtener una lista de coches ordenados por km
    public static List<Vehiculo> getCochesOrdenadosKm (List<Vehiculo> vehiculos) {
        return vehiculos.stream().
                sorted(Comparator.comparing( Vehiculo::kilometros)).  //el criterio de ordenanción
                toList();
    }
    //metodo: obtener todos los km realizados por todos los coches
    public static int getKmRealizadoTodosLosCoches(List<Vehiculo> vehiculos) {
        return vehiculos.stream().
                mapToInt(Vehiculo::kilometros).
                sum();
    }
    //metodo: obtener lista coches por modelo y segun km (menos km que)
    public static List<Vehiculo> getCochePorMenosKmYModelo (
            List<Vehiculo> vehiculos, Modelo modelo, int km) {
        return vehiculos.stream().
                filter(vehiculo -> vehiculo.modelo().equals(modelo)).
                filter(vehiculo -> vehiculo.kilometros() < km).
                toList();
    }
    //metodo: devolver el coche con el maximo de kilometros ó minimo
    //devuelve Vehiculo[] el vehiculo[0] el de menos kilómetros y
    //vehiculo[1] el de mas km
    public static Vehiculo[] getVehiculosMasYMenosKm(List<Vehiculo> vehiculos) {
        Vehiculo[] vehiculosMasYMenosKm = new Vehiculo[2];
        Optional<Vehiculo> vehiculoMenosKm =
                Optional.of(vehiculos.stream().
                        min(((v1, v2) -> Integer.compare(v1.kilometros(), v2.kilometros()))).
                        get());
        Optional<Vehiculo> vehiculoMasKm =
                Optional.of(vehiculos.stream().
                        max(((v1, v2) -> Integer.compare(v1.kilometros(), v2.kilometros()))).
                        get());
        if (vehiculoMenosKm.isPresent())
            vehiculosMasYMenosKm[0] = vehiculoMenosKm.get();
        if (vehiculoMasKm.isPresent())
            vehiculosMasYMenosKm[1] = vehiculoMasKm.get();
        return vehiculosMasYMenosKm;
    }
}






