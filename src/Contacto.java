public class Contacto {
    private String nombre;
    private String apellido;
    private int telefono;


    public Contacto(){

    }
    public Contacto(String nombre, String apellido, int telefono){
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

    public int getTelefono() {
        return telefono;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
