package ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
//lo mismo que Main0, pero sin usar Scanner, usamos Files: readAllLines
public class Main1 {
    public static void main(String[] args) {
        List<Person> personas = new ArrayList<>();
        //vamos a usar Files.readAllLines
        try {
            List<String> lineas = Files.readAllLines(Path.of("files/datos.csv"));
            for (String linea : lineas) {
                String[] tokens = linea.split(",");
                if (tokens.length != 4 || !tokens[0].matches("[0-9]+")) {  //aseguramos 4 tokens
                    System.err.printf("Línea no valida: %S%n", linea);
                    continue; //sino leemos otra línea
                }
                //int id = Integer.parseInt(tokens[0]);
                //Person persona = new Person(id, tokens[1], tokens[2], tokens[3] );
                personas.add(new Person(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3] ));
            }
        } catch (IOException e) {
           // throw new RuntimeException(e);
            System.err.println("No encontrado fichero: " + e.getMessage());
        }
        personas.forEach(System.out::println);
        System.out.printf("number of data read: %d %n", personas.size());
    }
}
