package ejercicioIntenet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));

        //Obtener la cantidad de cursos con una duración mayor a 5 horas
        long numeroCursosMas5Horas = cursos.stream().
                filter(curso -> curso.duracionHoras() > 5).
                count();
        System.out.printf("Nº cursos con mas de cinco horas: %d%n", numeroCursosMas5Horas);

        //Obtener la cantidad de cursos con una duración menor a 2 horas.
        long numeroCursosMenos2Horas = cursos.stream().
                filter(curso -> curso.duracionHoras() < 2).
                count();
        System.out.printf("Nº cursos con menos de dos horas: %d%n", numeroCursosMenos2Horas);

        //Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50
        System.out.println("=============Lista cursos con nº videos superior a 50===============");
        List<Curso> cursosVideosMas50 = cursos.stream().
                                            filter(curso -> curso.numeroVideos() > 50).
                                            toList();
        cursosVideosMas50.forEach(System.out::println);
        //mal hecho, no me pide una lista de cursos, sino de títulos de curso
        List<String> titulosCursosVideosMas50 = cursos.stream().  //Stream<Curso> entero
                filter(curso -> curso.numeroVideos() > 50). //Stream<Curso>  filtrados algunos
                map(Curso::tituloCurso).                         //Stream<String>  son los titulos
                toList();                                        //List<String>
        titulosCursosVideosMas50.forEach(System.out::println);

        //Mostrar en consola el título de los 3 cursos con mayor duración
        System.out.println("==========Mostrar titulo en consola 3 cursos con mas horas==========");
        cursos.stream().
                sorted(Comparator.comparing(Curso::duracionHoras).reversed()).  //Stream<Curso>
                limit(3).                                                     //Stream<Curso>
                map(Curso::tituloCurso).                                       //Stream<String>
                forEach(System.out::println);

        //Mostrar en consola la duración total de todos los cursos.
        double totalHorasCursos = cursos.stream().
                                    mapToDouble(Curso::duracionHoras).
                                    sum();
        System.out.println("=========================================");
        System.out.printf("Horas totales de los cursos: %.1f%n", totalHorasCursos);

        //Mostrar en consola todos aquellos libros que superen el promedio en cuanto a duración se refiere.
        //Primero calculamos la media y la guardamos en una variable para poder usar:
        Optional<Double> mediaHorasCursos = Optional.of(
                cursos.stream().
                mapToDouble(Curso::duracionHoras).
                average().
                getAsDouble()
        );
        System.out.println("=============Lista cursos con nº horas superiores a la media===============");
        if (mediaHorasCursos.isPresent())
            cursos.stream().
                    filter(curso -> curso.duracionHoras() > mediaHorasCursos.get()).
                    forEach(System.out::println);

        //Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
        double  duracionCursosMenos500alumnos =
                cursos.stream().                                         //Stream<Curso>
                filter(curso -> curso.numeroAlumnos() < 500).  //Stream<Curso>
                mapToDouble(Curso::duracionHoras).                  //DoubleStream
                sum();
        System.out.printf("Nº total horas cursos con menos de 500 alumnos %.1f%n", duracionCursosMenos500alumnos);

        //Obtener el curso con mayor duración.
        System.out.println("============Curso mas largo===================");
        Optional<Curso> cursoMasLargo = cursos.stream().
                max(Comparator.comparing(Curso::duracionHoras));
        if (cursoMasLargo.isPresent())
            System.out.println(cursoMasLargo.get());

        //Crear una lista de Strings con todos los titulos de los cursos.
        List<String> listaTitulosCurso = cursos.stream().
                map(Curso::tituloCurso).
                toList();
        System.out.println("=============Título de todos los cursos==============");
        listaTitulosCurso.forEach(System.out::println);
    }


}
