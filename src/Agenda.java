
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
        if(espaciosLibres()>0 && !estaEnAgenda(contacto.getNombre(), contacto.getApellido())){
            for (int i = 0; i < contactos.length; i++) {
                if(contactos[i]==null){
                    contactos[i]=contacto;
                    break;
                }
            }
            System.out.println("Contacto Agregado Satisfactoriamente: ");
            System.out.println("Nombre: "+contacto.getNombre()+" "+contacto.getApellido());
            System.out.println("Telefono: "+contacto.getTelefono());

        }else if(espaciosLibres()==0){
            System.out.println("Agenda llena. Elimine contactos para seguir agregando nuevos.");
        }else if(estaEnAgenda(contacto.getNombre(), contacto.getApellido())){
            System.out.println("El contacto ya se encuentra registrado en la agenda.");
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

    public boolean estaEnAgenda(String nombre, String apellido){
        boolean esta=false;
        for (Contacto contacto : contactos) {
            if(contacto!=null && contacto.getNombre().toLowerCase().equals(nombre.toLowerCase()) && contacto.getApellido().toLowerCase().equals(apellido.toLowerCase())){
                esta = true;
                break;
            }else{
                esta = false;
            }
        }
        return esta;
    }




}
