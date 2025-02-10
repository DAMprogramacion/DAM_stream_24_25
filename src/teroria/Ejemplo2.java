package teroria;

import java.util.List;

public class Ejemplo2 {
    public static void main(String[] args) {
        List<String> cadenas = List.of("uno", "dos", "tres", "cuatro");  //inmutable
        System.out.println(cadenas);  //usando el toString de List [,,,]
        //cadenas.add("cinco"); no se puede cambiar el tamaño
        //cadenas.set(0,"1");  tampoco se puede cambiar los valores

        //usamos un bucle for y mostramos los datos sout
        for (String cadena : cadenas) {
            System.out.println(cadena);
        }
        System.out.println("====================================");
        //se puede usar el metodo foreach
        cadenas.forEach(cadena -> System.out.println(cadena)); //expresion lambda
        cadenas.forEach(System.out::println);
        System.out.println("====================================");
        //generar el stream, y vamos usar el forEach para mostrar los datos
        cadenas.stream().
                forEach(System.out::println);
        System.out.println("====================================");
        //usando map, lo mismo que arriba, pero que aparezca en mayúscula (expresión lambda)
        cadenas.stream().
                map(cadena -> cadena.toUpperCase()).
                forEach(cadena -> System.out.println(cadena));
        //usando map, lo mismo que arriba, pero que aparezca en mayúscula (metodos referencia)
        cadenas.stream().
                map(String::toUpperCase).
                forEach(System.out::println);
        System.out.println("=======================");
        //vamos a filtrar los que empiezen por vocal, que aperezcan en mayúscula y mostramos en consola
        cadenas.stream().
                filter(cadena -> cadena.matches("[aeiouAEIOUáéíóúÁÉÍÓÚ].*")).
                map(String::toUpperCase).
                forEach(System.out::println);
        System.out.println("==================================");
        //vamos a filtrar los que no empiecen por vocal, mayúscula,
        // ordenados alfabéticemente (sorted) y mostramos en consola

    }
}
