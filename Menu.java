import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        String resp;
        String opcion;
        String contra;
        String usuario;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido, inicia sesion para comenzar");
        System.out.println("Introduce tu usuario");
        usuario= scanner.next();
        System.out.println("Introduce la contraseña");
        contra= scanner.next();

        do {


            if (usuario.equals("Administrador") && contra.equals("789114")) {

                System.out.println("Introduce una opcion");
                System.out.println("1.-Dar de alta un doctor");
                System.out.println("2.-Mostrar lista de doctores");
                System.out.println("3.-Dar de alta un paciente");
                System.out.println("4.-Mostrar lista de pacientes");
                System.out.println("5.-Eliminar un paciente");
                System.out.println("6.-Crear una cita");
                System.out.println("7.-Salir");

                opcion = scanner.next();

                switch (opcion) {
                    case "1":
                        Doctor doctor = new Doctor();
                        doctor.altadoctor();
                        break;


                    case "2":
                        Doctor doctor1 = new Doctor();
                        doctor1.listadoctor();
                        break;


                    case "3":
                        Paciente paciente = new Paciente();
                        paciente.altapaciente();
                        break;


                    case "4":
                        Paciente paciente1 = new Paciente();
                        paciente1.listapaciente();
                        break;

                    case "5":
                        Paciente paciente2 = new Paciente();
                        paciente2.eliminarpaciente();
                        break;

                    case "6":
                        Cita crearcita = new Cita();
                        crearcita.crearcita();
                        break;

                    case "7":
                        System.out.println("Saliendo...");
                        System. exit(0);


                    default:
                        System.out.println("opcion inexistente, introduce una opcion correcta");

                }
            } else {
                System.out.println("Usuario o Contraseña incorrectos, vuelve a iniciar el programa");
                System. exit(0);
            }

            do {
                System.out.println("¿Deseas realizar algo mas?");
                System.out.println("si o no: ");
                scanner.nextLine();
                resp = scanner.next();
                resp = resp.toLowerCase();

                if (!resp.equals("si") && !resp.equals("no")) {
                    System.out.println("Opcion invalida");
                }

            } while (!resp.equals("si") && !resp.equals("no"));


        } while (resp.equals("si"));

    }

}
