import java.util.Arrays;
import java.util.Comparator;

public class Agenda {
    int cantContactos;
    Contacto[] contactos;

    // Constructores
    public Agenda(){
        this.cantContactos=10;
        this.contactos= new Contacto[10];
    }

    public Agenda(int cantContactos){
        this.cantContactos=cantContactos;
        this.contactos= new Contacto[cantContactos];

    }
    // Getters & Setters
    public Contacto[] getContactos() {
        return contactos;
    }
    public void setContactos(Contacto[] contactos) {
        this.contactos = contactos;
    }

    public int getCantContactos() {
        return cantContactos;
    }

    public void setCantContactos(int cantContactos) {
        this.cantContactos = cantContactos;
    }

    // Otros Metodos

    public void añadirContacto(Contacto contacto){
        if(espaciosLibres()>0 && !estaEnAgenda(contacto)){
            for (int i = 0; i < contactos.length; i++) {
                if(contactos[i]==null){
                    contactos[i]=contacto;
                    break;
                }
            }
            System.out.println("\n----------------------------------------\n");
            System.out.println("Contacto Agregado Satisfactoriamente: \n");
            System.out.println("Nombre: "+contacto.getNombre()+" "+contacto.getApellido());
            System.out.println("Telefono: "+contacto.getTelefono());
            System.out.println("\n----------------------------------------\n");


        }else if(espaciosLibres()==0){
            System.out.println("\n---------------------------------------------------------------\n");
            System.out.println("Agenda llena. Elimine contactos para seguir agregando nuevos.");
            System.out.println("\n---------------------------------------------------------------\n");
        }else if(estaEnAgenda(contacto)){
            System.out.println("\n---------------------------------------------------------------\n");
            System.out.println("¡Contacto No agregado!");
            System.out.println("El contacto ya se encuentra previamente registrado en la agenda.");
            System.out.println("\n--------------------------------------------------------------\n");
        }
    }

    public void listarContactos(){
        System.out.println("\n::::::::::::::::Contactos::::::::::::::::\n");
         // Filtrar contactos no nulos
        Contacto[] contactosFiltrados = Arrays.stream(contactos)
        .filter(contacto -> contacto != null)
        .toArray(Contacto[]::new);

        Arrays.sort(contactosFiltrados, Comparator.comparing(Contacto::getNombre));
        for (Contacto contacto : contactosFiltrados){
            if(contacto!=null){
                System.out.println(contacto.getNombre()+" "+contacto.getApellido());
                System.out.println("Telefono: "+contacto.getTelefono());
                System.out.println("\n----------------------------------------\n");
            }

        }
        System.out.println("Contactos guardados: "+(cantContactos-espaciosLibres()));
        System.out.println("Espacio disponible: "+espaciosLibres()+" de "+cantContactos+"\n");
    }

    public Contacto buscarContacto(String nombre, String apellido){
        boolean esta=false;
        Contacto contactoBuscado = null;

        for (Contacto contacto : contactos) {
            if(contacto!=null && contacto.getNombre().toLowerCase().equals(nombre.toLowerCase()) && contacto.getApellido().toLowerCase().equals(apellido.toLowerCase())){
                System.out.println("\n----------------------------------------\n");
                System.out.println("Contacto encontrado:\n");
                System.out.println(contacto.getNombre()+" "+contacto.getApellido());
                System.out.println("Telefono: "+contacto.getTelefono());
                System.out.println("\n----------------------------------------\n");
                contactoBuscado=contacto;
                esta=true;
                break;
            }
        }
        if (!esta) {
            System.out.println("\n----------------------------------------\n");
            System.out.println("...Contacto no encontrado...");
            System.out.println("\n----------------------------------------\n");
            
        }
        
        return contactoBuscado;
        
    }

    public Contacto obtenerContacto(String nombre, String apellido){

        Contacto contactoBuscado = null;

        for (Contacto contacto : contactos) {
            if(contacto!=null && contacto.getNombre().toLowerCase().equals(nombre.toLowerCase()) && contacto.getApellido().toLowerCase().equals(apellido.toLowerCase())){
                contactoBuscado=contacto;
                break;
            }
        }
        
        return contactoBuscado;
        
    }

    public void eliminarContacto(Contacto contactoe) {
        if(contactoe!=null){
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] != null
                        && contactos[i].getNombre().equalsIgnoreCase(contactoe.getNombre())
                        && contactos[i].getApellido().equalsIgnoreCase(contactoe.getApellido())
                        && contactos[i].getTelefono() == contactoe.getTelefono()) {
                    contactos[i] = null;
                    System.out.println("\n----------------------------------------\n");
                    System.out.println("Contacto eliminado satisfactoriamente");
                    System.out.println("\n----------------------------------------\n");

                    return;
                }
            }    
        }else{
            System.out.println("\n----------------------------------------\n");
            System.out.println("No se encontró el contacto\nNo se pudo eliminar.");
            System.out.println("\n----------------------------------------\n");
        }
        
    }

    public void modificarTelefono( String nombre, String apellido, long nuevoTelefono) {
        Contacto contactoBuscado = obtenerContacto(nombre, apellido);
        if(contactoBuscado!=null) {
            for (Contacto contacto : contactos) {
                if (contacto != null && contacto.getNombre().toLowerCase().equals(contactoBuscado.getNombre().toLowerCase()) && contacto.getApellido().toLowerCase().equals(contactoBuscado.getApellido().toLowerCase())) {
                    contacto.setTelefono(nuevoTelefono);   
                }
            }
            
        }else {
            System.out.println("No se encontro la persona ");
        }
        System.out.println("\n----------------------------------------\n");
        System.out.println("Contacto modificado:\n");
        System.out.println(contactoBuscado.getNombre()+" "+contactoBuscado.getApellido());
        System.out.println("Telefono: "+nuevoTelefono);
        System.out.println("\n----------------------------------------\n");
    }
    
    public void verificarAgendaLlena(){
        if(espaciosLibres()==0){
            System.out.println("\n----------------------------------------\n");
            System.out.println("¡La agenda está llena!");
            System.out.println("\n----------------------------------------\n");
    }else{
        System.out.println("\n----------------------------------------\n");
        System.out.println("Aun hay espacio disponible");
        System.out.println("Espacio utilizado: "+(cantContactos-espaciosLibres())+" de "+cantContactos);
        System.out.println("\n----------------------------------------\n");
        }
    }

    //Metodos Auxiliares

    public int espaciosLibres(){
        int count=0;
        for (int i = 0; i < contactos.length; i++) {
            if(contactos[i]==null){
                count++;
            }
        }
        
        return count;
    }

    public boolean estaEnAgenda(Contacto contact){
        boolean esta=false;
        for (Contacto contacto : contactos) {
            if(contacto!=null && contacto.getNombre().toLowerCase().equals(contact.getNombre().toLowerCase()) && contacto.getApellido().toLowerCase().equals(contact.getApellido().toLowerCase())){
                esta = true;
                break;
            }else{
                esta = false;
            }
        }
        return esta;
    }




}
