
package pilha1;
import java.util.Scanner;
import javax.swing.*;

class Pilha{
        int inicio;
        int fim;
        int tamanho;
        int qtdeElementos;
        int p[];
        
        public Pilha(){
            inicio = fim = -1;
            tamanho = 100;
            p = new int [tamanho];
            qtdeElementos = 0;
        }
        public boolean estaVazia(){
            return qtdeElementos == 0;
        }
        
        public boolean estaCheia(){
            return qtdeElementos == tamanho -1;
            }
        public int tamanho(){
            return(qtdeElementos);
        }
        
        public void empilha(int e){
            if(!estaCheia()){
                if(inicio == -1){
                    inicio = 0;
                }
                fim++;
                p[fim]=e;
                qtdeElementos++;
            }
        }
        public int desempilha(){
            if (!estaVazia()){
                fim--;
                qtdeElementos--;
                return(p[fim+1]);
            
        }
            return 0;
        }
        public void mostrar(){
            String elementos = "";
            for (int i = fim; i >= 0; i--){
                elementos += p[i]+"-";
            }
            System.out.println(elementos);
        }
}

public class Pilha1 {

    public static void main(String[] args) {

        Pilha p = new Pilha();
        Object e;
p.empilha(10);
p.empilha(2);
p.empilha(30);
p.mostrar();
e=p.desempilha();
e=p.desempilha();
p.mostrar();
        
    }
    
}
