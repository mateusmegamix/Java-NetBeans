
package fila6;
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
public class fila6 {
    //Implemente uma função que inverta a ordem dos elementos de uma Fila.
    
    public static void Inverte(Fila f)
    {
        int v[] = new int [10];
        Object e;
        for(int i=0;i<10;i++)
        {
            e=f.Retira();
            v[i]=(int)e;
        }
        for(int i=10;i>=0;i--)
        {
            f.Insere(v[i]);
        }
    }
    public static void main(String[] args) {
    
        int numeros;
        Fila f = new Fila();
        Scanner x = new Scanner(System.in);
        System.out.println("Digite 10 números para serem inseridos na fila:");
        for(int i=0;i<10;i++)
        {
            numeros = x.nextInt();
            f.Insere(numeros);
        }
        System.out.println("Fila:");
        f.Mostra();
        Inverte(f);
        System.out.println("Fila Invertida:");
        f.Mostra();
    }
    
}
