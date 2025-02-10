package teroria;

import java.util.Arrays;
import java.util.Random;

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
    }
}
