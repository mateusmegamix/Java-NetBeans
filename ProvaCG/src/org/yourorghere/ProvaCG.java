package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;



/**
 * MateusCasa.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class ProvaCG implements GLEventListener, KeyListener, MouseListener {

    private int xf=10,yf=10;
    private float vx1=80f,vy1=-90,vx2=80f,vy2=-15,vx3=50f, vy3=-15, vx4=50f, vy4=-90;
    
    private float r=0.69f,g=0.88f,b=0.9f;
    private float rf=0,gf=0,bf=0;
    
    float xl=-30f, yl=-180f; //lua
    
    private float view_w;
    private float view_h;
    
    int raio_s= 10,x;
    float sx,sy,raio,solx,soly;
    
    //função que vai inicializar o sistema
     public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.setSwapInterval(1);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glOrtho(-200, 200, -200, 200, -200, 200);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        drawable.addKeyListener(this); 
        drawable.addMouseListener(this); 
    }
//função que controla mudanças no desenho
public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

//função responsável pelo redimensionamento
public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    view_w = width;
    view_h = height;
}
 //função responsável por fazer o desenho na tela
 public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        gl.glBegin(GL.GL_TRIANGLE_FAN); // Background sol
        gl.glColor3f(255f, 255f, 0f); 
            sx=0f;
            x=255;
            sy=85f;
            solx=sx;
            soly=sy;
            gl.glVertex2f(solx,soly);
            for(double i=-1; i<20; i++)
            {
                solx=(float) (raio_s*cos(i));
                solx=solx+sx;
                soly=(float) (raio_s*sin(i));
                soly=soly+sy;
                gl.glColor3i(x,255 ,0 );
                gl.glVertex2f(solx,soly);
                x--;
            }
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0.0f, 1.0f, 0.0f); // chao
            gl.glVertex2i(-200, 80); //a
            gl.glVertex2i(200, 80); //b
            gl.glVertex2i(200, -200); //d
            gl.glVertex2i(-200, -200); //c
            gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); //Estrada
            gl.glColor3f(0.5f, 0.5f, 0.5f);    
            gl.glVertex2i(-30, 80);  
            gl.glVertex2i(30, 80);     
            gl.glVertex2i(80, -200);  
            gl.glVertex2i(-80, -200); 
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0.55f, 0.27f, 0.07f); // tronco
            gl.glVertex2i(110, -40); //l
            gl.glVertex2i(130, -40); //m
            gl.glVertex2i(130, -90); //n
            gl.glVertex2i(110, -90); //o
            gl.glEnd();
            
        gl.glBegin(GL.GL_POLYGON); //Copa da Arvore
        gl.glColor3f(0.0f, 0.39f, 0.0f);
            gl.glVertex2i(100, -50); //p
            gl.glVertex2i(80, -20); //q
            gl.glVertex2i(100, 10); //r
            gl.glVertex2i(140, 10); //s
            gl.glVertex2i(160, -20); //t
            gl.glVertex2i(140, -50); //u
        gl.glEnd();
        
        gl.glPointSize(10);
       gl.glBegin(GL.GL_POINTS);// Frutas da Arvore
       gl.glColor3f(1.0f, 1.0f, 0.0f);
       gl.glVertex2i(110, 0);
       gl.glVertex2i(110, -20);
       gl.glVertex2i(140, -30);
       gl.glVertex2i(140, -10);
       gl.glColor3f(1.0f, 0.0f, 0.0f);
       gl.glVertex2i(100, -10);
       gl.glVertex2i(130, -20);
       gl.glVertex2i(100, -30);
       gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); //faixa1 da estrada
        gl.glColor3f(1.0f, 1.0f, 0.0f);     
            gl.glVertex2i(-10, -190);//p¹  
            gl.glVertex2i(10, -190);//q¹  
            gl.glVertex2i(10, -230);//r¹
            gl.glVertex2i(-10, -230);//s¹
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); //faixa2 da estrada
        gl.glColor3f(1.0f, 1.0f, 0.0f);     
            gl.glVertex2i(-10, -90);//l¹  
            gl.glVertex2i(10, -90);//m¹  
            gl.glVertex2i(10, -150);//n¹
            gl.glVertex2i(-10, -150);//o¹
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); //faixa3 da estrada
        gl.glColor3f(1.0f, 1.0f, 0.0f);     
            gl.glVertex2i(-10, 0);//h¹  
            gl.glVertex2i(10, 0);//i¹  
            gl.glVertex2i(10, -50);//j¹
            gl.glVertex2i(-10, -50);//k¹
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); //faixa4 da estrada
        gl.glColor3f(1.0f, 1.0f, 0.0f);     
            gl.glVertex2i(-10, 80);//d¹  
            gl.glVertex2i(10, 80);//e¹  
            gl.glVertex2i(10, 40);//f¹
            gl.glVertex2i(-10, 40);//g¹
        gl.glEnd();
        
       gl.glBegin(GL.GL_LINE_LOOP);// linha da estrada
        gl.glColor3f(0.0f, 0.0f, 0.0f); 
            gl.glVertex2i(-30, 80);  
            gl.glVertex2i(30, 80);     
            gl.glVertex2i(80, -200);  
            gl.glVertex2i(-80, -200); 
        gl.glEnd();
       
         gl.glBegin(GL.GL_TRIANGLES); ////Montanha de gelo 2
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex2i(-150, 60);  
        gl.glColor3f(0.0f, 1.0f, 1.0f); 
        gl.glVertex2i(-90, 120);
        gl.glVertex2i(-60, 60);
        gl.glEnd();
        
         gl.glBegin(GL.GL_TRIANGLES); ////Montanha de gelo 1
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex2i(-200, 30);  
        gl.glVertex2i(-110, 30);
        gl.glColor3f(0.0f, 1.0f, 1.0f); 
        gl.glVertex2i(-150, 120);
        gl.glEnd();
       
       gl.glBegin(GL.GL_TRIANGLE_FAN); //grama
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex2i(80, -130);//s
        gl.glVertex2i(90, -110);//t
        gl.glVertex2i(100, -130);//b
        gl.glVertex2i(120, -110);//f
        gl.glVertex2i(130, -130);//g
        gl.glEnd();
        
      gl.glBegin(GL.GL_LINE_STRIP);// Linha da grama
       gl.glColor3f(0.0f, 0.0f, 0.0f);
        gl.glVertex2i(80, -130);//s
        gl.glVertex2i(90, -110);//t
        gl.glVertex2i(100, -130);//b
        gl.glVertex2i(120, -110);//f
        gl.glVertex2i(130, -130);//g
       gl.glEnd();
       
       gl.glPointSize(10);
       gl.glBegin(GL.GL_POINTS);// Flor
       gl.glColor3f(1.0f, 1.0f, 0.0f);
       gl.glVertex2i(-130, -70);//g
       gl.glColor3f(1.0f, 0.0f, 0.0f);
       gl.glVertex2i(-130, -60);
       gl.glVertex2i(-138, -70);
       gl.glVertex2i(-122, -70);
       gl.glVertex2i(-130, -80);
       gl.glEnd();
       
       gl.glLineWidth(3);
       gl.glBegin(GL.GL_LINES);// Flor
       gl.glColor3f(0.0f, 0.0f, 0.0f);
       gl.glVertex2i(-130, -90);
       gl.glVertex2i(-130, -140);
       gl.glEnd();
       
        gl.glBegin(GL.GL_QUAD_STRIP); // motinha1
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex2i(-30, -50);//u¹
        gl.glVertex2i(-50, -50);//v¹
        gl.glVertex2i(-30, -70);//a²
        gl.glVertex2i(-50, -70);//z¹
        gl.glColor3f(0.55f, 0.17f, 0.07f);
        gl.glVertex2i(-30, -70);//a²
        gl.glVertex2i(-50, -70);//z¹
        gl.glVertex2i(-30, -90);//w¹
        gl.glVertex2i(-50, -90);//k
        gl.glEnd();
        
        gl.glPointSize(12);
       gl.glBegin(GL.GL_POINTS);// motoqueiro
       gl.glColor3f(0.0f, 0.0f, 0.0f);
       gl.glVertex2i(-40, -70);//q²
       gl.glEnd();
       
       gl.glPointSize(6);
       gl.glBegin(GL.GL_POINTS);// rodas
       gl.glColor3f(0.0f, 0.0f, 0.0f);
       gl.glVertex2i(-40, -90);//t²
       gl.glVertex2i(-40, -50);//i²
       gl.glVertex2i(20, 20);//v²
       gl.glVertex2i(40, 20);//u²
       gl.glVertex2i(20, 0);//w²
       gl.glVertex2i(40, 0);//z²
       gl.glEnd();
       
       gl.glLineWidth(2);
       gl.glBegin(GL.GL_LINES);
       gl.glColor3f(0.0f, 0.0f, 0.0f);
       gl.glVertex2i(-40, -70);//q²
       gl.glVertex2i(-30, -70);//a²
       gl.glEnd();
       
       gl.glLineWidth(2);
       gl.glBegin(GL.GL_LINES);
       gl.glColor3f(0.0f, 0.0f, 0.0f);
       gl.glVertex2i(-40, -70);//q²
       gl.glVertex2i(-50, -70);//z¹
       gl.glEnd();
        
        gl.glBegin(GL.GL_TRIANGLES); //Farol
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertex2i(-50, -40);//g²
        gl.glVertex2i(-30, -40);//h²
        gl.glVertex2i(-40, -50);//i²
        gl.glEnd();
         
        gl.glBegin(GL.GL_TRIANGLE_STRIP); //carrinho2 com trianulo
        gl.glColor3f(0.93f, 0.91f, 0.67f);
        gl.glVertex2i(20, 30);//b²
        gl.glVertex2i(40, 30);//j²
        gl.glVertex2i(30, 10);//f²
        gl.glColor3f(0.93f, 0.91f, 0.67f);
        gl.glVertex2i(40, 30);//j²
        gl.glVertex2i(40, -10);//e²
        gl.glVertex2i(30, 10);//f²
        gl.glColor3f(0.93f, 0.91f, 0.67f);
        gl.glVertex2i(40, -10);//e²
        gl.glVertex2i(20, -10);//c²
        gl.glVertex2i(30, 10);//f²
        gl.glColor3f(0.93f, 0.91f, 0.67f);
        gl.glVertex2i(20, -10);//c²
        gl.glVertex2i(20, 30);//b²
        gl.glVertex2i(30, 10);//f²
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); // Veiculo      
            gl.glColor3f(r, g, b);  
            gl.glVertex2f(vx1,vy1);
            gl.glVertex2f(vx2,vy2);
            gl.glVertex2f(vx3,vy3);
            gl.glVertex2f(vx4,vy4);   
        gl.glEnd();
        
        gl.glPointSize(20);// LUA
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glBegin(GL.GL_POINTS); 
            raio=8f;
            //sx=30f;
            //sy=180f;
            sx=xl;
            sy=yl;
            solx=sx;
            soly=sy;
            gl.glVertex2f(solx,soly);
            for(double i=0; i<360; i++)
            {
                solx=(float) (raio*cos(i));
                solx=solx+sx;
                soly=(float) (raio*sin(i));
                soly=soly+sy;
                gl.glVertex2f(solx,soly); 
            }
        gl.glEnd();
        
        gl.glFlush();
    }
        public void keyPressed(KeyEvent e){
        //Controle dos eventos de teclado
    	System.out.println("Evento do teclado");
	switch(e.getKeyChar())
	{
            case '1': 
                r=0;
                g=0;
                b=0;
                break;
            case '2':
                r=1;
                g=1;
                b=1;
                break;
            case '3':
                r=1;
                g=0;
                b=0;
                break;
            case '4': 
                r=0;
                g=1;
                b=0;
                break;
            case '5':
                r=0;
                g=0;
                b=1;
                break;
            case '6':
                r=1;
                g=1;
                b=0;
                break;
                
                case 'W': //pra cima
                case 'w': //pra cima
                vx1=vx1;  vy1=vy1+5;
                vx2=vx2;  vy2=vy2+5;
                vx3=vx3;  vy3=vy3+5;
                vx4=vx4;  vy4=vy4+5;
                break; 
            case 'D': //pra esquerda
            case 'd': //pra cima
                vx1=vx1+5;  vy1=vy1;
                vx2=vx2+5;  vy2=vy2;
                vx3=vx3+5;  vy3=vy3;
                vx4=vx4+5;  vy4=vy4;
                break; 
            case 'A': //pra direita
            case 'a': //pra direita
                vx1=vx1-5;  vy1=vy1;
                vx2=vx2-5;  vy2=vy2;
                vx3=vx3-5;  vy3=vy3;
                vx4=vx4-5;  vy4=vy4;
                break;
            case 'S': //pra baixo
            case 's': //pra baixo
                vx1=vx1;  vy1=vy1-5;
                vx2=vx2;  vy2=vy2-5;
                vx3=vx3;  vy3=vy3-5;
                vx4=vx4;  vy4=vy4-5;     
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
        public void mousePressed(MouseEvent e) {  
    	System.out.println("Evento do mouse");
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                xl = ((2*200*e.getX())/view_w)-200;
                yl = -((((2*200*e.getY())/view_h))-200);
               
               break;
            case MouseEvent.BUTTON3:
                xl = ((2*200*e.getX())/view_w)-200;
                yl = -(((2*200*e.getY())/view_h)-200);
           
               break;
        }
    }  
public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new ProvaCG());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {
                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }});
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();}


    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    