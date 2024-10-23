import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        1. ¿Qué está mal en el siguiente bloque de código?

            try
            {
            Persona p = baseDeDatos.buscar(datos);
            System.out.println(“Los datos pertenecen a: ” + p);
            }
            catch(Exception e) {
            // Maneja cualquiera de las excepciones comprobadas
            }
            catch(RuntimeException e) {
            // Maneja cualquiera de las excepciones no comprobadas
            }

            El error principal es que el bloque RuntimeException (no comprobada) está luego del bloque Exception (comprobada). Esto es incorrecto ya que
            RuntimeException es más específica que Exception, por lo que su bloque debe estar antes.
         */

        /*
        2. Explique lo que sucede en el siguiente código y por qué.

            public static class EjemploExcepciones{
            public static int devuelveNumero(int num) {
            try {
            if (num % 2 == 0) {
            throw new Exception("Lanzando excepcion");
            }
            return 1;
            } catch (Exception ex) {
            ex.getMessage().concat("Rompi todo y pase por Catch");
            return 2;
            } finally {
            return 3;
            }
            }
            }

            Esto retorna 3 en todos los casos ya que el bloque finally siempre se ejecuta.
         */

        /*3. Escribe un programa que juegue con el usuario a adivinar un número.
        El ordenador debe generar un número entre 1 y 500, y el usuario tiene que
        intentar adivinarlo.
        Para ello, cada vez que el usuario introduce un valor, el ordenador debe
        decirle al usuario si el número que tiene que adivinar es mayor o menor que el
        que ha introducido el usuario. Cuando consiga adivinarlo, debe indicarlo e
        imprimir en pantalla el número de veces que el usuario ha intentado adivinar
        el número. */
        /*
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int numeroAleatorio = random.nextInt(501);
        int numeroIngresado = pedirNumero();
        boolean adivino=false;

        do{
            if(numeroIngresado==numeroAleatorio){
                System.out.println("ADIVINO :)");
                adivino=true;
            }else{
                if(numeroIngresado>numeroAleatorio){
                    System.out.println("El numero ingresado es mayor al que debe adivinar! Inténtelo nuevamente.");
                }else{
                    System.out.println("El numero ingresado es menor al que debe adivinar! Inténtelo nuevamente.");
                }
                numeroIngresado = pedirNumero();
            }
        }while(!adivino);
        */

        //4.

        Colegio colegio = new Colegio();

        Alumno alumno1 = new Alumno("Lucia", "");
        Alumno alumno2 = new Alumno("Mateo", "Brasil");
        Alumno alumno3 = new Alumno("Jazmin", "España");
        Alumno alumno4 = new Alumno("Lautaro", "Argentina");
        Alumno alumno5 = new Alumno("Mariana", "Argentina");
        Alumno alumno6 = new Alumno("Roberto", "Brasil");
        Alumno alumno7 = new Alumno("Gonzalo", "");

        colegio.agregarAlumno(alumno1);
        colegio.agregarAlumno(alumno2);
        colegio.agregarAlumno(alumno3);
        colegio.agregarAlumno(alumno4);
        colegio.agregarAlumno(alumno5);
        colegio.agregarAlumno(alumno6);
        colegio.agregarAlumno(alumno7);

        System.out.println(colegio.verAlumnos());

        System.out.println(colegio.verTodos());

    }

    public static int pedirNumero(){
        Scanner scan = new Scanner(System.in);
        int numeroIngresado=-1;
        boolean enteroCheck=false;
        do {
            try {
                System.out.println("Adivine el numero: \n");
                numeroIngresado = scan.nextInt();
                enteroCheck=true;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un entero. Inténtelo nuevamente.");
                scan.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(!enteroCheck);

        return numeroIngresado;
    }
}