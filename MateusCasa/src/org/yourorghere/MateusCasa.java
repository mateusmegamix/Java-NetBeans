package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class MateusCasa implements GLEventListener {

    //função que vai inicializar o sistema
     public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.setSwapInterval(1);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glOrtho(-200, 200, -200, 200, -200, 200);
        gl.glMatrixMode(GL.GL_MODELVIEW);
    }
//função que controla mudanças no desenho
public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

//função responsável pelo redimensionamento
public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
}
 //função responsável por fazer o desenho na tela
 public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        gl.glBegin(GL.GL_QUAD_STRIP); // Background
        gl.glColor3f(0.0f, 1.0f, 1.0f);
            gl.glVertex2i(-230, 220);//e² 
            gl.glVertex2i(210, 220);//r¹
            gl.glVertex2i(-230, 70);//v¹
            gl.glVertex2i(210, 70); //d² 
            
        gl.glColor3f(0.0f, 1.0f, 0.0f);
            gl.glVertex2i(-260, -200); //a²
            gl.glVertex2i(240, -200); //w²
            gl.glVertex2i(210, 70); //d² 
            gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); //Parede Principal
            gl.glColor3f(0.0f, 1.0f, 0.0f);    
            gl.glVertex2i(-50, 50);  
            gl.glVertex2i(50, 50);   
            //gl.glColor3f(0.0f, 0.0f, 0.0f);    
            gl.glVertex2i(50, -50);  
            gl.glVertex2i(-50, -50); 
        gl.glEnd();
        
        gl.glBegin(GL.GL_TRIANGLES); //Telhado
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex2i(-50, 50);  
        gl.glVertex2i(50, 50);
        gl.glVertex2i(0, 90);
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); //Telhado usando quadrado
            gl.glColor3f(1.0f, 0.0f, 0.0f);    
            gl.glVertex2i(0, 90);  
            gl.glVertex2i(90, 110);   
            //gl.glColor3f(0.0f, 0.0f, 0.0f);    
            gl.glVertex2i(130, 80);  
            gl.glVertex2i(50, 50); 
        gl.glEnd();
        
        gl.glBegin(GL.GL_TRIANGLE_STRIP); //Parede com triangulo
        gl.glColor3f(1.0f, 1.0f, 0.0f);
        gl.glVertex2i(50, -50);  
        gl.glVertex2i(130, -20);
        gl.glVertex2i(90, 10);
        gl.glVertex2i(50, 50);  
        gl.glVertex2i(90, 10);
        gl.glVertex2i(50, -50);
        gl.glVertex2i(50, 50);  
        gl.glVertex2i(130, 80);
        gl.glVertex2i(90, 10);
        gl.glVertex2i(130, 80);  
        gl.glVertex2i(130, -20);
        gl.glVertex2i(90, 10);
        gl.glEnd();
        
        
         gl.glBegin(GL.GL_TRIANGLES); ////Montanha de gelo 2
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex2i(-150, 40);  
        gl.glColor3f(0.0f, 1.0f, 1.0f); 
        gl.glVertex2i(-90, 120);
        gl.glVertex2i(-60, 40);
        gl.glEnd();
        
         gl.glBegin(GL.GL_TRIANGLES); ////Montanha de gelo 1
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex2i(-200, 30);  
        gl.glVertex2i(-110, 30);
        gl.glColor3f(0.0f, 1.0f, 1.0f); 
        gl.glVertex2i(-150, 120);
        gl.glEnd();
        
        
        
        gl.glBegin(GL.GL_QUADS); //PORTA
            gl.glColor3f(0.0f, 1.0f, 1.0f);    
            gl.glVertex2i(-40, -10);  
            gl.glVertex2i(-20, -10);   
            //gl.glColor3f(0.0f, 0.0f, 0.0f);    
            gl.glVertex2i(-20, -50);  
            gl.glVertex2i(-40, -50); 
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); //Janela
            gl.glColor3f(0.0f, 0.0f, 1.0f);    
            gl.glVertex2i(10, 40);  
            gl.glVertex2i(30, 40);   
            //gl.glColor3f(0.0f, 0.0f, 0.0f);    
            gl.glVertex2i(30, 20);  
            gl.glVertex2i(10, 20); 
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); //Janela
            gl.glColor3f(0.0f, 0.0f, 1.0f);    
            gl.glVertex2i(90, 40);  
            gl.glVertex2i(110, 50);   
            //gl.glColor3f(0.0f, 0.0f, 0.0f);    
            gl.glVertex2i(110, 30);  
            gl.glVertex2i(90, 20); 
        gl.glEnd();
        
        gl.glBegin(GL.GL_POLYGON); //Sol
            gl.glColor3f(1.0f, 1.0f, 0.0f);    
            gl.glVertex2i(30, 190);  
            gl.glVertex2i(50, 180);      
            gl.glVertex2i(50, 160);  
            gl.glVertex2i(30, 150); 
            gl.glVertex2i(10, 160);
            gl.glVertex2i(10, 180); 
        gl.glEnd();
        
        gl.glBegin(GL.GL_LINES);// raios de sol
        gl.glColor3f(1.0f, 0.0f, 0.0f);    
        gl.glVertex2i(-50, 170);
        gl.glVertex2i(-10, 180);
        gl.glVertex2i(-60, 140);
        gl.glVertex2i(-10, 160); 
        gl.glVertex2i(-40, 120);
        gl.glVertex2i(0, 140); 
        gl.glVertex2i(-10, 110);
        gl.glVertex2i(20, 140); 
        gl.glVertex2i(20, 110);
        gl.glVertex2i(30, 140);
        gl.glVertex2i(40, 120);
        gl.glVertex2i(40, 140);
        gl.glEnd();
        
        gl.glBegin(GL.GL_LINE_LOOP);// Caminho
        gl.glVertex2i(-40, -50);//l¹
        gl.glVertex2i(-60, -100);//m¹
        gl.glVertex2i(-80, -150);//n¹
        gl.glVertex2i(-50, -150);//q¹
        gl.glVertex2i(-10, -50);//o¹
        gl.glVertex2i(-40, -50);//l¹
        gl.glEnd();
        
        gl.glBegin(GL.GL_QUADS); //Caminho color
            gl.glColor3f(0.0f, 0.0f, 0.0f);    
            gl.glVertex2i(-40, -50);  
            gl.glVertex2i(-10, -50);   
            //gl.glColor3f(0.0f, 0.0f, 0.0f);    
            gl.glVertex2i(-50, -150);  
            gl.glVertex2i(-80, -150); 
        gl.glEnd();
        
        gl.glBegin(GL.GL_LINE_STRIP);// Linha do telhado
        gl.glVertex2i(0, 90);//l¹
        gl.glVertex2i(50, 50);//m¹
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
       
       gl.glPointSize(5);
       gl.glBegin(GL.GL_POINTS);//Maçaneta
       gl.glColor3f(0.0f, 0.0f, 0.0f);
       gl.glVertex2i(-22, -30);
       gl.glEnd();
       
        gl.glFlush();
    }
public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new MateusCasa());
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
        animator.start();}}

    