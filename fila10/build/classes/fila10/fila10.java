
package fila10;
import java.util.Scanner;
class Elemento
{
    Object Dado;
    Elemento Prox;
    
    public Elemento()
    {
        Dado=null;
        Prox=null;
    }
    
    public Elemento(Object o,Elemento e)
    {
        Dado=o;
        Prox=e;
    }
    
    Object RetDado()
    {
        return (Dado);
    }
    
    Elemento RetProx()
    {
        return (Prox);
    }
    
    void PosDado(Object NovoDado)
    {
        Dado=NovoDado;
    }
    
    void PosElemento(Elemento NovoElemento)
    {
        Prox=NovoElemento;
    }
}

class Fila
{
    Elemento primeiro,ultimo;
    int QtdElementos;
    
    public Fila()
    {
        primeiro=null;
        ultimo=null;
        QtdElementos=0;
    }
    
    public boolean EstaVazia()
    {
        if(primeiro==null)
        {
            return true;
        }
        return false;
    }
    
    public int Tamanho()
    {
        return (QtdElementos);
    }
    
    public Object Frente()
    {
        Object o=null;
        if(!EstaVazia())
        {
            o=primeiro.RetDado();
        }
        return (o);
    }
    
    public void Insere(Object o)
    {
        Elemento el=new Elemento(o,null);
        if(EstaVazia())
        {
            primeiro=el;
        }
        else
        {
            ultimo.PosElemento(el);
        }
        ultimo=el;
        QtdElementos++;
    }
    
    public Object Retira()
    {
        Object e=null;
        if(!EstaVazia())
        {
            e=primeiro.RetDado();
            primeiro=primeiro.RetProx();
            QtdElementos--;
            if(QtdElementos==0)
            {
                ultimo=null;
            }
        }
        return (e);
    }
    
    public void Mostra()
    {
        String Elementos="";
        Elemento el=new Elemento();
        el=primeiro;
        while(el!=null)
        {
            Elementos+=el.RetDado()+" - ";
            el=el.RetProx();
        }
        System.out.println(Elementos);
    }
}
public class fila10 {

    public static void main(String[] args) {
        //Uma fila dupla (chamada de deque) permite inserção e remoção em qualquer das duas
        //extremidades da fila. Implemente uma fila dupla e codifique as funções de manipulação
        //da estrutura: RemDir (remove elemento da ponta direita), RemEsq (remove elemento da
        //ponta esquerda), InsDir (insere elemento na ponta direita), InsEsq (insere elemento na
        //ponta esquerda).

        int escolha, numero,TamanhoEsquerda=0,TamanhoDireita=0,TamanhoTotal,i;
        Fila f=new Fila();
        Object e;
        Scanner x=new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1- Remove da Direita");
        System.out.println("2- Remove da Esquerda");
        System.out.println("3- Insere na Direita");
        System.out.println("4- Insere na Esquerda");
        System.out.println("5- Mostrar a Fila");
        System.out.println("6- Encerra o Programa");
        escolha=x.nextInt();
        while(escolha>=1 && escolha<=5)
        {
            if(escolha==1)
            {
           
                if(TamanhoEsquerda>0 && TamanhoDireita>0)
                {
                    TamanhoTotal=f.Tamanho();
                    int v[]=new int [TamanhoTotal];
                  for(i=0;i<TamanhoEsquerda;i++)
                  {
                      e=f.Retira();
                      v[i]=(int)e;
                  }
                  e=f.Retira();
                  System.out.println("O elemento retirado da direita foi o número "+e);
                  TamanhoDireita--;
                  TamanhoTotal=f.Tamanho();
                  for(int a=0;a<TamanhoTotal;a++)
                  {
                      e=f.Retira();
                      v[i]=(int)e;
                      i++;
                  }
                  int tamanho=v.length;
                    System.out.println("Tamanho "+tamanho);
                    for(int a=0;a<tamanho-1;a++)
                    {
                        f.Insere(v[a]);
                    }
                }
            
            }
            if(escolha==2)
            {
                if(TamanhoEsquerda==0)
                {
                    System.out.println("Não se pode remover um elemento da esquerda, pois o lado esquerdo da fila está vazio!");
                }
              
                else
                {
                    e=f.Retira();
                    System.out.println("O elemento retirado da fila e o número "+e);
                    TamanhoEsquerda--;
                }
                
            }
            
            if(escolha==3)
            {
                if(TamanhoEsquerda>0)
                {
                    System.out.println("Digite um número para ser inserido a direita da fila:");
                    numero=x.nextInt();
                    f.Insere(numero);
                    TamanhoDireita++;
                }
                else
                {
                    System.out.println("Não se pode inserir um elemento a direita pois o lado esquerdo está vazia!");
                }
            }
            
            if(escolha==4)
            {
                 if(TamanhoEsquerda==0)
                {
                    System.out.println("Digite o número que deseja inserir na fila:");
                    numero=x.nextInt();
                    f.Insere(numero);
                    TamanhoEsquerda++;
                }
                else
                {
                    int continuacao;
                    TamanhoTotal=f.Tamanho();
                    int v[]=new int [TamanhoTotal];
                    for(i=0;i<TamanhoTotal;i++)
                    {
                        e=f.Retira();
                        v[i]=(int)e;
                    }
                    for(i=0;i<TamanhoEsquerda;i++)
                    {
                        f.Insere(v[i]);
                    }
                    continuacao=i+1;
                    System.out.println("Digite o número que deseja inserir na fila:");
                    numero=x.nextInt();
                    f.Insere(numero);
                    TamanhoEsquerda++;
                     for(int a=0;a<TamanhoDireita;a++)
                    {
                        f.Insere(v[i]);
                        i++;
                    }
                    
                }
               
            }
            
        if(escolha==5)
        {
            TamanhoTotal=f.Tamanho();
            if(TamanhoTotal==0)
            {
                System.out.println("Fila Vazia!");
            }
            else
            {
                System.out.println("Fila:");
                f.Mostra();
            }
        }
        System.out.println("Menu:");
        System.out.println("1- Remove da Direita");
        System.out.println("2- Remove da Esquerda");
        System.out.println("3- Insere na Direita");
        System.out.println("4- Insere na Esquerda");
        System.out.println("5- Mostrar a fila");
        System.out.println("6- Encerra o Programa");
        escolha=x.nextInt();
        }
        System.out.println("Fim!");
    }
 
}
