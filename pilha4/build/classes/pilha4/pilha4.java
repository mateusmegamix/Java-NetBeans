package pilha4;
import java.util.Scanner;
import javax.swing.*;

class Pilha{
    int inicio;
    int fim;
    int tamanho;
    int qtdeElementos;
    Object p[];
public Pilha(){ 
    inicio = fim = -1;
    tamanho = 100;
    p = new Object[tamanho];
    qtdeElementos = 0;
}
public boolean estaVazia(){
    if (qtdeElementos == 0){
        return true; }
    return false;
}
public boolean estaCheia(){
    if (qtdeElementos == tamanho){
        return true; }
    return false;
}
public int tamanho(){
    return(qtdeElementos);
}
public void empilha(Object e){
    if (! estaCheia()){
        if (inicio == -1){
            inicio = 0; }
    fim++;
    p[fim] = e;
    qtdeElementos++; }
}
public void mostrar(){
    String elementos = "";
    for (int i = fim; i>=0; i--) 
    {
        elementos += p[i]+" - ";
        System.out.println(elementos);
    }
}
public Object desempilhaN(int N){
    Object e = null;
    for(int a=0; a<N; a++){
        if (! estaVazia()){
            fim--;
            qtdeElementos--;
            System.out.println(p[fim+1]);
        }
    }
    return (e);
}
public Object topo()
{
    return (p[fim]);
}
}

public class pilha4 {

    public static void main(String[] args) {
    //Faça um programa que crie uma pilha P e na sequencia exiba o seguinte menu:
    //1. Empilhar
    //2. Desempilhar
    //3. Exibir Elemento do Topo
    //4. Exibir a Pilha
    //5. Esvaziar a Pilha
    //6. Encerrar o Programa
        Pilha p = new Pilha();
        Scanner x = new Scanner (System.in);
        int op=0,r;        
        while (op!=6)
        {
            System.out.println("1-empilhar \n "
            + "2-desempilha \n "
            + "3-exibir elemento do topo \n "
            + "4-exibir a pilha \n "
            + "5-esvaziar \n "
            + "6- encerrar o programa\n");
            op=x.nextInt();
            switch (op)
            {
                case 1:
                    System.out.println("valor a ser empilhado");
                    r=x.nextInt();
                    p.empilha(r);
                    break;
            
                case 2:
                    System.out.println("valor a ser desempilhado");
                    r=x.nextInt();
                    p.desempilhaN(r);
                    break;
            
                case 3:
                    System.out.println(p.topo());
                    break;
            
                case 4:
                    p.mostrar();
                    break;
            
                case 5:
                    while(p.tamanho()!=0)
                    {
                    p.desempilhaN(100);
                    }
                    break;
                 
                case 6:
                    break;
            
                default:
                    System.out.println("Invalido");
                    break;
            }
        }
    }    
}
