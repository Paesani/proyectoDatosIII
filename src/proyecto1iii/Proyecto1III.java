package proyecto1iii;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Roger
 */
public class Proyecto1III {
  static CabecerasIII Objeto = new CabecerasIII();
   static int opc = 0;
   static Scanner sc = new Scanner(System.in);
   static boolean aux = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            while (aux!=true){
                System.out.println("Ingrese una orden");
                System.out.println("1) Agregar un nuevo artículo");
                System.out.println("2) Aprobar o rechazar un artículo");
                System.out.println("3) Mostrar artículos aprobados");
                System.out.println("4) Mostrar artículos rechazados");
                System.out.println("5) Mostrar los totales de artículos aprobados, rechazados, en revisión, el total de salud, el total de tecnología y el total general");
                System.out.println("6) Mostrar un listado artículos aprobados de salud y de tecnología");
                System.out.println("7) Mostrar los datos de un artículo aprobado usando por parámetro su código");
                System.out.println("8) Salir");
                opc=sc.nextInt();
                switch (opc){
                    case 1: Objeto.crear();
                        break;
                    case 2: Objeto.revision();
                        break;
                    case 3: Objeto.revisarA();
                        break;
                    case 4: Objeto.revisarP(Objeto.Pila);
                        break;
                    case 5: Objeto.total();
                        break;
                    case 6: System.out.println("Artículos de salud: ");
                        Objeto.listadoAS();
                        System.out.println("Artículos de tecnología");
                        Objeto.listadoAT();
                        break;
                    case 7:
                        System.out.println("Ingrese el código");
                        int cod = sc.nextInt();    
                        Objeto.buscar(Objeto.Cola.ColaA, cod, Objeto.Cola.ColaA.codigo, false);
                        break;
                    case 8: aux=true;
                        break;
                }
            }
        }catch(Exception e){            
        }
    }
    public Proyecto1III() {
    }
}