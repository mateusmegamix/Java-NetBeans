
package fila7;
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
public class fila7 {
     //Crie uma função que teste se duas Filas são iguais ou não.
    
    public static boolean Iguais(Fila f,Fila f1)
    {
        int v[]=new int [10];
        int v1[]=new int [10];
        int quantidade=0;
        Object e,e1;
         for(int i=0;i<10;i++)
        {
            e = f.Retira();
            v[i] = (int)e;
            e1 = f1.Retira();
            v1[i] = (int)e1;
            if(e==e1)
            {
                quantidade++;
            }
        }
         for(int i=0;i<10;i++)
         {
             f.Insere(v[i]);
             f1.Insere(v1[i]);
         }
         if(quantidade==10)
         {
             return true;
         }
         return false;
        
    }
    public static void main(String[] args) {
       
        Fila f = new Fila();
        Fila f1 = new Fila();
        Scanner x = new Scanner(System.in);
        int numeros;
        boolean retorno;
        System.out.println("Digite 10 números para serem inseridos na primeira fila:");
        for(int i=0;i<10;i++)
        {
            numeros=x.nextInt();
            f.Insere(numeros);
        }
        
        System.out.println("Digite 10 números para serem inseridos na segunda fila:");
        for(int i=0;i<10;i++)
        {
            numeros = x.nextInt();
            f1.Insere(numeros);
        }
        retorno=Iguais(f,f1);
        if(retorno==true)
        {
            System.out.println("As pilhas são Iguais!");
        }
        else
        {
            System.out.println("As pilhas não são iguais!");
        }
        System.out.println("Fila 1:");
        f.Mostra();
        System.out.println("Fila 2:");
        f1.Mostra();
    }
    
}
