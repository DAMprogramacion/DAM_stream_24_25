package teroria;

import java.util.*;

public class Ejemplo3 {
    public static void main(String[] args) {
        Random random = new Random();
       // random.ints(10, 200)
       //         .forEach(System.out::println);

        //se puede limitar el stream infinito anterior usando limit
        //limitamos a 50
        //filtreis los pares
        //recolectamo en una lista
        int[] numeros = random.ints(10, 200).
                limit(50).
                filter(numero -> numero % 2 == 0).
                toArray();
        System.out.println(Arrays.toString(numeros));
        System.out.println("================================");
        //lo mismo, pero no se pueden repetir
        numeros = random.ints(10, 200).
                limit(50).
                filter(numero -> numero % 2 == 0).
                distinct().
                toArray();
        System.out.println(Arrays.toString(numeros));
        System.out.println("================================");
        //calcular la suma, calcular el valor medio, calcular la multiplicación de los pares distintos
        //SUMA:
        int suma = random.ints(20,200).
                limit(50).
                filter(numero -> numero % 2 == 0).
                distinct().
                sum();
        System.out.printf("La suma de 50 aleatorios, sólo los pares distintos vale: %d%n", suma);
        //calcular el valor máximo y minimo de los pares distintos
        //MAXIMO:
        OptionalInt maximo = random.ints(20,200).
                limit(50).
                filter(numero -> numero % 2 == 0).
                distinct().
                max();
        if (maximo.isPresent())
            System.out.printf("El valor máximo vale %d%n", maximo.getAsInt());
        //MIN
        OptionalInt minimo = random.ints(20,200).
                limit(50).
                filter(numero -> numero % 2 == 0).
                distinct().
                min();
        if (minimo.isPresent())
            System.out.printf("El valor máximo vale %d%n", minimo.getAsInt());
        //hacer debugger con peek
        OptionalInt minimo1 = random.ints(20,200).
                limit(50).
                filter(numero -> numero % 2 == 0).
                peek(System.out::println). //AQUÍ HAGO EL DEBUGGER
                distinct().
                min();
        if (minimo1.isPresent())
            System.out.printf("El valor máximo vale %d%n", minimo1.getAsInt());
        //VALOR MEDIO:
        OptionalDouble media = random.ints(20,200)
                .limit(50)
                .filter(numero -> numero % 2 == 0)
                .distinct()
                .average();
        if (media.isPresent())
            System.out.printf("El valor medio vale %.2f%n", media.getAsDouble());

        //MULTIPLICACION  (reduce)
        //long porque es una multiplicación
        long valorMaximo = 200 * 200 * 200 * 200; //comprobamos que un long se traga la multiplicación
         System.out.printf("Cota máxima de la multiplicación %d%n", valorMaximo);
        long valorMultiplicacion = random.ints(20, 200).
                limit(50).
                filter(numero -> numero % 2 == 0).
                distinct().
                limit(4). //limitamos para que la multiplicación no desborde
              //  peek(System.out::println).
                reduce(1, (multiplicacion, numero) -> multiplicacion * numero);
        System.out.printf("La multiplicación vale: %d%n", valorMultiplicacion);
    }
}
