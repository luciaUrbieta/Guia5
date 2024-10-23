public class Alumno {

    private String nombre;
    private String nacionalidad;

    public Alumno(){
    }

    public Alumno(String nombre, String nacionalidad){
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String toString(){
        return "\nNombre: " + nombre + "\nNacionalidad: " + nacionalidad;
    }
}
