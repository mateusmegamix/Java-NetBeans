
package filaprova;

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
class Fila{
 Elemento primeiro,ultimo;
 int tam;
 public Fila(){
 primeiro = null;
 ultimo = null;
 tam = 0;
 }
 public boolean estaVazia(){
 if (primeiro == null){
 return true;
 }
 return false;
 }
 public void insere(Object o){
 Elemento el = new Elemento(o,null);
 if(estaVazia())
 primeiro=el;
 else
 ultimo.posProx(el);
 ultimo = el;
 tam++;
 }
 public Object frente(){
 Object o = null;
 if (! estaVazia() ){
 o = primeiro.retDado();
 }
 return(o);
 }
 public Object retira(){
 Object o = null;
 if (! estaVazia() ){
 o = primeiro.retDado();
 primeiro = primeiro.retProx();
 tam --;
 if(tam==0)
 ultimo=null;
 }
 return(o);
 }
 public int tamanho(){
 return(tam);
 }
public void mostrar(){
 String elementos = "";
 Elemento el = new Elemento();
 el = primeiro;
 while(el != null) {
 elementos += el.retDado() + " - ";
 el = el.retProx();
 }
 System.out.println(elementos);
 
 }
}
class aviao {

String Nome;
int Numero;


public aviao (String s, int n){
    Nome = s;
    Numero = n;
}
String RetNome()
{
    return Nome;
}
int RetNumero()
{
    return Numero;
}
        }
public class Filaprova {
    
    public static void Pesquisar(String NomeAviao,Fila b)
    {
        boolean existe=false;
        String nome;
        int tamanho=b.tamanho(), posicao=0;
        aviao o;
        for(int i=0;i<tamanho;i++)
        {
            o=(aviao)b.retira();
            nome=o.RetNome();
            System.out.println(nome);
            System.out.println(NomeAviao);
            if(nome.equals(NomeAviao))
            {
                existe=true;
                posicao=i+1;
                break;
            }
            b.insere(o);
        }
        if(existe==true)
        {
            System.out.println("O Avião existe na posição "+posicao);
        }
        else
        {
            System.out.println("O Avião não existe!");
        }
        existe=false;
    }
  
    public static void main(String[] args) {
        Scanner x = new Scanner (System.in);
        Fila  f1 = new Fila();
        Fila f2 = new Fila();
        
        int e=0,p=0,num,av;
        aviao o;
        int op=0;
        int NumAviao;
        String NomeAviao;
        boolean retorno;
   
        
 while (op!=7)
 {       
        System.out.println("1-Informe a quantidade\n "
                + "2-autorizar decolagem\n "
                + "3-adicionar aviao\n "
                + "4-pesquizar aviao\n "
                + "5-listar aviao\n "
                + "6-Listarprimeiro aviao\n"
                + "7-finalizar \n");
        op = x.nextInt();
        switch(op)
        {
            case 1:{  
           e = f1.tamanho();
           System.out.println("tamanho da fila \n"+e);
           
           break;
            }    
            case 2:{
                if (f1.estaVazia())
              
                {
                    System.out.println("Não tem aviao para decolagem!!! \n");
                }
                else
                
                {
                o=(aviao)f1.retira();
                System.out.println("O aviao "+o.RetNome()+" decolou \n");
                }
            break;
            } 
            case 3:{
             System.out.println("adicionar aviao: \n");
                NomeAviao=x.next();
                System.out.println("Número do Avião: \n");
                NumAviao=x.nextInt();
                aviao aviao=new aviao(NomeAviao,NumAviao);
                f1.insere(aviao);
            break;
            } 
            case 4:{
                System.out.println("Nome do Avião que deseja pesquisar: \n");
                NomeAviao=x.next();
                Pesquisar(NomeAviao,f1);
                
            
            }
            case 5:{
               int tamanho=f1.tamanho();
                
                System.out.println("Lista Aviões: \n");
                for(int i=0;i<tamanho;i++)
                {
                    o=(aviao)f1.retira();
                    System.out.println("Nome: "+o.RetNome()+" Número: "+o.RetNumero());
                    f1.insere(o);
                }
            } 
            case 6:{
                o=(aviao)f1.frente();
                System.out.println("O aviao que esta localizado a frente é o "+o.RetNome());
                break;
            } 
            case 7:{
                System.out.println("Finalizado");
                
            }
        }
    }
 }
}
