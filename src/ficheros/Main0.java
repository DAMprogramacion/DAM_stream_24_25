package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        //usando Scanner leemos el fichero datos.csv y llenamos la lista
        try (Scanner scanner = new Scanner(new File("files/datos.csv"))) {
            //2,Edeline,Littledike,elittledike1@webnode.com
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                if (tokens.length != 4 || !tokens[0].matches("[0-9]+")) {  //aseguramos 4 tokens
                    System.err.printf("Línea no valida: %S%n", line);
                    continue; //sino leemos otra línea
                }
                int id = Integer.parseInt(tokens[0]);
                Person person = new Person(id, tokens[1], tokens[2], tokens[3] );
                people.add(person);
            }
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        }
        people.forEach(System.out::println);
        System.out.printf("number of data read: %d %n", people.size());
    }
}
