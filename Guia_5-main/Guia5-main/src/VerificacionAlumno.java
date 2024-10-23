import java.util.ArrayList;
import java.util.List;

public class VerificacionAlumno {

    public static void verificarAlumno(Alumno alumno) throws AlumnoNoExisteException{
        if(alumno == null){
            throw new AlumnoNoExisteException("El alumno ingresado no existe: ");
        }
    }

    public static void verificarNombre(String nombre) throws NombreInvalidoException{
        if(nombre==null || nombre.isEmpty()){
            throw new NombreInvalidoException("El nombre del alumno ingresado es invalido: ");
        }
    }

    public static void verificarNacionalidad(String nacionalidad) throws NacionalidadInvalidaException{
        if(nacionalidad==null || nacionalidad.isEmpty()){
            throw new NacionalidadInvalidaException(("La nacionalidad del alumno ingresado es invalida: "));
        }
    }

    public static void verificarArregloAlumnos(List<Alumno> alumnos){
        if(alumnos.isEmpty()){
            throw new ArregloAlumnosVacioException("El arreglo de alumnos esta vacio: ");
        }
    }

}
