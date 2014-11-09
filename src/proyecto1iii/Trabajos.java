/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto1iii;
import java.util.Scanner;
/**
 *
 * @author Roger
 */
public class Trabajos {
    int cedula;
    String nombre;
    String apellido;
    String organizacion;
    String categoria;
    String titulo;
    String contenido;
    Trabajos sig;
    int Dia;
    int Mes;
    int Año;
    int codigo;
    Scanner sc = new Scanner(System.in);

    public Trabajos(int cedula, String nombre, String apellido, String organizacion, String categoria, String titulo, String contenido, Trabajos sig, int Dia, int Mes, int Año, int codigo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.organizacion = organizacion;
        this.categoria = categoria;
        this.titulo = titulo;
        this.contenido = contenido;
        this.sig = sig;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Año = Año;
        this.codigo = codigo;
    }

    public Trabajos() {
    }
    
    public void llenar (int cod) {
        boolean aux = false;
        categoria="";
        System.out.println("Ingrese la cédula del autor");
        cedula = sc.nextInt();
        System.out.println("Ingrese el nombre del autor");
        nombre = sc.nextLine();
        System.out.println("Ingrese el apellido del autor");
        apellido = sc.nextLine();
        System.out.println("Ingrese la organización");
        organizacion = sc.nextLine();
        System.out.println("Ingrese la categoría (s minúscula para salud, t minúscula para tecnología)");
        while (!categoria.equals("s") && !categoria.equals("t")) {       
            categoria = sc.nextLine();
        }
        while (aux == false){
        System.out.println("Ingrese el título del artículo (máxmio 20 caracteres)");
        titulo = sc.nextLine();
        if (titulo.length() > 20){
                System.out.println("Error, límite de caracteres superado, intente de nuevo.");
        }else{
                aux = true;
                }
        }
        aux = false;
        while (aux == false) {
        System.out.println("Ingrese el contenigo del artículo (máxmio 1000 caracteres)");
        contenido=sc.nextLine(); 
        if (contenido.length() > 1000){
            System.out.println("Error, límite de caracteres superado, intente de nuevo.");
        }else{
            aux = true;
        }
        }
        sig = null;     
        Dia = 0;
        Mes = 0;
        Año = 0;
        while (Mes<1 && Mes>12){
        System.out.println("Ingrese sel mes");
        Mes = sc.nextInt();
        }
        while (Dia<1 && Dia>31){            
        System.out.println("Ingrese el día");
        Dia = sc.nextInt();
        }
        while (Año<1){
        System.out.println("Ingrese el año");
        Año = sc.nextInt();
        }       
        codigo = cod;
    }
}
