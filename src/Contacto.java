public class Contacto {
    private String nombre;
    private String apellido;
    private long telefono;


    public Contacto(){

    }
    public Contacto(String nombre, String apellido, long telefono){
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
}
