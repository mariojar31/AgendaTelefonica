import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner inputChar = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);

        System.out.println("::::::Agenda Telefónica::::::\n");
        System.out.println("Ingrese la cantidad de contactos que tu agenda permitirá: ");
        int cant = inputNum.nextInt();

        Agenda nuevaAgenda = new Agenda(cant);
        
        char option;
        do{
            System.out.println("::Menu de opciones::\n\n(1) Agregar nuevo Contactos.\n(2) Mostrar Lista de Contactos.\n(3) Buscar Contacto.\n(4) Eliminar Contacto.\n(5) Modificar Contacto.\n(6) Consultar espacio Disponible.\n(0) Salir");    
            System.out.println("Escoja la opción deseada: ");
            option = inputChar.next().charAt(0);            

            switch (option){
                case '1':
                    System.out.println("Ingrese nombre del Contacto: ");
                    String nombre = inputStr.nextLine();
                    System.out.println("Ingrese apellido del contacto: ");
                    String apellido = inputStr.nextLine();
                    System.out.println("Ingrese el numero de teléfono: ");
                    long telefono = inputNum.nextLong();

                    Contacto contacto = new Contacto(nombre,apellido,telefono);

                    nuevaAgenda.añadirContacto(contacto);
                    break;
                
                case '2':

                    break;
                
                case '3':

                    break;

                case '4':

                    break;

                case '5':

                    break;

                case '6':

                    break;

                case '0':

                    break;
            }

        }while(option!='0');


    }
}
