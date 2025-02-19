package ejercicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Fultbolista> fultbolistas = List.of(
                new Fultbolista("Aguilar Carmona, Fco", LocalDate.of(2000,2,28), Puesto.PORTERO, "12345678a"),
                new Fultbolista("Aguilar Aguilar, Luis", LocalDate.of(1999,2,2), Puesto.DEFENSA, "12345678b"),
                new Fultbolista("Carmona Carmona, Mario", LocalDate.of(2005,12,28), Puesto.DEFENSA, "12345678c"),
                new Fultbolista("Burgos Aguilar, Pepe", LocalDate.of(1994,8,2), Puesto.DEFENSA, "12345678d"),
                new Fultbolista("Pérez Carmona, David", LocalDate.of(2006,11,8), Puesto.DEFENSA, "12345678e"),
                new Fultbolista("Rodríguez Castro, Sergio", LocalDate.of(2001,1,18), Puesto.CENTROCAMPISTA, "12345678f"),
                new Fultbolista("Rodríguez Carmona, Darío", LocalDate.of(2002,10,1), Puesto.CENTROCAMPISTA, "12345678g"),
                new Fultbolista("Martínez Castro, Victor", LocalDate.of(2005,10,18), Puesto.CENTROCAMPISTA, "12345678h"),
                new Fultbolista("Castro Castro, Carlos", LocalDate.of(2004,7,8), Puesto.CENTROCAMPISTA, "12345678i"),
                new Fultbolista("Merino Molina, Manuel", LocalDate.of(1998,10,1), Puesto.DELANTERO, "12345678j"),
                new Fultbolista("Villar López, Enrique", LocalDate.of(1997,4,4), Puesto.DELANTERO, "12345678jk")
        );
        EquipoFutbol equipoFutbol = new EquipoFutbol("IES Virgen del Carmen");
        for (Fultbolista fultbolista :fultbolistas)
            equipoFutbol.addFutbolista(fultbolista);
        //listamos el nombre de los futbolistas
        equipoFutbol.getNombreJugadoresAlfabeticamente().forEach(System.out::println);
        //eliminamos el jugador  con dni: 12345678b, es el primero ordenado alfabeticamente
        equipoFutbol.darBajaFutbolista("12345678b");
        System.out.println("=======Eliminado un jugador==========");
        equipoFutbol.getNombreJugadoresAlfabeticamente().forEach(System.out::println);
        //intentamos eliminar otra vez el jugador y comprobamos si lo hace
        boolean elimacionJugador = equipoFutbol.darBajaFutbolista("12345678B");
        String mensaje = elimacionJugador ? "Eliminado jugador" : "NO eliminado jugador";
        System.out.printf("¿Eliminado jugador: %s%n", mensaje);
        //lo hacemos ahora con uno que existe
        elimacionJugador = equipoFutbol.darBajaFutbolista("12345678a");
        mensaje = elimacionJugador ? "Eliminado jugador" : "NO eliminado jugador";
        System.out.printf("¿Eliminado jugador: %s%n", mensaje);
        equipoFutbol.getNombreJugadoresAlfabeticamente().forEach(System.out::println);
        //obtenemos los delanteros Y porteros
        System.out.println("===============DELANTEROS=================");
        equipoFutbol.getFultbolistasPorPuesto(Puesto.DELANTERO).forEach(System.out::println);
        System.out.println("===============PORTEROS=================");
        equipoFutbol.getFultbolistasPorPuesto(Puesto.PORTERO).forEach(System.out::println);
        //no hay, lo hemos dado de baja
        System.out.println("=============SUB 21================");
        equipoFutbol.getFultbolistasSub21().forEach(System.out::println);
        //obtenemos el nombre del jugador de mayor edad, cuidado que si la lista está vacía
        //devuelve null
        Fultbolista fultbolistaMayor = equipoFutbol.getFutbolistaMayorEdad();
        if (fultbolistaMayor != null)
            System.out.printf("El mayor de los jugadores es: %S con una edad de %d%n",
                    fultbolistaMayor.getNombreFutbolista(), fultbolistaMayor.calcularEdad());
        //el de menor edad, que es un Optional
        Optional<Fultbolista> fultbolistaMenor = equipoFutbol.getFutbolistaMenorEdad();
        if (fultbolistaMenor.isPresent())
            System.out.printf("El menor de los jugadores es: %S con una edad de %d%n",
                    fultbolistaMenor.get().getNombreFutbolista(),
                    fultbolistaMenor.get().calcularEdad());
        //calculamos la edad media de los jugadores, si no hay juagadores devuelve 0
        double edadMedia = equipoFutbol.getEdadMediaFutbolistas();
        System.out.printf("La edad media de los jugadores es %.2f%n", edadMedia);
    }
}








