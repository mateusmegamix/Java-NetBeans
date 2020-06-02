
package filas5;
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
public class fila5 {
    //Escreva uma função que verifica se um dado elemento E recebido como parâmetro está
    //presente em uma Fila. Caso o elemento esteja presente indique quantas vezes esse
    //elemento aparece na Fila. Caso contrário, exiba uma mensagem informando que o
    //elemento não está na Fila.
    public static int Existe(int Elemento,Fila f)
    {
        int v[] = new int [10];
        int quantidade = 0;
        Object o;
        for(int i=0;i<10;i++)
        {
            o=f.Retira();
            v[i]=(int)o;
            if((int)o==Elemento)
            {
                quantidade++;
            }
        }
        for(int i=0;i<10;i++)
        {
            f.Insere(v[i]);
        }
        return quantidade;
    }
    public static void main(String[] args) {
                
        Fila f1 = new Fila();
        Scanner x = new Scanner(System.in);
        int numeros,Elemento,retorno;
        System.out.println("Digite 10 elementos para serem inseridos na fila:");
        for(int i=0;i<10;i++)
        {
            numeros = x.nextInt();
            f1.Insere(numeros);
        }
        System.out.println("Digite um número:");
        Elemento = x.nextInt();
        retorno = Existe(Elemento,f1);
        System.out.println("O Elemento aparece "+retorno+" vezes na fila!");
        System.out.println("Fila:");
        f1.Mostra();
    }
    
}

