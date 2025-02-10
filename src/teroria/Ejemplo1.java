package teroria;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejemplo1 {
    public static void main(String[] args) {
        List<String> nombres = List.of("manuel", "isabel", "gabriel", "ismael");
        //usando un bucle
        for (String nombre: nombres)
            System.out.println(nombre);
        System.out.println("========");
        //usando lambdas
        nombres.forEach(nombre -> System.out.println(nombre.toUpperCase()));
        System.out.println("========");
        //usando interfaces funciaonales
        nombres.forEach(System.out::println);

        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            numeros.add(new Random().nextInt(100));
        }
        numeros.stream().
                filter(numero -> numero % 2 == 0).
                filter(numero -> numero >= 50).
                sorted().
                forEach(System.out::println);


        List<Integer> paresMayoresDe50 = numeros.stream().
                filter(numero -> numero % 2 == 0).
                filter(numero -> numero >= 50).
                sorted().
                distinct().
                toList();

        System.out.println("================");
        System.out.println(paresMayoresDe50);

    }
}
