
package proyecto1iii;
import java.util.Scanner;
/**
 *
 * @author Roger
 */
public class CabecerasIII {
    Cola Cola;//Apuntador de la clase Cola
    Pila Pila;//Apuntador de la clase pila
    int nelemR;//número de elementos de la cola de revisión
    int nelemA;//número de elementos de la cola de aprobados 
    int nelemP;//número de elementos de la pila de rechazados    
    int total = 0;//total de artículos
    int tec = 0;//total tecnología
    int sal= 0;//total salud

    public CabecerasIII(Cola Cola, Pila Pila, int nelemR, int nelemA, int nelemP) {
        this.Cola = Cola;
        this.Pila = Pila;
        this.nelemR = nelemR;
        this.nelemA = nelemA;
        this.nelemP = nelemP;
    }

    public CabecerasIII() {
    }
    Scanner sc = new Scanner(System.in);
    public void crear (){
        int  cod;
        try{
        System.out.println("Ingrese el código que desea colocarle al artículo");
        cod = sc.nextInt();
        if (Cola.chequeo(Cola.ColaR,cod,Cola.ColaR.codigo,false) == false){
            Cola.encolar(Cola.UltimoR,nelemR, total, cod);
        }else{
            System.out.println("Error, ya existe un archivo con ese código");
        }
        }catch (Exception e){            
        }
    }//Crea nuevos artículos
    public void revision(){
        int opc = 99;
        System.out.println("Cedula del autor:");
        System.out.println(Cola.ColaR.cedula);
        System.out.println("Nombre del autor:");
        System.out.println(Cola.ColaR.nombre);
        System.out.println("Apellido del autor:");
        System.out.println(Cola.ColaR.apellido);
        System.out.println("Categoría del artículo (s: salud; t: tecnología)");
        System.out.println(Cola.ColaR.categoria);
        System.out.println("Organización:");
        System.out.println(Cola.ColaR.organizacion);
        System.out.println("Fecha:");
        System.out.print(Cola.ColaR.Dia);
        System.out.print("/");
        System.out.print(Cola.ColaR.Mes);
        System.out.print("/");
        System.out.println(Cola.ColaR.Año);
        System.out.println("Título:");
        System.out.println(Cola.ColaR.titulo);
        System.out.println("Contenido:");
        System.out.println(Cola.ColaR.contenido);
        while (opc != 0 || opc != 1){
            System.out.println("Aprobar artículo: 1");
            System.out.println("Rechazar artículo: 0");
            opc = sc.nextInt();
        }
        if (opc == 0) {
            Pila.apilar(Cola.ColaR, nelemP, tec, sal);
            Cola.desencolar (nelemR, total);            
        }else{
            Cola.encolarA (Cola.ColaR,Cola.UltimoA, nelemA, tec, sal);
            Cola.desencolar (nelemR,total);
        }
    }//Aprueba o rechaza los artículos
    public void mostrar (Trabajos T) {        
        System.out.println("Cedula Del Autor");
        System.out.println(T.cedula);
        System.out.println("Nombre Del Autor");
        System.out.println(T.nombre);
        System.out.println("Apellido Del Autor");
        System.out.println(T.apellido);
        System.out.println("Organización");
        System.out.println(T.organizacion);
        System.out.println("Categoría");
        System.out.println(T.categoria);
        System.out.println("Titulo");
        System.out.println(T.titulo);
        System.out.println("Fecha");
        System.out.print(T.Dia);
        System.out.print("/");
        System.out.print(T.Mes);
        System.out.println("/");
        System.out.println(T.Año);
    }
    public void revisarR () {//Muestra los artículos para su revisión
        int aux;    
        aux = Cola.ColaR.codigo;
        mostrar(Cola.ColaR);
        Cola.encolarR(Cola.ColaR, Cola.UltimoR);
        while ((aux != Cola.ColaR.codigo)){
            mostrar(Cola.ColaR);
            Cola.encolarR(Cola.ColaR, Cola.UltimoR);
        }
    }
    public void revisarA () {
        int aux;
        String opc;
        aux = Cola.ColaA.codigo;
        mostrar (Cola.ColaA);
        System.out.println("¿Desea ver el contenido del artículo? ingrese 1 para sí, ingrese otro valor para decir que no.");
        opc = sc.nextLine();
        if(opc.equals("1")){
            System.out.println(Cola.ColaA.contenido);
        }
        Cola.ENCOLARA(Cola.ColaA,Cola.UltimoA);
        while (Cola.ColaA.codigo!=aux){
            mostrar(Cola.ColaA);
            System.out.println("¿Desea ver el contenido del artículo? ingrese 1 para sí, ingrese otro valor para decir que no.");
            opc = sc.nextLine();
        if(opc.equals("1")){
            System.out.println(Cola.ColaA.contenido);
        }
        Cola.ENCOLARA(Cola.ColaA, Cola.UltimoA);
        }
    }
    public void total (){
        System.out.println("Cantidad de artículos revisados:");
        System.out.println(nelemR);
        System.out.println("Cantidad de artículos aprobados:");
        System.out.println(nelemA);
        System.out.println("Cantidad de artículos rechazados:");
        System.out.println(nelemP);
        System.out.println("Cantidad de artículos sobre teconología:");
        System.out.println(tec);
        System.out.println("Cantidad de artículos sobre salud:");
        System.out.println(sal);
        System.out.println("Cantidad total de artículos:");
        System.out.println(total);
    }
    public void listadoAS (){
        int aux;
        aux = Cola.ColaA.codigo;
        if (Cola.ColaA.categoria.equals("s")){
            System.out.println(Cola.ColaA.titulo);
        }
        Cola.ENCOLARA(Cola.ColaA, Cola.UltimoA);
        while (Cola.ColaA.codigo!=aux){
            if (Cola.ColaA.categoria.equals("s")){
                System.out.println(Cola.ColaA.titulo);
        }
        Cola.ENCOLARA(Cola.ColaA, Cola.UltimoA); 
        }
    }
    public void listadoAT(){
        int aux;
        aux = Cola.ColaA.codigo;
        if (Cola.ColaA.categoria.equals("t")){
            System.out.println(Cola.ColaA.titulo);
        }
        Cola.ENCOLARA(Cola.ColaA, Cola.UltimoA);
        while (Cola.ColaA.codigo!=aux){
            if (Cola.ColaA.categoria.equals("t")){
                System.out.println(Cola.ColaA.titulo);
        }
        Cola.ENCOLARA(Cola.ColaA, Cola.UltimoA); 
        }
    }
    public void buscar (Trabajos T, int cod, int inicio, boolean aux) {
            if (inicio == Cola.ColaA.codigo) {//Si estamos en el primero
                if (aux == false){//si es la primera vez que estamos en el primero                
                    if (cod == Cola.ColaA.codigo){//si el primero es el que queremos ingresar
                        mostrar(Cola.ColaA);
                    }else{//sino
                        aux =true;//Marcamos que ya pasamos por el primero
                        Cola.ENCOLARA(Cola.ColaA, Cola.UltimoA);//Colocamos el trabajo al final de la cola
                        buscar(Cola.ColaA, cod, inicio, aux);//Llamamos de nuevo al método
                    }
                }else{//si ya pasamos antes por acá, quiere decir que ya la recorrimos y no lo encontramos
                    System.out.println("Artículo no encontrado");
                }
            }else{//sino
                if (cod == Cola.ColaA.codigo){
                    mostrar(Cola.ColaA);
                    while (Cola.ColaA.codigo != inicio) {
                        Cola.ENCOLARA(Cola.ColaA,Cola.UltimoA);
                    }
                }else{
                    Cola.ENCOLARA(Cola.ColaA, Cola.UltimoA);
                    buscar (Cola.ColaA, cod, inicio, aux);
                }
            }
    }
    public void revisarP (Pila P){
        Pila aux = null;
        aux.Pila=null;
        String opc="";
        while (P!=null){
            mostrar(P.Pila);
            System.out.println("Desea ver el contenido? ingrese 1 si lo desea, ingrese cualquier otra cosa si no lo desea");
            opc = sc.nextLine();
            if (opc.equals("1")){
                System.out.println(P.Pila.contenido);
            }
           Pila.mover(aux.Pila, P.Pila);
        }
        while (aux!=null){
            aux.mover(P.Pila, aux.Pila);
        }
    }
}
    