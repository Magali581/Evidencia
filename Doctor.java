import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
public class Doctor {

    String nombredoc;
    String especialidad;
    HashMap<String, String> map = new HashMap<> ();
    Scanner resp = new Scanner(System.in);


    //Dar de alta un doctor
    public void altadoctor() {
        cargar(map);
        System.out.println("Ingrese el nombre de el doctor ");
        nombredoc = resp.next();
        System.out.println("Ingrese la especialidad de el doctor: ");
        especialidad = resp.next();
        alta(map,nombredoc,especialidad);
        guardarcambios(map);
    }


    //Mostrar lista de doctores
    public void listadoctor() {
        cargar(map);
        lista(map);

    }


    // Dar de alta un doctor
    public static void alta(HashMap<String, String> map, String nombredoc, String especialidad){
        if (map.containsKey(nombredoc)) {
            System.out.println("Informacion existente, no se puede registrar dos veces");
        }
        else {
            map.put(nombredoc, especialidad);
            System.out.println("El doctor " + nombredoc + " se ha registrado correctamente");
        }
    }

//Mostrar lista de doctores
    public static void lista(HashMap<String, String>map) {
        Iterator<String> iterator = map.keySet().iterator();

        System.out.println("Nombre \t|\t Especialidad ");

        while (iterator.hasNext())
        {
            String list = iterator.next();
            System.out.println("  "+list+"\t|\t"+map.get(list));

        }
    }


    // cargar datos y lista
    public static void cargar(HashMap<String, String> m)
    {
        String inputFilename = "C:\\Users\\Magali\\IdeaProjects\\Evidenciaok\\listadoctores.csv";
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
        String inputFilename = "C:\\Users\\Magali\\IdeaProjects\\Evidenciaok\\listadoctores.csv";
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





