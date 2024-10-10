
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
            System.out.println("\n----------------------------------------\n");
            System.out.println("Agenda llena. Elimine contactos para seguir agregando nuevos.");
            System.out.println("\n----------------------------------------\n");
        }else if(estaEnAgenda(contacto)){
            System.out.println("\n----------------------------------------\n");
            System.out.println("El contacto ya se encuentra registrado en la agenda.");
            System.out.println("\n----------------------------------------\n");
        }
    }

    public void listarContactos(){
        System.out.println("\n::::::::::::::::Contactos::::::::::::::::\n");
        
        for (Contacto contacto : contactos){
            if(contacto!=null){
                System.out.println(contacto.getNombre()+" "+contacto.getApellido());
                System.out.println("Telefono: "+contacto.getTelefono());
                System.out.println("\n----------------------------------------\n");
            }

        }
        System.out.println("Contactos guardados: "+(cantContactos-espaciosLibres()));
        System.out.println("Espacio disponible: "+espaciosLibres()+" de "+cantContactos+"\n");
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
