import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
public class Paciente {


        String idpaciente;
        String nombrepacinte;


        HashMap<String, String> map = new HashMap<> ();
        Scanner resp = new Scanner(System.in);


    //Dar de alta un paciente

    public void altapaciente() {
        cargar(map);
        System.out.println("Ingresa el id de paciente: ");
        idpaciente = resp.next();
        System.out.println("Ingresa el nombre y apellido de el paciente");
        nombrepacinte = resp.next();
        alta(map, idpaciente, nombrepacinte);
        guardarcambios(map);
    }

    //Mostrar lista de pacientes
    public void listapaciente () {
        cargar(map);
        lista(map);
    }


    //Eliminar un paciente

    public void eliminarpaciente() {
        cargar(map);
        System.out.println("Inserte el id del paciente a eliminar: ");
        idpaciente = resp.next();
        eliminar(map, idpaciente);
        guardarcambios(map);
    }




        // Dar de alta un paciente
        public static void alta(HashMap<String, String> map, String idpaciente, String nombrepacinte){
            if (map.containsKey(idpaciente)) {
                System.out.println("Informacion existente, no se puede registrar dos veces");
            }
            else {
                map.put(idpaciente, nombrepacinte);
                System.out.println("El paciente " + nombrepacinte + " se ha registrado correctamente");
            }
        }


        public static void lista(HashMap<String, String>map) {
            Iterator<String> iterator = map.keySet().iterator();

            System.out.println("id \t|\t Nombre y apellido ");

            while (iterator.hasNext())
            {
                String list = iterator.next();
                System.out.println("  "+list+"\t|\t"+map.get(list));

            }
        }

        //eliminar un paciente

        public static void eliminar(HashMap<String, String> map, String idpaciente)
        {
            if (map.containsKey(idpaciente)) {
                System.out.println("El paciente "  +map.get(idpaciente) + " ha sido eliminado.");
                map.remove(idpaciente);
            }
            else
                System.out.println("El registro no existe");
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


