import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner inputChar = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);

        System.out.println("\n:::::::::::::::::::::Agenda Telefónica:::::::::::::::::::::\n");
        System.out.println("Para iniciar, debes escoger la capacidad de tu agenda.\nPuedes hacerlo manualmente o escoger el tamaño por defecto.\n\n¿Que deseas hacer?\n");
        System.out.println("(1) Definir manualmente.\n(2) Definir capacidad por defecto '10 contactos.'\n\nEscriba su elección:");
        int cant;
        char opt = inputChar.next().charAt(0);
        Agenda nuevaAgenda = new Agenda();

        switch (opt) {
            case '1':
                System.out.println("Ingrese la cantidad de contactos que tu agenda permitirá: ");
                cant = inputNum.nextInt();
                nuevaAgenda = new Agenda(cant);

                break;

            case '2':
                nuevaAgenda = new Agenda();
                break;

            default:
                System.out.println("Elija una opción válida");
                break;
        }
        
        
        char option;
        do{
            System.out.println("\n----------------------------------------\n");
            System.out.println("::Menu de opciones::\n\n(1) Agregar nuevo Contactos.\n(2) Mostrar Lista de Contactos.\n(3) Buscar Contacto.\n(4) Eliminar Contacto.\n(5) Modificar Contacto.\n(6) Consultar espacio Disponible.\n(0) Salir"); 
            System.out.println("\n----------------------------------------\n");

            System.out.println("Escoja la opción deseada: ");
            option = inputChar.next().charAt(0);            

            switch (option){
                case '1':
                    String nombre;
                    System.out.println("\n::::::::::Nuevo Contacto::::::::::\n");
                    do { 
                        System.out.println("\nIngrese nombre del Contacto: ");
                        nombre = inputStr.nextLine();    
                        if(nombre.equals("")){
                            System.out.println("Este campo no puede estar vacío...");
                        }
                    } while (nombre.equals(""));

                    String apellido;
                    do { 
                        System.out.println("\nIngrese apellido del contacto: ");
                        apellido = inputStr.nextLine();
                        if(apellido.equals("")){
                            System.out.println("Este campo no puede estar vacío...");
                        }
                    } while (apellido.equals(""));

                    
                    System.out.println("\nIngrese el numero de teléfono: ");
                    long telefono = inputNum.nextLong();

                    Contacto contacto = new Contacto(nombre,apellido,telefono);

                    nuevaAgenda.añadirContacto(contacto);
                    System.out.println("Presione Enter para continuar...");
                    inputStr.nextLine();
                    break;
                
                case '2':
                    nuevaAgenda.listarContactos();
                    System.out.println("Presione Enter para continuar...");
                    inputStr.nextLine();
                    break;
                
                case '3':
                    System.out.println("Presione Enter para continuar...");
                    inputStr.nextLine();
                    break;

                case '4':
                    System.out.println("Presione Enter para continuar...");
                    inputStr.nextLine();
                    break;

                case '5':
                    System.out.println("Presione Enter para continuar...");
                    inputStr.nextLine();
                    break;

                case '6':
                    System.out.println("Presione Enter para continuar...");
                    inputStr.nextLine();
                    break;

                case '0':
                    System.out.println("\n----------------------------------------\n");
                    System.out.println("Muchas Gracias por utilizar nuestro sistema. \n¡Nos vemos!");
                    System.out.println("\n----------------------------------------\n");
                    break;
                
                default:
                    System.out.println("\nIngrese una opción válida...");
                    break;
            }

        }while(option!='0');


    }
}
