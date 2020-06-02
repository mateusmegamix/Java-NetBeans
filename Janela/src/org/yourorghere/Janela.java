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
 * Janela.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
//função que vai inicializar o sistema

public class Janela implements GLEventListener {

public void init(GLAutoDrawable drawable) {
   GL gl = drawable.getGL(); 
   gl.glClearColor(0.0f, 0.0f, 1.0f, 0.0f);
}

//função responsável por fazer o desenho na tela
public void display(GLAutoDrawable drawable) {
   GL gl = drawable.getGL();
   gl.glClear(GL.GL_COLOR_BUFFER_BIT |
                  GL.GL_DEPTH_BUFFER_BIT);
   gl.glFlush ();	   
}
//função que controla mudanças no desenho
public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

//função responsável pelo redimensionamento
public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

//função principal
public static void main(String[] args) {
        Frame frame = new Frame("Primeiro Programa");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new Janela());
frame.add(canvas);
        frame.setSize(800, 640);
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
            }
        });
frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }
}
