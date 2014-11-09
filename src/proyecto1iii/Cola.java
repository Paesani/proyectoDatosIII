package proyecto1iii;

/**
 *
 * @author Roger
 */
public class Cola {
    Trabajos ColaR;
    Trabajos ColaA;
    Trabajos UltimoR;
    Trabajos UltimoA;

    public Cola(Trabajos ColaR, Trabajos ColaA, Trabajos UltimoR, Trabajos UltimoA) {
        this.ColaR = ColaR;
        this.ColaA = ColaA;
        this.UltimoR = UltimoR;
        this.UltimoA = UltimoA;
    }

    public Cola() {
    }
            
        public void encolar (Trabajos UltimoR, int nelemR, int total, int cod){//Metodo que crea nuevos artículos en la cola de revisión
        Trabajos nn;
        nn = new Trabajos();
        nn.llenar(cod);
        if (ColaR == null){
            ColaR = nn;
            UltimoR = nn;            
            nelemR = 1;
            total = total + 1;
        }else{
            UltimoR.sig =nn;
            UltimoR = nn;
            nn.codigo = nelemR + 1;
            nelemR = nelemR + 1;            
        }
    }
    public void desencolar(int nelemR, int total){//Metodo que elimina artículos de la cola de revisión
        Trabajos aux;
        if (ColaR == null){
            System.out.println("Error, cola vacía");            
        }else{
        aux = ColaR;
        ColaR = ColaR.sig;
        aux = null;
        nelemR = nelemR - 1;
        total = total - 1;
        }
    }
    public void encolarR (Trabajos T, Trabajos UltimoR){
        ColaR = ColaR.sig;
        T.sig=null;
        UltimoR.sig = T;
        UltimoR=T;
        
    }
    public void ENCOLARA (Trabajos T, Trabajos UltimoA){
        ColaA = ColaA.sig;
        T.sig=null;
        UltimoA.sig = T;
        UltimoA=T;
        
    }
    public void encolarA(Trabajos T, Trabajos UltimoA, int nelemA, int tec, int sal){
        if (ColaA == null) {
            ColaA = T;
            UltimoA = T;
            T.sig= null;
            nelemA= 1; 
            if (T.categoria.equals("t")){
                tec = tec + 1;
            }else{
                sal = sal + 1;
            }
        }else{
            T.sig=null;
            UltimoA.sig =T;
            UltimoA=T;
            if (T.categoria.equals("t")){
                tec = tec + 1;                
            }else{
                sal = sal + 1;
            }
        }
    }
    public boolean chequeo (Trabajos T, int cod, int inicio, boolean aux) {
        if (ColaR != null){//si NO está vacia
            if (inicio == ColaR.codigo) {//Si estamos en el primero
                if (aux == false){//si es la primera vez que estamos en el primero                
                    if (cod == ColaR.codigo){//si el primero es el que queremos ingresar
                        return true;//Sí está presente, no permitimos que se agrege otro
                    }else{//sino
                        aux =true;//Marcamos que ya pasamos por el primero
                        encolarR(ColaR, UltimoR);//Colocamos el trabajo al final de la cola
                        chequeo (ColaR, cod, inicio, aux);//Llamamos de nuevo al método
                    }
                }else{//si ya pasamos antes por acá, quiere decir que ya la recorrimos y no lo encontramos
                    return false;//No está presente, permitimos que se agregue-
                }
            }else{//sino
                if (cod == ColaR.codigo){
                    while (ColaR.codigo != inicio) {
                        encolarR(ColaR,UltimoR);
                    }
                    return true;
                }else{
                    encolarR(ColaR, UltimoR);
                    chequeo (ColaR, cod, inicio, aux);
                }
            }
        }else{
            return false;
        }
        return false;
    }
}