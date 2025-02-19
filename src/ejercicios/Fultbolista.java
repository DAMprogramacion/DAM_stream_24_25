package ejercicios;

import java.time.LocalDate;
import java.time.Period;

public class Fultbolista {
    private String nombreFutbolista;
    private LocalDate fechaNacimiento;
    private Puesto puesto;
    private final String dni;

    public Fultbolista(
            String nombreFutbolista, LocalDate fechaNacimiento, Puesto puesto, String dni) {
        this.dni = dni;
        this.puesto = puesto;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreFutbolista = nombreFutbolista;
    }

    public String getNombreFutbolista() {
        return nombreFutbolista;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public String getDni() {
        return dni;
    }

    public void setNombreFutbolista(String nombreFutbolista) {
        this.nombreFutbolista = nombreFutbolista;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        //Gabriel Rodrı́guez,21,PORTERO,12345678A
        return String.format("%s;%d;%s;%s", nombreFutbolista, calcularEdad(), puesto, dni);
    }

    public int calcularEdad() {
        Period periodo = Period.between(fechaNacimiento, LocalDate.now());
        return periodo.getYears();
    }

    public static void main(String[] args) {
        Fultbolista futbolista = new Fultbolista(
                "Aguilar Carmona, Fco", LocalDate.of(2000,2,28), Puesto.PORTERO, "12345678a");
        System.out.println(futbolista);
    }
}
