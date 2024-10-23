import java.util.*;

/* 4. Crea una clase colegio que almacene el listado de los alumnos (compuestos
        por su nombre y nacionalidad). La clase tendrá los siguientes
        métodos:
        Para todos estos métodos se deben generar distintas validaciones para
        prevenir errores en la ejecución. Por ej: Que todos los alumnos tengan una
        nacionalidad, que exista el alumno que se quiere borrar, etc. */

public class Colegio {

    private List<Alumno> alumnos;

    public Colegio(){
        alumnos = new ArrayList<>();
    }

    // agregarAlumno(Alumno alumno): añade el alumno recibido por parámetro al listado.

    public void agregarAlumno(Alumno alumno){
        try{
            VerificacionAlumno.verificarAlumno(alumno);
            VerificacionAlumno.verificarNombre(alumno.getNombre());
            VerificacionAlumno.verificarNacionalidad(alumno.getNacionalidad());
            alumnos.add(alumno);
        }catch(AlumnoNoExisteException e){
            System.out.println(e.getMessage());
        }catch(NombreInvalidoException e){
            System.out.println(e.getMessage());
        }catch(NacionalidadInvalidaException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // borrar(Alumno alumno): Elimina a un alumno específico del listado.

    public void eliminarAlumno(Alumno alumno){
        try{
            VerificacionAlumno.verificarAlumno(alumno);
            alumnos.remove(alumno);
        }catch(AlumnoNoExisteException e){
            e.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }

    public String verNacionalidad(String nacionalidad){
        String retorno="";
        int contador=0;
        try{
            VerificacionAlumno.verificarNacionalidad(nacionalidad);
            for(Alumno alumno : alumnos){
                if(alumno.getNacionalidad().equals(nacionalidad)){
                    contador++;
                }
            }
            retorno="Se encontraron " + contador + " alumnos de nacionalidad " + nacionalidad;
        }catch(NacionalidadInvalidaException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return retorno;
    }

    // cuantos(): Muestra cuántas nacionalidades diferentes existen en el colegio.

    public String cuantos(){
        String retorno="";
        Set<String> nacionalidades = new HashSet<>();
        int contador=0;
        try{
            for(Alumno alumno : alumnos){
                VerificacionAlumno.verificarArregloAlumnos(alumnos);
                nacionalidades.add(alumno.getNacionalidad());
            }
            contador=nacionalidades.size();
            retorno="Se encontraron alumnos de " + contador + " nacionalidades distintas.";
        }catch(ArregloAlumnosVacioException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage()); // Mensaje de error más claro
            System.out.println(e.getMessage()); // Registra la excepción
        }
        return retorno;
    }

    // verTodos(): Muestra las distintas nacionalidades y el número de alumnos que existen por nacionalidad.

    public String verTodos() {

        StringBuilder retorno = new StringBuilder();
        Map<String, Integer> conteoNacionalidades = new HashMap<>(); // Mapa para contar alumnos por nacionalidad

        try {
            for (Alumno alumno : alumnos) {
                String nacionalidad = alumno.getNacionalidad();
                // verifica que la variable nacionalidad no sea nula, vacía o que contenga solo espacios en blanco
                if (nacionalidad != null && !nacionalidad.trim().isEmpty()) {
                    // Incrementa el contador de la nacionalidad
                    conteoNacionalidades.put(nacionalidad, conteoNacionalidades.getOrDefault(nacionalidad, 0) + 1);
                }
            }

            // Construye el retorno con el conteo por nacionalidad
            retorno.append("Se encontraron los siguientes alumnos por nacionalidad:\n");
            for (Map.Entry<String, Integer> entry : conteoNacionalidades.entrySet()) {
                retorno.append(entry.getKey()).append(": ").append(entry.getValue()).append(" alumno(s)\n");
            }
        } catch (Exception e) {
            retorno.append("Error inesperado: ").append(e.getMessage());
            e.printStackTrace(); // Registra la excepción
        }

        return retorno.toString();
    }

    public String verAlumnos(){
        StringBuilder retorno = new StringBuilder();
        for(Alumno alumno : alumnos){
            retorno.append("\nNombre: "+alumno.getNombre());
            retorno.append("\nNacionalidad: "+alumno.getNacionalidad());
            retorno.append("\n----------------------------------------------");
        }
        return retorno.toString();
    }

}
