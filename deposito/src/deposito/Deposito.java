package deposito;
import java.util.Scanner;

class Elemento {
    Object dado;
    Elemento prox;

    public Elemento() {
        dado = null;
        prox = null;
    }
    public Elemento(Object o, Elemento e) {
        dado = o;
        prox = e;
    }
    Object retDado() {
        return dado;
    }
    Elemento retProx() {
        return prox;
    }
    void posDado(Object novoDado) {
        dado = novoDado;
    }
    void posProx(Elemento novoElemento) {
        prox = novoElemento;
    }
}

class Pilha{
    Elemento topo;
    int qtdeElementos;

    public Pilha(){
        topo = null;
        qtdeElementos = 0;
    }
    public boolean estaVazia(){
        if (topo == null){
        return true;}
        return false;
    }
    public int tamanho() {
        return(qtdeElementos);
    }
    public void empilha(Object o){
        Elemento el = new Elemento(o,topo);
        topo = el;
        qtdeElementos++;
    }
    public Object topo() {
        Object o = null;
        if (! estaVazia() ) {
        o = topo.retDado();}
        return(o);
    }
    public Object desempilha(){
        Object o = null;
        if (! estaVazia() ){
        o = topo.retDado();
        topo = topo.retProx();
        qtdeElementos --;}
        return(o);
    }
    public void mostrar(){
        String elementos = "";
        Elemento el = new Elemento();
        el = topo;
        while(el != null) {
        elementos += el.retDado() + " - ";
        el = el.retProx();}
        System.out.println(elementos);
    }    
}     //---------------------------------------------------\\
public class Deposito {
    
    static Pilha P = new Pilha();
    
    public static void ChegaNoDeposito(float y){
        float a,b;
        Pilha a1 = new Pilha();              
        do{
            a=(float)P.topo();
            
            if(y>a){                
               a = (float) P.desempilha();               
               a1.empilha(a);               
            }            
        }while(y>a && !P.estaVazia()); 
        P.empilha(y);
        do{
            b=(float) a1.desempilha();            
            P.empilha(b);
        }while (! a1.estaVazia());
    }
    public static void RetiraDoDeposito(float y){
        float a,b;
        Pilha a1 = new Pilha();              
        do{
            a=(float)P.topo();
            if(a<y){
               a = (float) P.desempilha();
               a1.empilha(a);               
            }            
        }while(a<y); 
        y=(float) P.desempilha();
        do{
            b=(float) a1.desempilha();
            P.empilha(b);
        }while (! a1.estaVazia());
        
    }
    public static void RetiraPosicao(int y){
        int a;
        float b,c;
        Pilha a1 = new Pilha();              
        do{
            a=P.qtdeElementos;
            if(y<a){                
               c =(float)P.desempilha();               
               a1.empilha(c);
            }            
        }while(y<a);
        
        c=(float) P.desempilha();

        do{
            b=(float) a1.desempilha();
            P.empilha(b);
        }while (! a1.estaVazia());        
    }
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);   
       
        int op = 0;
        while (op!=5){
            System.out.println("(1) Chega no Depósito.");
            System.out.println("(2) Retira do Depósito.");
            System.out.println("(3) Retira Posição.");
            System.out.println("(4) Mostrar Pilha.");
            System.out.println("(5) Sair.");
            op = x.nextInt();
           switch(op){
               case 1:
                   System.out.println("Informe o peso da caixa:\n");
                   float peso=x.nextFloat();
                   if (P.topo == null){
                        P.empilha(peso);}                       
                       else{
                            ChegaNoDeposito(peso);}                                     
                   break;
               case 2:
                   System.out.println("Informe o peso da caixa a ser retirada:\n");
                   float pesor=x.nextFloat();
                   if(P.qtdeElementos == 0){
                        System.out.println("Pilha Vazia."); }                       
                       else{
                            RetiraDoDeposito(pesor);}                                                         
                   break;
               case 3:
                   System.out.println("Informe a posição da caixa a ser retirada:\n");
                   int ps=x.nextInt();
                   if(P.qtdeElementos == 0){
                        System.out.println("Pilha Vazia."); }                       
                       else{
                            RetiraPosicao(ps);}                                                         
                   break;          
               case 4:
                   P.mostrar();
                   break;
               case 5:
                   System.out.println("Programa Encerrado.");
                   break;
               default:
                   System.out.println("Opção Inválida");
                   break;                  
           } 
        }
    }   
}
