package ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
//lo mismo que Main1, ahora usamos Files, metodo lines(), que devuelve un Stream<String>
//suponemos que no hay errores en el fichero csv de entrada
public class Main2 {
    public static void main(String[] args) {
        try {
            List<Person> people = getPeople(Path.of("files/datos1.csv"));
            people.forEach(System.out::println);
            System.out.printf("number of data read: %d %n", people.size());
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.err.println("No encontrado fichero: " + e.getMessage());
        }
    }
    public static List<Person> getPeople(Path path) throws IOException {
        return Files.lines(path).
                map(line -> line.split(",")).
                map(tokens -> new Person(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3])).
                toList();

    }
}
