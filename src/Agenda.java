
public class Agenda {
    int cantContactos;
    Contacto[] contactos;

    public Agenda(){
        this.cantContactos=10;
        this.contactos= new Contacto[10];
    }

    public Agenda(int cantContactos){
        this.cantContactos=cantContactos;
        this.contactos= new Contacto[cantContactos];

    }

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
}
