package org.yourorghere;

import javax.media.opengl.glu.*;
import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
/**
 * Carro.java <BR>
 * author: Cassiano
 */
public class Carro implements GLEventListener , KeyListener, MouseListener
{  
    private int xf=10,yf=10;
    private float r=0.69f,g=0.88f,b=0.9f;
    private float rf=0,gf=0,bf=0;
    private float cx1=70f,cy1=-90,cx2=70f,cy2=-60,cx3=40f, cy3=-60, cx4=40f, cy4=-90;
   
    
    int raio_s= 10;
    float px,py,raio,calx,caly;
    int x; 
    public void init(GLAutoDrawable drawable) 
    {
        GL gl = drawable.getGL();
        gl.setSwapInterval(1);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glOrtho(-100, 100, -100, 100, -100, 100);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        drawable.addKeyListener((KeyListener) this); 
        drawable.addMouseListener((MouseListener) this); 
    }
    
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void display(GLAutoDrawable drawable) 
    {
        GLU glu; 
        GL gl; 
        gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        gl.glBegin(GL.GL_QUADS);// fundo
            gl.glColor3f(0.6f, 0.8f, 0.2f);    
            gl.glVertex2i(-100,0);  
            gl.glVertex2i(100,0);   
            gl.glVertex2i(100, -100);  
            gl.glVertex2i(-100,-100); 
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); // cel
            gl.glColor3f(0.69f, 0.88f, 0.9f);  
            gl.glVertex2i(100, 0);          
            gl.glVertex2i(-100, 100);  
            gl.glVertex2i(-100,0);   
            gl.glVertex2i(100, 100);  
            
            
        gl.glEnd();
        gl.glBegin(GL.GL_TRIANGLE_FAN);// SOL 
        gl.glColor3f(255f, 255f, 0f);    
            px=0f;
            x=255;
            py=85f;
            calx=px;
            caly=py;
            gl.glVertex2f(calx,caly);
            for(double i=-1; i<20; i++)
            {
                calx=(float) (raio_s*cos(i));
                calx=calx+px;
                caly=(float) (raio_s*sin(i));
                caly=caly+py;
                gl.glColor3i(x,255 ,0 );
                gl.glVertex2f(calx,caly);
                x--;
            }
        gl.glEnd();
       
