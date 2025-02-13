package teroria.ejemplo4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = List.of(
        new Vehiculo("1111AAA", Modelo.BMW, 10_000),
        new Vehiculo("2222BBB", Modelo.AUDI, 20_000),
        new Vehiculo("3333CCC", Modelo.OPEL, 30_000),
        new Vehiculo("4444DDD", Modelo.BMW, 100_000),
        new Vehiculo("5555EEE", Modelo.AUDI, 200_000),
        new Vehiculo("6666FFF", Modelo.OPEL, 300_000),
        new Vehiculo("7777GGG", Modelo.CITROEN, 0)
         );
        System.out.println("======= COCHES CON MENOS DE 100.000 KM ========");
        Helper.getCochesMenosKmQue(vehiculos, 100_000).forEach(System.out::println);
        System.out.println("======= COCHES SEGÚN MODELO ========");
        Helper.getCochesSegunModelo(vehiculos, Modelo.BMW).forEach(System.out::println);
        System.out.println("======= COCHES ORDENADOS POR KMs ========");
        Helper.getCochesOrdenadosKm(vehiculos).forEach(System.out::println);
        System.out.println("======= KMs DE TODOS LOS COCHES ========");
        System.out.printf("Km realizado: %d%n", Helper.getKmRealizadoTodosLosCoches(vehiculos));
        System.out.println("======= COCHES CON MENOS DE 100.000 KM Y OPEL ========");
        Helper.getCochePorMenosKmYModelo(vehiculos, Modelo.OPEL, 100_000).forEach(System.out::println);
        System.out.println("======= COCHES CON MAS Y MENOS KMs ========");
        System.out.println(Arrays.toString(Helper.getVehiculosMasYMenosKm(vehiculos)));
    }
}
