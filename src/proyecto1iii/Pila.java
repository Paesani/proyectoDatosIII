/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto1iii;

/**
 *
 * @author Roger
 */
public class Pila {
    Trabajos Pila;    

    public Pila() {
    }

    public Pila(Trabajos Pila) {
        this.Pila = Pila;
    }
    
        public void apilar (Trabajos T, int nelemP, int tec, int sal){
        if (Pila == null) {
            Pila = T;
            T.sig=null;
            nelemP = 1;
            if (T.categoria.equals("t")) {
                tec= tec + 1;
            }else{
                sal= sal + 1;
            }
        }else{
            T.sig=Pila;
            Pila=T;
            nelemP = nelemP + 1;
            if (T.categoria.equals("t")) {
                tec = tec + 1;
            }else{
                sal = sal + 1;
            }
        }
    }
        public void desapilar (){
           Trabajos aux=null;
           aux=Pila;
           Pila=Pila.sig;
           aux=null;           
        }
        public void mover (Trabajos aux, Trabajos P){
            Trabajos auxiliar;
            auxiliar = P;
            P=P.sig;
            auxiliar.sig=aux;
            aux=auxiliar;
        }
}
