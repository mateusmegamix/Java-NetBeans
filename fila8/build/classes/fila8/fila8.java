
package fila8;
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
        return Dado;
    }
    
    Elemento RetProx()
    {
        return Prox;
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
        return(QtdElementos);
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
        QtdElementos--;
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
    
    public Object Frente()
    {
        Object o=null;
        if(!EstaVazia())
        {
            o=primeiro.RetDado();
        }
        return o;
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
public class fila8 {
    //Faça uma função que receba três filas, duas já preenchidas e preencha a última com os
    //valores das duas primeiras em ordem crescente.

    public static void Ordem(Fila f1,Fila f2)
    {
        Fila f3=new Fila();
        int v[]=new int [10];
        int v1[]=new int [10];
        int v2[]=new int [20];
        int a=10,auxiliar;
        Object e,e1;
         for(int i=0;i<10;i++)
        {
            e=f1.Retira();
            v[i]=(int)e;
            e1=f2.Retira();
            v1[i]=(int)e1;
        }
         for(int i=0;i<10;i++)
         {
             v2[i]=v[i];
             v2[a]=v1[i];
             a++;
         }
          for(int i=0;i<20;i++)
          {
              for(int j=i+1;j<20;j++)
              {
                  if(v2[i]>v2[j])
                  {
                    auxiliar=v2[i];
                    v2[i]=v2[j];
                    v2[j]=auxiliar;
                  }
              }
          }
        for(int i=0;i<10;i++)
         {
             f1.Insere(v[i]);
             f2.Insere(v1[i]);
         }
        for(int i=0;i<20;i++)
         {
             f3.Insere(v2[i]);
         }
        System.out.println("Fila 1:");
        f1.Mostra();
        System.out.println("Fila 2:");
        f2.Mostra();
        System.out.println("Fila 3 com os Elementos das duas primeiras filas em ordem crescente:");
        f3.Mostra();
    }
    public static void main(String[] args) {
       
        Fila f1=new Fila();
        Fila f2=new Fila();
        Scanner x=new Scanner(System.in);
        int numeros;
        System.out.println("Digite 10 números para serem inseridos na primeira fila:");
        for(int i=0;i<10;i++)
        {
            numeros=x.nextInt();
            f1.Insere(numeros);
        }
        
        System.out.println("Digite 10 números para serem inseridos na segunda fila:");
        for(int i=0;i<10;i++)
        {
            numeros=x.nextInt();
            f2.Insere(numeros);
        }
        Ordem(f1,f2);
        
    }
    
}
