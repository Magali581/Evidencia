import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
public class Cita {


    public String idcita;
    public String fecha;
    public String hora;
    public String motivo;
    public String nombrepaciente;
    public String nombredoc;
    public String confirmacion;
    public Scanner scanner = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<> ();


        //Crear cita

        public void crearcita() {
            cargar(map);
            System.out.println("Ingresa el numero de cita ");
            this.idcita = scanner.nextLine();
            System.out.println("Ingresa la fecha de la cita");
            this.fecha = scanner.nextLine();
            System.out.println("Ingrese la hora de la cita");
            this.hora = scanner.nextLine();
            System.out.println("Ingresa el motivo de la cita");
            this.motivo = scanner.nextLine();
            System.out.println("Ingresa el nombre de el paciente");
            this.nombrepaciente = scanner.nextLine();
            System.out.println("Ingresa el nombre de el doctor");
            this.nombredoc = scanner.nextLine();
            System.out.println("¿Desea guardar la cita numero " + idcita + " para el dia " + fecha + " a las " + hora + " con el doctor " + nombredoc + "? (Introduzca si o no)");
            this.confirmacion = scanner.nextLine();
            if (confirmacion.equals("si") && confirmacion.equals("si")){
                crearcita(map, idcita, nombrepaciente);
                guardarcambios(map);
            }
            else {
                System.out.println("Cambios no guardados");


            }

        }




    // Crear una cita
        public static void crearcita(HashMap<String, String> map, String idcita, String nombrepacinte){
            if (map.containsKey(idcita)) {
                System.out.println("Informacion existente, no se puede registrar dos veces");
            }
            else {
                map.put(idcita, nombrepacinte);
                System.out.println("La cita numero "  + idcita + " para el paciente "  + nombrepacinte + " se ha registrado correctamente");
            }
        }



        // cargar datos y lista
        public static void cargar(HashMap<String, String> m)
        {
            String inputFilename = "C:\\Users\\Magali\\IdeaProjects\\Evidenciaok\\listapacientes.csv";
            String a [];

            BufferedReader bufferedReader = null;

            try {
                bufferedReader = new BufferedReader(new FileReader(inputFilename));

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    a = line.split(",");
                    m.put(a[0],a[1]);
                }
            } catch(IOException e) {
                System.out.println("IOException catched while reading: " + e.getMessage());
            } finally {
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (IOException e) {
                    System.out.println("IOException catched while closing: " + e.getMessage());
                }
            }

        }

        //guardar cambios
        public static void guardarcambios(HashMap<String, String> m)
        {
            Iterator<String> iterator = m.keySet().iterator();
            String inputFilename = "C:\\Users\\Magali\\IdeaProjects\\Evidenciaok\\listapacientes.csv";
            BufferedWriter bufferedWriter = null;

            try {
                bufferedWriter = new BufferedWriter(new FileWriter(inputFilename));

                while(iterator.hasNext())
                {
                    String list = iterator.next();


                    bufferedWriter.write(list+","+m.get(list)+"\n");
                }

            }
            catch(IOException e) {
                System.out.println("IOException catched while writing: " + e.getMessage());
            } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (IOException e) {
                    System.out.println("IOException catched while closing: " + e.getMessage());
                }
            }
        }
    }