        gl.glBegin(GL.GL_POLYGON); //montanha fundo
            gl.glColor3f(0.85f, 0.65f, 0.13f); 
            gl.glVertex2i(-100,0);   
            gl.glVertex2i(-100,45);  
            gl.glVertex2i(-80,20);
            gl.glVertex2i(-60,60);
            gl.glVertex2i(-40,60);
            gl.glVertex2i(-20,60);
            gl.glVertex2i(0,35);
            gl.glVertex2i(20,40);
            gl.glVertex2i(40,60);
            gl.glVertex2i(60,65);
            gl.glVertex2i(80,60);
            gl.glVertex2i(100,45);            
            gl.glVertex2i(100,0);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON); // montanha frente
            gl.glColor3f(0.139f,0.69f, 0.19f);
            gl.glVertex2i(-100,0);   
            gl.glVertex2i(-100,25);  
            gl.glVertex2i(-90,30);
            gl.glVertex2i(-70,45);
            gl.glVertex2i(-50,30);
            gl.glVertex2i(-10,35);
            gl.glVertex2i(0,25);
            gl.glVertex2i(10,15);
            gl.glVertex2i(30,60);
            gl.glVertex2i(50,55);
            gl.glVertex2i(90,35);
            gl.glVertex2i(100,45);            
            gl.glVertex2i(100,0);
        gl.glEnd();        
        gl.glBegin(GL.GL_QUADS); // estrada
            gl.glColor3f(0f, 0f,0f);    
            gl.glVertex2i(-100,-65);  
            gl.glVertex2i(-100,-15);   
            gl.glVertex2i(100,-15);  
            gl.glVertex2i(100,-65); 
        gl.glEnd();
        gl.glBegin(GL.GL_QUADS);// poste da placa
            gl.glColor3f(1f, 1f, 1f);    
            gl.glVertex2i(-85,-70);  
            gl.glVertex2i(-85,-20);   
            gl.glVertex2i(-87,-20);  
            gl.glVertex2i(-87,-70); 
        gl.glEnd();
        gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(1f, 0f, 0f);
            gl.glVertex2i(-95,-22);
            gl.glVertex2i(-75,-22);
            gl.glVertex2i(-85,-2);                   
        gl.glEnd();
        gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3f(1f, 1f, 1f);
            gl.glVertex2i(-93,-20);
            gl.glVertex2i(-78,-20);
            gl.glVertex2i(-85,-4);                   
        gl.glEnd();
        gl.glBegin(GL.GL_TRIANGLES); // luz caminhao
            gl.glColor3f(rf, gf, bf);
            gl.glVertex2i(-71,-36);
            gl.glVertex2i(-84,-23);
            gl.glVertex2i(-84,-50);                   
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); // chassi caminhao
            gl.glColor3f(105f, 105f, 105f);    
            gl.glVertex2i(-70,-40);  
            gl.glVertex2i(-70,-45);  
            gl.glVertex2i(50,-45);   
            gl.glVertex2i(50,-40);  
        gl.glEnd();
        gl.glBegin(GL.GL_QUADS);// Cabine
            gl.glColor3f(255f, 255f, 0f);    
            gl.glVertex2i(-70,-40);  
            gl.glVertex2i(-70,5);   
            gl.glVertex2i(-40,5);  
            gl.glVertex2i(-40,-40); 
        gl.glEnd();
        gl.glBegin(GL.GL_LINE_LOOP); //borda janela     
            gl.glColor3f(0f, 0f, 0.9f);  
            gl.glVertex2i(-69,-11);
            gl.glVertex2i(-69,4);            
            gl.glVertex2i(-49,4);
            gl.glVertex2i(-49,-11);
        gl.glEnd();
        gl.glBegin(GL.GL_LINES); // detalhes cabine
            gl.glColor3f(0f, 0f, 0.9f); 
            gl.glVertex2i(-70,-12);
            gl.glVertex2i(-40,-12);            
            gl.glVertex2i(-70,-13);
            gl.glVertex2i(-40,-13);
            gl.glVertex2i(-69,-13);
            gl.glVertex2i(-69,-35);            
            gl.glVertex2i(-69,-35);
            gl.glVertex2i(-50,-35);
            gl.glVertex2i(-50,-35);            
            gl.glVertex2i(-50,-13);
        gl.glEnd(); 
                
        gl.glPointSize(10); // maçanetas e farois
        gl.glColor3f(255f, 0f, 0f);
        gl.glBegin(GL.GL_POINTS);
            gl.glVertex2i(50,-45);
            
        gl.glColor3f(0.0f, 0.0f, 0.9f);
            gl.glVertex2i(-71,-30);
            gl.glVertex2i(-71,-36);         
            gl.glVertex2i(-50,-14);              
        gl.glEnd();
        gl.glBegin(GL.GL_QUAD_STRIP);// carroceria
            gl.glColor3f(255f, 255f, 0f);    
            gl.glVertex2i(-38,-40);  
            gl.glVertex2i(-38,-20);             
            gl.glVertex2i(-10,-40);
            gl.glVertex2i(-10,-20);             
            gl.glVertex2i(0,-40);
            gl.glVertex2i(0,-20);            
            gl.glVertex2i(10,-40);
            gl.glVertex2i(10,-20);           
            gl.glVertex2i(30,-40);
            gl.glVertex2i(30,-20);        
            gl.glVertex2i(60,-40);
            gl.glVertex2i(60,-20);
        gl.glEnd();
                
        gl.glBegin(GL.GL_LINE_STRIP);
            gl.glColor3f(0.0f, 0.0f, 0.0f);// linhas da carroceria
            gl.glVertex2i(-38,-24);            
            gl.glVertex2i(60,-24); 
            gl.glVertex2i(60,-27);              
            gl.glVertex2i(-38,-27); 
            gl.glVertex2i(60,-30);            
            gl.glVertex2i(-38,-30);          
            gl.glVertex2i(-38,-35);     
            gl.glVertex2i(60,-35);  
        gl.glEnd();
        
        
        gl.glPointSize(9);// roda traseira
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glBegin(GL.GL_POINTS); 
            raio=8f;
            px=30f;
            py=-45f;
            calx=px;
            caly=py;
            gl.glVertex2f(calx,caly);
            for(double i=-10; i<260; i++)
            {
                calx=(float) (raio*cos(i));
                calx=calx+px;
                caly=(float) (raio*sin(i));
                caly=caly+py;
                gl.glVertex2f(calx,caly); 
            }
        gl.glEnd();
        gl.glPointSize(9); // roda do traseira
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glBegin(GL.GL_POINTS); 
            raio=8f;
            px=10f;
            py=-45f;
            calx=px;
            caly=py;
            gl.glVertex2f(calx,caly);
            for(double i=-10; i<260; i++)
            {
                calx=(float) (raio*cos(i));
                calx=calx+px;
                caly=(float) (raio*sin(i));
                caly=caly+py;
                gl.glVertex2f(calx,caly); 
            }
        gl.glEnd();  
        gl.glPointSize(9); // roda do dianteira
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glBegin(GL.GL_POINTS); 
            raio=8f;
            px=-50f;
            py=-45f;
            calx=px;
            caly=py;
            gl.glVertex2f(calx,caly);
            for(double i=-10; i<260; i++)
            {
                calx=(float) (raio*cos(i));
                calx=calx+px;
                caly=(float) (raio*sin(i));
                caly=caly+py;
                gl.glVertex2f(calx,caly); 
            }
        gl.glEnd();
        gl.glBegin(GL.GL_TRIANGLE_STRIP); //janela
            gl.glColor3f(0.69f, 0.88f, 0.9f);                        
            gl.glVertex2i(-68,-10);
            gl.glVertex2i(-68,3);
            gl.glVertex2i(-50,3);      
            gl.glVertex2i(-50,-10);                                
            gl.glVertex2i(-68,-10);
            
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); // caixa      
            gl.glColor3f(r, g, b);  
            gl.glVertex2f(cx1,cy1);
            gl.glVertex2f(cx2,cy2);
            gl.glVertex2f(cx3,cy3);
            gl.glVertex2f(cx4,cy4);   
        gl.glEnd();
        gl.glFlush();
    }
        public void keyPressed(KeyEvent e){
        //Controle dos eventos de teclado
    	System.out.println("Evento do teclado");
	switch(e.getKeyChar())
	{
//            case GLUT_KEY_UP:
//            break; 
            case '1':
                r=128;
                g=0;
                b=0;
                break;
            case '2':            
                r=0.139f;
                g=0.69f;
                b=0.19f;
                break;
            case '3':
                r=255;
                g=255;
                b=0;
                break;
            case '4':
                r=0;
                g=0;
                b=1;
                break;
            case '5':
                r=250;
                g=128;
                b=114;
                break;
            case '6':
                rf=135;
                gf=206;
                bf=250;
                break;
            case '7':
                rf=0;
                gf=0;
                bf=0;
                break;
            case '8':
                rf=135;
                gf=206;
                bf=250;
                break;
            
            case 'i': //pra cima
                cx1=cx1;  cy1=cy1+1;
                cx2=cx2;  cy2=cy2+1;
                cx3=cx3;  cy3=cy3+1;
                cx4=cx4;  cy4=cy4+1;
                break; 
            case 'l': //pra esquerda
                cx1=cx1+1;  cy1=cy1;
                cx2=cx2+1;  cy2=cy2;
                cx3=cx3+1;  cy3=cy3;
                cx4=cx4+1;  cy4=cy4;
                break; 
            case 'j': //pra direita
                cx1=cx1-1;  cy1=cy1;
                cx2=cx2-1;  cy2=cy2;
                cx3=cx3-1;  cy3=cy3;
                cx4=cx4-1;  cy4=cy4;
                break;
            case 'k': //pra baixo
                cx1=cx1;  cy1=cy1-1;
                cx2=cx2;  cy2=cy2-1;
                cx3=cx3;  cy3=cy3-1;
                cx4=cx4;  cy4=cy4-1;     
                break;
        }
                switch(e.getKeyCode()) 
        {
//            case KeyEvent.VK_LEFT:   //seta esquerda pressionada
//	     break;
//            case KeyEvent.VK_RIGHT:   //seta direita pressionada
//	     break;
             case KeyEvent.VK_UP:   //seta esquerda pressionada
                raio_s=raio_s*2;
	     break;
            case KeyEvent.VK_DOWN:   //seta direita pressionada
                if(raio_s>=2.5f)
                {
                    raio_s=raio_s/2;
                }
	     break;                        
        }        
    }
    public void keyReleased(KeyEvent e){}
    
    
    public void keyTyped(KeyEvent e){}
    
    public void mousePressed(MouseEvent e) 
    {  
    	System.out.println("Evento do mouse");
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                xf = xf + 5;
                yf = yf + 5;
               break;
            case MouseEvent.BUTTON3:
                xf = xf - 5;
                yf = yf - 5;
               break;
        }
    }
    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
    
    public void mouseClicked(MouseEvent e) {}


    public static void main(String[] args) 
    {
        Frame frame = new Frame("Carro");
        GLCanvas canvas = new GLCanvas(); 
        Carro tc = new Carro();
        canvas.addGLEventListener(tc);
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                new Thread(new Runnable() 
                {
                    public void run() 
                    {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        }
        );
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }
}
